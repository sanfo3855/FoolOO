package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunTypeNode implements Node{

    private ArrayList<Node> listVar;
    private Node returnType;

    /**
     * Constructor fo FunTypeNode.
     *
     * @param listVar --> Function parameters
     * @param returnType --> Function return type
     */
    public FunTypeNode(ArrayList<Node> listVar, Node returnType){
        this.listVar = listVar;
        this.returnType= returnType;
    }

    /**
     * Prints structure of FunTypeNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String varlst="";
        for (Node var:listVar)
            varlst+=var.toPrint(s+"  ");
        return s+"FunTypeNode\n" + varlst + returnType.toPrint(s+"  ") ;
    }

    /**
     *
     * @return returnType node
     */
    public Node getReturn () { //
        return returnType;
    }

    /**
     * Checks FunTypeNode's semantic.
     *
     * @param env -> Environment that holds previously parsed information
     * @return Empty ArrayList of semantic errors
     */
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
    }

    /**
     * Type check is empty because it's a terminal node.
     *
     * @return null
     */
    public Node typeCheck () {
        return null;
    }

    /**
     *
     * @return
     */
    public String codeGeneration() {
        return "";
    }

}
