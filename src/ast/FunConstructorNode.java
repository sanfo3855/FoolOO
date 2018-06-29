package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunConstructorNode implements FunInterfaceNode {

    private String id;
    private Node type;
    private ArrayList<Node> listVar;
    private Node progNode;


    /**
     * Constructor fo Function Constructor Node.
     *
     * @param id --> Constructor name
     * @param listVar --> Constructor parameters
     * @param progNode --> Constructor body
     */
    public FunConstructorNode (String id, ArrayList<Node> listVar, Node progNode) {
        this.id=id;
        this.listVar=listVar;
        this.progNode=progNode;
        this.type=new IdTypeNode(id);
    }

    /**
     * Prints structure of FunConstructorNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "FunConstructorNode" + "\n";
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
     *
     * @return Constructor's name (id)
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return Constructor's type
     */
    public Node getType() {
        return type;
    }

    /**
     *
     * @return ArrayList of Constructor's parameters
     */
    public ArrayList<Node> getListVar() {
        return listVar;
    }

    /**
     * Check FunConstructorNode's semantic and call checkSemantic method on every childNode.
     *
     * Child node: ProgNode and listVar
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        //Arraylist per errori semantici
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        //Creazione nuova entry
        STentry entry = new STentry(env.getNestingLevel(), env.getOffsetDec());

        //Arraylist per lista dei parrametri
        ArrayList<Node> parList = new ArrayList<Node>();

        //Viene creata una nuova hashmap nell'ambiente
        env.addHashMapNL( new HashMap<String, STentry>());

        for (Node node: listVar) {
            //si ottiene il tipo di ciascun parametro del costruttore
            parList.add(((VarDecNode) node).getType());

            //si richiam check semantic per ciascun parametro
            semanticErrors.addAll(node.checkSemantics(env));
        }

        //Aggiunge il tipo nella entry corrente
        entry.addType(new FunTypeNode(parList, type));

        //Viene richiamato il checkSemantics nel corpo del costruttore se != null
        if (progNode!=null) {
            semanticErrors.addAll(progNode.checkSemantics(env));
        }

        //rimuove l'hashmap dall'ambiente
        env.removeHashMapNL();

        return semanticErrors;
    }

    /**
     *  Calls typeCheck() for ProgNode Child.
     *
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
        if (progNode!=null) {
            progNode.typeCheck();
        }
        return new VoidTypeNode();
    }

    /**
     *
     * @return
     */
    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }
}
