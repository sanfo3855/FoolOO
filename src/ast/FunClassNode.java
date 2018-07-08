package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunClassNode  extends FunAbstractNode {
    /**
     * Constructor for FunctionNode.
     *
     * @param id --> Function name
     * @param type --> Function type
     * @param listVar --> Function parameters
     * @param progNode --> Function body program
     * @param retNode --> Function return node
     */
    public FunClassNode (String id, Node type, ArrayList<Node> listVar, Node progNode, Node retNode) {
        super(id, type, listVar, progNode, retNode);
    }

    @Override
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

        //Arraylist per lista dei parametri
        ArrayList<Node> parList = new ArrayList<Node>();

        HashMap<String,STentry> entryHashMap = new HashMap<String,STentry> ();
        //Viene creata una nuova hashmap nell'ambiente
        env.addHashMapNL(entryHashMap);
        STentry entryListVar;
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
            if (progNode instanceof LetInExpNode && (!id.equals("main"))){
                ((LetInExpNode) progNode).setOffset(offsetListVar-1);
            }
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
     *
     * @return
     */
    public String codeGeneration() {
        String popDec="";
        if (progNode instanceof LetInExpNode){
            for (int i=0; i<((LetInExpNode)progNode).getListDecSize();i++){
                popDec+="pop\n";
            }
        }
        String popVar="";
        for (Node dec:listVar){
            popVar+="pop\n";
        }
        String funl=FOOLlib.freshFunLabel();

        String retCod="";
        if(retNode!=null){
            retCod=retNode.codeGeneration();
        }else{
            retCod="push 0\n";
        }
        String progCod="";
        if (progNode!=null){
            progCod=progNode.codeGeneration();
        }

        FOOLlib.putCode(funl+":\n"+
                "cfpp\n"+ //setta $fp a $sp
                "lra\n"+ //inserimento return address
                progCod+
                retCod+
                "srv\n"+ //pop del return value
                popDec+
                "sra\n"+ // pop del return address
                "pop\n"+ // pop di AL
                popVar+
                "sfp\n"+  // setto $fp a valore del CL
                "lrv\n"+ // risultato della funzione sullo stack
                "lra\n"+
                "js\n" // salta a $ra
        );

        return "push "+ funl +"\n";
    }

}