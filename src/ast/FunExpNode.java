package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunExpNode implements Node {

    private String id;
    private ArrayList<Node> listParam;
    private STentry entry;
    private int nestinglevel;

    public FunExpNode (String id, ArrayList<Node> listParam) {
        this.id =id;
        this.listParam = listParam;
    }

    public String toPrint(String s) {
        String returnString = s + "FunExpNode" + "\n";
        for(Node ntp : listParam){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
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