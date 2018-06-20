package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class TermNode implements Node {

    private Node left;
    private Node right;

    public TermNode (Node left, Node right) {
        this.left=left;
        this.right=right;
    }

    public String toPrint(String s) {
        return s + "LeftTernNode\n" + left.toPrint(s +"  ") + "\n" ;
                //s + "RightTermNode\n" + right.toPrint(s + "  ") + "\n";
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        semanticErrors.addAll(left.checkSemantics(env));
        semanticErrors.addAll(right.checkSemantics(env));

        return semanticErrors;
    }

    public Node typeCheck() {
        if (! ( FOOLlib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
                FOOLlib.isSubtype(right.typeCheck(),new IntTypeNode()) ) ) {
            System.out.println("Operations are allowed only between integers");
            System.exit(0);
        }
        return new IntTypeNode();
    }

    public String codeGeneration() {
        return left.codeGeneration()+"halt\n";
    }

}