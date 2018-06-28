package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class TermNode implements Node {

    private Node left;
    private Node right;
    private String operator;
    //TODO toPrint da correggere e finire TIMES and DIV
    public TermNode (Node left, Node right) {
        this.left=left;
        this.right=right;
    }

    public String toPrint(String s) {
        String returnString = s + "LeftTermNode\n" + s + left.toPrint(s +"  ") + "\n";
        if(right!=null){
            returnString += s + operator + "\n" +
                    s + "RightTermNode\n"+ s + right.toPrint(s + "  ") + "\n";
        }
        return returnString;
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
        return left.codeGeneration()+
                right.codeGeneration()+
                "\n";
    }

}