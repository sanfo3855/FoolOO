package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IntNode implements Node {

    private Integer val;

    public IntNode(Integer val) {
        this.val=val;
    }

    public String toPrint(String s) {
        return s+"Int:" + Integer.toString(val) +"\n";
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
    }

    public Node typeCheck() {
        return new IntTypeNode();
    }

    public String codeGeneration() {
        return"push "+val+"\n";
    }

}