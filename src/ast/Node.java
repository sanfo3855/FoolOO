package ast;

import java.util.ArrayList;

import util.Environment;
import util.SemanticError;

/**
 * Interface that define methods that have to be implemented in every node that implement Node
 */
public interface Node {

    /**
     * Prints structure of Node.
     *
     * @param indent parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    String toPrint(String indent);

    //fa il type checking e ritorna:
    //  per una espressione, il suo tipo (oggetto BoolTypeNode o IntTypeNode)
    //  per una dichiarazione, "null"

    /**
     * Check type of Node.
     *
     * @return type of Node
     */
    Node typeCheck();

    /**
     * Generate assembly code for Node.
     *
     * @return string of generated code
     */
    String codeGeneration();

    /**
     * Checks Node's semantic.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    ArrayList<SemanticError> checkSemantics(Environment env);

}