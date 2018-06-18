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
        return new ArrayList<SemanticError>();
    }

    public String getType(){
        return id;
    }
}  