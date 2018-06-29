package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolNode implements Node {
    private boolean val;
    /**
     * Constructor for BoolNode.
     * It takes 1 parameter:
     * @param val -> boolean value
     */
    public BoolNode(boolean val) {
        this.val=val;
    }
    /**
     * Print structure of BoolNode
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
       if (val)
           return s+"Bool:true\n";
       else
           return s+"Bool:false\n";
    }
    /**
     * Checks BoolNode's semantic
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
        return new BoolTypeNode();
    }
    /**
     * It push the boolean value. 0 or 1
     * @return pushed value
     */
    public String codeGeneration() {
        return "push "+(val?1:0)+"\n";
    }

}