package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class SingleExpNode implements Node {

    private Node exp;

    public SingleExpNode (Node e) {
        exp=e;
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