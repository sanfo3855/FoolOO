package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FactorNode implements Node {

    private Node left;  //Nodo figlio sinistro
    private Node right; //Nodo figlio destro
    private String operator;    //operatore (>=, <=, ==, &&, ||) del FactorNode
    private String notLeft;     //operatore not (!) prima del left node
    private String notRight;    //operatore not (!) prima del right node

    /**
     * Constructor for ExpNode.
     *
     * It takes 5 parameters:
     * @param left -> left child node
     * @param right -> right child node
     * @param operator -> FactorNode operator (>=, <=, ==, &&, ||)
     * @param notLeft -> not (!) operator before left node
     * @param notRight -> not (!) operator before right node
     */
    public FactorNode (Node left, Node right, String operator, String notLeft, String notRight){
        this.left=left;
        this.right=right;
        this.operator = operator;
        this.notLeft = notLeft;
        this.notRight = notRight;
    }

    /**
     * Prints structure of FactorNode and call toPrint method on every child node
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s + "LeftFactorNode\n" +
                left.toPrint(s + "  ") + "\n"+
               s + "RightFactorNode\n" +
                right.toPrint(s + "  ") + "\n";
    }

    /**
     * Checks FactorNode's semantic and call checkSemantic method on every child Node
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        semanticErrors.addAll(left.checkSemantics(env));
        semanticErrors.addAll(right.checkSemantics(env));

        return semanticErrors;
    }

    /**
     * Check that Left node is subtype of Right node (Left<:Right)
     * and Right node is subtype of Left node (Right<:Left)
     * because (>=, <=, ==, &&, ||) operation needs campatible expression's type.
     *
     * @return instance of BoolTypeNode()
     */
    public Node typeCheck() {
        Node leftNode = left.typeCheck();
        Node rightNode = right.typeCheck();
        if (!(FOOLlib.isSubtype(leftNode, rightNode))||FOOLlib.isSubtype(rightNode,leftNode)){
            /* Stampa un errore di tipo e blocca l'esecuzione */
            System.out.println("Incompatible types in Factor");
            System.exit(0);
        }

        return new BoolTypeNode();
    }

    /**
     * Calls codeGeneration() on Left node,
     * then generates code based on logical operation in operator's field.
     * Right node codeGeneration() is called for every logical operation in the correct position.
     *
     * @return string of generated code
     */
    public String codeGeneration() {

        String cgenString = left.codeGeneration();
        
        /* genera label per il codegen*/
        String trueBranch= FOOLlib.freshLabel();
        String trueBranch_2= FOOLlib.freshLabel();
        String exit = FOOLlib.freshLabel();

        /* switch-case che controlla l'operatore logico
        e genera la stringa di code relativo */
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


        return cgenString;
    }

}