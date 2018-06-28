package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FactorNode implements Node {

    private Node left;
    private Node right;
    private String operator;

    public FactorNode (Node left, Node right, String operator){
        this.left=left;
        this.right=right;
        this.operator = operator;
    }

    public String toPrint(String s) {
        return s + "LeftFactorNode\n" + left.toPrint(s + "  ") + "\n" ;
               // s + "RightFactorNode\n" + right.toPrint(s + "  ") + "\n";
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        semanticErrors.addAll(left.checkSemantics(env));
        semanticErrors.addAll(right.checkSemantics(env));

        return semanticErrors;
    }

    public Node typeCheck() {
        Node leftNode = left.typeCheck();
        Node rightNode = right.typeCheck();
        if (!(FOOLlib.isSubtype(leftNode, rightNode))||FOOLlib.isSubtype(rightNode,leftNode)){
            System.out.println("Incompatible types in Factor");
            System.exit(0);
        }

        return new BoolTypeNode();
    }

    public String codeGeneration() {
        return left.codeGeneration()+"halt\n";
    }

}