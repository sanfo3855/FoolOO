package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VoidTypeNode implements TypeNode {

  public VoidTypeNode() {
  }
  
  public String toPrint(String s) {
	return s+"VoidType\n";
  }
  
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
    }

    public String getType(){
        return "void";
    }

    public Node typeCheck() {
      return null;
    }

    public String codeGeneration() {
      return "";
    }
}  