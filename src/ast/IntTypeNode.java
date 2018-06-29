package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IntTypeNode implements TypeNode {
    /**
     * Constructor for IntTypeNode.
     */
    public IntTypeNode() {
    }

    /**
     * Print structure of IntTypeNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s+"IntType\n";
    }

    /**
     * Checks IntTypeNode's semantic.
     *
     * @param env -> Environment that holds previously parsed information
     * @return Empty ArrayList of semantic errors
     */
    @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
	}

	/**
     *
     * @return int type
     */
    public String getType(){
        return "int";
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
}  