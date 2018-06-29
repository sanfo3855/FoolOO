package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class ExpNode implements Node {

    private Node left;  //Nodo figlio sinistro
    private Node right; //Nodo figlio destro
    private String operator;    //operatore (+ o -) dell'ExpNode

    /**
     * Constructor for ExpNode.
     *
     * @param left -> Left child Node
     * @param right -> right child Node
     * @param operator -> Exp operator (+ or -)
     */
    public ExpNode (Node left,Node right, String operator) {
        this.left=left;
        this.right=right;
        this.operator=operator;
    }

    /**
     * Prints structure of ExpNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {

        String retString="";

        retString += s + "LeftExpNode\n" +
                s + left.toPrint(s +"  ") + "\n"+
                s + s + operator + "\n" +
                s + s + "RightExpNode\n" +
                s + right.toPrint(s + "  ") + "\n";

        return retString;

    }

    /**
     * Checks ExpNode's semantic calling checkSemantic method on every child Node.
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
     * Check that left and right nodes are subtype of IntType
     * because + or - operation needs IntType operators.
     *
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
        if (!(FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode()) || FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode()))) {
            /* Stampa un errore di tipo e blocca l'esecuzione */
            System.out.println("Operations are allowed only between integers");
            System.exit(0);
        }
        return new IntTypeNode();
    }

    /**
     * Calls codeGeneration() on left and right node.
     * Left return's string is concatenated with right's,
     * then with "add" or "sub" assembly operator based on node's operator field.
     *
     * @return string of generated code
     */
    public String codeGeneration() {

        String cgenString = left.codeGeneration() + right.codeGeneration();

        /* check operator field */
        if(operator.equals("+")){
            cgenString += "add\n";
        } else {
            cgenString += "sub\n";
        }

        return cgenString;
    }

}