package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IdTypeNode implements Node {

  public IdTypeNode() {
  }
  
  public String toPrint(String s) {
	return s+"IdType\n";
  }

  public Node typeCheck() {
    return null;
  }

  public String codeGeneration() {
		return "";
  }
  
  @Override
	public ArrayList<SemanticError> checkSemantics(Environment env) {
      ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();


      //todo


      return semanticErrors;
	}
  
}  