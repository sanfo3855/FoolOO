package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FunNode  extends FunAbstractNode {
    /**
     * Constructor for FunctionNode.
     *
     * @param id --> Function name
     * @param type --> Function type
     * @param listVar --> Function parameters
     * @param progNode --> Function body program
     * @param retNode --> Function return node
     */
    public FunNode (String id, Node type, ArrayList<Node> listVar, Node progNode, Node retNode) {
        this.id=id;
        this.type=type;
        this.listVar=listVar;
        this.progNode=progNode;
        this.retNode=retNode;
    }

    /**
     * Prints structure of FunctionNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "FunNode" + "\n";
        for(Node ntp : this.listVar){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        if (progNode!=null){
            //Aggiunge il corpo del programma alla stringa da stampare
            returnString += s + this.progNode.toPrint(s + "   ");
        }

        return returnString;
    }

    /**
     * Check FunctionNode's semantic and call checkSemantic method on every childNode.
     *
     * Child node: listVar, ProgNode and retNode
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        //Creazione nuova entry
//        STentry entry = new STentry(env.getNestingLevel(), env.getOffsetDec());
//
//        HashMap<String,STentry> hashMapNL = env.getHashMapNL (env.getNestingLevel());
//        //genero l'identificatore della funzione
//        String temp="%"+((TypeNode)type).getType();
//        for(Node node:listVar){
//            temp+="%"+((TypeNode)((VarDecNode) node).getType()).getType();
//        }
//
//        /*
//        Rimuovo la riga corrispondente alla funzione parsata dall'hashMap del
//        livello 0 ed la sostituisco con una nuova riga con chiave uguale
//        ma entry diversa. Ciò è fatto per rettificare l'offset.
//         */
//        hashMapNL.remove("fun#"+id+temp);
//        hashMapNL.put("fun#"+id+temp, entry);

        //Arraylist per lista dei parametri
        ArrayList<Node> parList = new ArrayList<Node>();

        HashMap<String,STentry> entryHashMap = new HashMap<String,STentry> ();
        //Viene creata una nuova hashmap nell'ambiente
        env.addHashMapNL(entryHashMap);
        STentry entryListVar = null;
        int offsetListVar=0;
        for (Node node: listVar) {
            VarDecNode varDecNode = (VarDecNode) node;
            //Si ottiene il tipo di ciascun parametro
            parList.add(varDecNode.getType());
            entryListVar=new STentry(env.getNestingLevel(),varDecNode.getType(),offsetListVar--);
            if ( entryHashMap.put(varDecNode.getId(),entryListVar) != null  ){
                semanticErrors.add(new SemanticError("Parameter id "+varDecNode.getId()+" already declared"));
            }
        }

        //Aggiunto il tipo nella entry corrente
//        entry.addType(new FunTypeNode(parList, type));

        //Viene richiamato il checkSemantics nel corpo della funzione se != null
        if (progNode!=null) {
            semanticErrors.addAll(progNode.checkSemantics(env));
        }

        //Viene richiamato il checkSemantics nel return della funzione se != null
        if(retNode!=null){
            semanticErrors.addAll(retNode.checkSemantics(env));
        }else{
            //Errore nel ritorno se type non è void
            if (!(type instanceof VoidTypeNode)){
                semanticErrors.add(new SemanticError("Missing return"));
            }
        }

        //Rimuove l'hashMap dall'ambiente
        env.removeHashMapNL();
        return semanticErrors;
    }

    /**
     * Calls typeCheck for ProgNode Child and Check that return type is subtype of function type.
     *
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
        if (progNode!=null) {
            progNode.typeCheck();
        }
        if(retNode!=null){
            //Sottotipo tra tipo funzione e return
            if( !FOOLlib.isSubtype(retNode.typeCheck(),type) ){
                System.out.println("Wrong return type for function " + id );
                System.exit(0);
            }
        }
        return new VoidTypeNode();
    }

}