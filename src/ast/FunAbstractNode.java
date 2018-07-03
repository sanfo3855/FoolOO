package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface that extends Node and define new methods
 * that have to be implemented in every node that implement FunAbstractNode
 */
public class FunAbstractNode implements Node {
    protected String id;
    protected Node type;
    protected ArrayList<Node> listVar;
    protected Node progNode;
    protected Node retNode;

    public FunAbstractNode(String id, Node type, ArrayList<Node> listVar, Node progNode, Node retNode) {
        this.id=id;
        this.type=type;
        this.listVar=listVar;
        this.progNode=progNode;
        this.retNode=retNode;
    }

    /**
     *
     * @return Function's ID
     */
    String getId(){
        return id;
    }

    /**
     *
     * @return instance of TypeNode that represent node's type
     */
    Node getType(){
        return type;
    }

    /**
     *
     * @return Node's ArrayList variables
     */
    ArrayList<Node> getListVar(){
        return listVar;
    }
    /**
     * Prints structure of FunctionNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + this.getClass().toString().split("ast.")[1]+ "\n";
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

    @Override
    public String codeGeneration() {
        return null;
    }
}
