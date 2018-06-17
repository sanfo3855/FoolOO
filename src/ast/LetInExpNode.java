package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class LetInExpNode implements Node {

    private ArrayList<Node> listDec;
    private Node exp;

    public LetInExpNode (ArrayList<Node> listDec, Node exp) {
        this.listDec=listDec;
        this.exp=exp;
    }

    public String toPrint(String s) {
        String returnString = s + "LetInExpNode" + "\n";
        for(Node ntp : listDec){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        returnString += s + this.exp.toPrint(s + "   ") + "\n";
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