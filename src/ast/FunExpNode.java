package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunExpNode implements Node {

    private ArrayList<Node> listParam;

    //TODO non serve
    private Node exp;

    public FunExpNode (ArrayList<Node> listParam) {
        this.listParam = listParam;
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