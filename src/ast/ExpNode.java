package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ExpNode implements Node {

    private Node left;
    private Node right;
    private String operator;

    public ExpNode (Node left,Node right, String operator) {
        this.left=left;
        this.right=right;
        this.operator=operator;
    }

    public String toPrint(String s) {
        String retString="";
        retString += s + "LeftExpNode\n" +
                s + left.toPrint(s +"  ") + "\n";
        if(right!=null){
            retString += s + s + operator + "\n" +
                    s + s + "RightExpNode\n" +
                    s + right.toPrint(s + "  ") + "\n";
        }
        return retString;

    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        semanticErrors.addAll(left.checkSemantics(env));
        if(right!=null) {
            semanticErrors.addAll(right.checkSemantics(env));
        }

        return semanticErrors;
    }

    public Node typeCheck() {
        if(right!=null) {
            if (!(FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode()) || FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode()))) {
                System.out.println("Operations are allowed only between integers");
                System.exit(0);
            }
        }
        return new IntTypeNode();
    }

    public String codeGeneration() {
        String cgenString = left.codeGeneration();
        if(right!=null){
            cgenString += right.codeGeneration();
            if(operator.equals("+")){
                cgenString += "add\n";
            } else {
                cgenString += "sub\n";
            }
        }
        return cgenString;
    }

}