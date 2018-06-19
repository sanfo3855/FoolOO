package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IdTypeNode implements TypeNode {

    String id;

    public IdTypeNode(String id) {
        this.id=id;
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

        int j = env.getNestingLevel();
        STentry tmpEntry = null;
        while (j >= 0 && tmpEntry == null) {
            tmpEntry = env.getHashMapNL(j--).get("class%"+id);
        }
        if (tmpEntry == null) {
            semanticErrors.add(new SemanticError("Class Id " + id + " is not declared"));
        }

        return semanticErrors;
    }


    public String getType(){
        return id;
    }
}  