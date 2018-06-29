package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolTypeNode implements TypeNode {

    /**
     * Constructor for BoolTypeNode.
     */
    public BoolTypeNode() {
    }

    /**
     * Print structure of BoolTypeNode
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s+"BoolType\n";
    }

    /**
     * Checks BoolTypeNode's semantic
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
        return null;
    }

    /**
     * It's a terminal Node, than the codeGeneration is empty.
     *
     * @return Empty String
     */
    public String codeGeneration() {
        return "";
    }

    /**
     *
     * @return bool type
     */
    public String getType(){
        return "bool";
    }
}  