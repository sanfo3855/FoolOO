package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VoidTypeNode implements TypeNode {
   /**
   * Constructor for VoidTypeNode.
   */
   public VoidTypeNode() {
   }

    /**
     * Print structure of VoidTypeNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
	return s+"VoidType\n";
  }

    /**
     * Checks VoidTypeNode's semantic.
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
     * return the void type.
     *
     * @return void
     */
    public String getType(){
        return "void";
    }
}  