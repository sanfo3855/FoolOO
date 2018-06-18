package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IdNode implements Node {

    //TODO da togliere
    private Node exp;

    private String id;
    private STentry entry;
    private int nestinglevel;

    public IdNode(String id) {
        this.id=id;
    }

    public String toPrint(String s) {
        return s+"Id:" + id + " at nestlev " + nestinglevel +"\n" + entry.toPrint(s+"  ");
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