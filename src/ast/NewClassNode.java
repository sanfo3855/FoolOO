package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class NewClassNode implements Node{
    private String id;
    private ArrayList<String> listPar;

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

