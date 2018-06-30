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
     *
     * @return Function's name (id)
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return Function's type
     */
    public Node getType() {
        return type;
    }

    /**
     *
     * @return Arraylist of Function's parameters
     */
    public ArrayList<Node> getListVar() {
        return listVar;
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

    /**
     *
     * @return
     */
    public String codeGeneration() {
        //todo
        return type.codeGeneration()+"halt\n";
    }

}