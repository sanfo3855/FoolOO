package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IdNode implements Node {

    private String id;
    private STentry entry;
    private int nestinglevel;

    public IdNode(String id) {
        this.id=id;
    }

    public String toPrint(String s) {
        return s+"Id:" + id + " at nestlev " + nestinglevel +"\n" ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();


        //todo


        return semanticErrors;
    }

    public Node typeCheck() {
        return null;
    }

    public String codeGeneration() {
        return "";
    }

}