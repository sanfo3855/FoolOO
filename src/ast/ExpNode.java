package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ExpNode implements Node {

    private Node left;
    private Node rigth;

    public ExpNode (Node left,Node rigth) {
        this.left=left;
        this.rigth=rigth;
    }

    public String toPrint(String s) {

        return "Left\n" + left.toPrint("  ") +
                "Rigth\n" + rigth.toPrint("  ");
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