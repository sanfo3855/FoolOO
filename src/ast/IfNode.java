package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IfNode implements Node {

    private Node cond;
    private Node thenBranch;
    private Node elseBranch;

    public IfNode(Node cond, Node thenBranch, Node elseBranch) {
        this.cond = cond;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public IfNode(Node cond, Node thenBranch) {
        this.cond = cond;
        this.thenBranch = thenBranch;
    }

    public String toPrint(String s) {
        String returnString = s + "IfNodeCond\n" + cond.toPrint("  ") +"\n" +
                s + "IfNodeThenBranch\n" + thenBranch.toPrint("  ") +"\n";
        if(this.elseBranch!=null){
            returnString += s + "IfNodeElseBranch\n" + cond.toPrint("  ") +"\n";
        }
        return returnString;

    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        return cond.checkSemantics(env);
    }

    public Node typeCheck() {
        return cond.typeCheck();
    }

    public String codeGeneration() {
        return cond.codeGeneration()+"halt\n";
    }

}