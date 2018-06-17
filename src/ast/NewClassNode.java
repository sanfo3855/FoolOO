package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class NewClassNode implements Node{
    private String id;
    private ArrayList<String> listPar;

    //TODO non serve
    private Node exp;

    public NewClassNode (String id, ArrayList<String> listPar) {
        this.id = id;
        this.listPar = listPar;
    }


    public String toPrint(String s) {
        String returnString = s + "NewClassNode\n";
        for(String ntp : listPar){
            returnString += s + ntp + "\n";
        }
        return returnString;
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
