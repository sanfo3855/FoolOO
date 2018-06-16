package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FactorNode implements Node {

    private Node left;
    private Node right;

    public FactorNode (Node l, Node r)
    {
        left=l;
        right=r;
    }

    public String toPrint(String s) {

        return "Start\n" + left.toPrint("  ") ;
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