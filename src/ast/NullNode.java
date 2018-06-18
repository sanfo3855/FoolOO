package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class NullNode implements Node {

    //TODO da togliere
    private Node exp;

    private Object val;

    public NullNode() {
        this.val = null;
    }

    public String toPrint(String s) {

        return "Null\n " ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
    }

    public Node typeCheck() {
        return exp.typeCheck();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}