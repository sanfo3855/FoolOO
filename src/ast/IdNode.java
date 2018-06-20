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

        int j=env.getNestingLevel();
        STentry tmpEntry=null;
        while (j>=0 && tmpEntry==null){
            tmpEntry = env.getHashMapNL(j--).get(id);
        }
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("Class Id " + id + " is not declared"));
        } else {
            entry = tmpEntry;
            nestinglevel = env.getNestingLevel();
        }

        return semanticErrors;
    }

    public Node typeCheck() {
        //todo
        return null;
    }

    public String codeGeneration() {
        return "";
    }

}