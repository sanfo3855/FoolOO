package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FactorNode implements Node {

    private Node left;
    private Node right;
    private String operator;
    private String notLeft;
    private String notRight;

    public FactorNode (Node left, Node right, String operator, String notLeft, String notRight){
        this.left=left;
        this.right=right;
        this.operator = operator;
        this.notLeft = notLeft;
        this.notRight = notRight;
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
        String cgenString = left.codeGeneration();
        if (right != null) {
            String trueBranch= FOOLlib.freshLabel();
            String trueBranch_2= FOOLlib.freshLabel();
            String exit = FOOLlib.freshLabel();
            switch (operator){
                case ("=="):
                    cgenString+= right.codeGeneration();
                    cgenString+= "beq "+ trueBranch+"\n"+
                                 "push 0\n"+
                                 "b "+ exit +"\n"+
                                 trueBranch+":\n"+
                                    "push 1\n"+
                                 exit+":\n";
                    break;
                case (">="):
                    cgenString+= right.codeGeneration();
                    cgenString+= "bgeq "+ trueBranch+"\n"+
                                 "push 0\n"+
                                 "b "+ exit +"\n"+
                                 trueBranch+":\n"+
                                    "push 1\n"+
                                 exit+":\n";
                    break;
                case ("<="):
                    cgenString+= right.codeGeneration();
                    cgenString+= "bleq "+ trueBranch+"\n"+
                                 "push 0\n"+
                                 "b "+ exit +"\n"+
                                 trueBranch+":\n"+
                                    "push 1\n"+
                                 exit+":\n";
                    break;
                case ("&&"):
                    cgenString+= "push 0\n" +
                                 "beq "+ trueBranch+"\n"+
                                 right.codeGeneration() + "push 0\n"+
                                 "beq "+ trueBranch_2+"\n"+
                                 "push 1\n"+
                                 "b "+ exit +"\n"+
                                 trueBranch+":\n"+
                                        "push 0\n"+
                                        "b "+ exit +"\n"+
                                 trueBranch_2+":\n"+
                                        "push 0\n"+
                                 exit+":\n";
                    break;
                case("||"):
                    cgenString+= "push 1\n" +
                                 "beq "+ trueBranch+"\n"+
                                 right.codeGeneration() + "push 1\n"+
                                 "beq "+ trueBranch_2+"\n"+
                                 "push 0\n"+
                                 "b "+ exit +"\n"+
                                 trueBranch+":\n"+
                                    "push 1\n"+
                                    "b "+ exit +"\n"+
                                 trueBranch_2+":\n"+
                                    "push 1\n"+
                                 exit+":\n";
                    break;
            }
        }

        return cgenString;
    }

}