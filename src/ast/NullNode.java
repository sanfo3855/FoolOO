package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class NullNode implements Node {

    private Object val;

    /**
     * Constructor for NullNode.
     */
    public NullNode() {
        this.val = null;
    }

    /**
     * Print structure of NullNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {

        return s+"Null\n " ;
    }

    /**
     * Checks NullNode's semantic.
     *
     * @param env -> Environment that holds previously parsed information
     * @return Empty ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
    }
    /**
     * Type check is empty because it's a terminal node.
     *
     * @return null
     */
    public Node typeCheck() {
        return new NullNode();
    }

    /**
     * It's a terminal Node, than the codeGeneration is empty.
     *
     * @return Empty String
     */
    public String codeGeneration() {
        return "push 0\n";
    }

}