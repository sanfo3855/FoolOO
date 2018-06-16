package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ExpNode implements Node {

    private Node left;
    private Node right;

    public ExpNode (Node left,Node right) {
        this.left=left;
        this.right=right;
    }

    public String toPrint(String s) {
        return s + "LeftExpNode\n" + left.toPrint(s +"  ") + "\n" +
                s + "RightExpNode\n" + right.toPrint(s + "  ") + "\n";
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        return left.checkSemantics(env);
    }

    public Node typeCheck() {
        return left.typeCheck();
    }

    public String codeGeneration() {
        return left.codeGeneration()+"halt\n";
    }

}