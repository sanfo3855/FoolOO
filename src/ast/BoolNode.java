package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolNode implements Node {

    //TODO da togliere
    private Node exp;

    private boolean val;

    public BoolNode(boolean val) {
        this.val=val;
    }

    public String toPrint(String s) {

        return "Start\n" + exp.toPrint("  ") ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        return exp.checkSemantics(env);
    }

    public Node typeCheck() {
        return exp.typeCheck();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}