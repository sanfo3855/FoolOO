package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IntNode implements Node {

    private Integer val;

    /**
     * Constructor for IntNode.
     * It takes 1 parameter:
     * @param val -> integer value
     */
    public IntNode(Integer val) {
        this.val=val;
    }

    /**
     * Print structure of IntNode
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s+"Int:" + Integer.toString(val) +"\n";
    }

    /**
     * Checks IntNode's semantic
     * @param env -> Environment that holds previously parsed information
     * @return Empty ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
    }

    /**
     * Type check is empty because it's a terminal node
     * @return instance of BoolTypeNode()
     */
    public Node typeCheck() {
        return new IntTypeNode();
    }

    /**
     * It push the integer value. 0 or 1
     * @return pushed value
     */
    public String codeGeneration() {
        return"push "+val+"\n";
    }

}