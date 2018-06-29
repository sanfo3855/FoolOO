package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunNode  implements FunInterfaceNode {

    private String id;
    private Node type;
    private ArrayList<Node> listVar;
    private Node progNode;
    private Node retNode;

    /**
     * Constructor for FunctionNode
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
     * Prints structure of FunctionNode
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
     * Method that return Function's name
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Method that return Function's type
     * @return type
     */
    public Node getType() {
        return type;
    }

    /**
     * Method that return Function's parameters
     * @return listVar --> Parameters arraylist
     */
    public ArrayList<Node> getListVar() {
        return listVar;
    }

    /**
     * Check FunctionNode's semantic and call checkSemantic method on every childNode,
     * Child node: ProgNode and listVar
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //Arraylist per errori semantici
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //Creazione nuova entry
        STentry entry = new STentry(env.getNestingLevel(), env.getOffsetDec());
        //Arraylist per lista dei parametri
        ArrayList<Node> parList = new ArrayList<Node>();
        //Viene creata una nuova hashmap nell'ambiente
        env.addHashMapNL( new HashMap<String, STentry>());

        for (Node node: listVar) {
            //Si ottiene il tipo di ciascun parametro
            parList.add(((VarDecNode) node).getType());
            //Richiamato checkSemantics per ciascun nodo parametro
            semanticErrors.addAll(node.checkSemantics(env));
        }
        //Aggiunto il tipo nella entry corrente
        entry.addType(new FunTypeNode(parList, type));
        //Viene richiamato il checkSemantics nel corpo della funzione se != null
        if (progNode!=null) {
            semanticErrors.addAll(progNode.checkSemantics(env));
        }
        //Viene richiamato il checkSemantics nel return della funzione se != null
        if(retNode!=null){
            semanticErrors.addAll(retNode.checkSemantics(env));
        }else{
            if (!(type instanceof VoidTypeNode)){//Errore nel ritorno se != void
                semanticErrors.add(new SemanticError("Missing return"));
            }
        }
        //Rimuove l'hashMap dall'ambiente
        env.removeHashMapNL();
        return semanticErrors;
    }

    /**
     * Check that return is subtype of function type. It call typeCheck for ProgNode Child.
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
        if (progNode!=null) {
            progNode.typeCheck();
        }
        if(retNode!=null){
            //Sottotipo tra tipo funzione e return
            if( !FOOLlib.isSubtype(type, retNode.typeCheck()) ){
                System.out.println("Wrong return type for function " + id );
                System.exit(0);
            }
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