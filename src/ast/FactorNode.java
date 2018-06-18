package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FactorNode implements Node {

    private Node left;
    private Node right;

    public FactorNode (Node left, Node right){
        this.left=left;
        this.right=right;
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
        return left.typeCheck();
    }

    public String codeGeneration() {
        return left.codeGeneration()+"halt\n";
    }

}