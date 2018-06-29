package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class TermNode implements Node {

    private Node left;
    private Node right;
    private String operator;

    /**
     * Constructor for TermNode.
     *
     * @param left --> Left node
     * @param right --> Right node
     * @param operator --> Operator tha indicates the operation between the nodes
     */
    public TermNode (Node left, Node right, String operator) {
        this.left=left;
        this.right=right;
        this.operator = operator;
    }

    /**
     * Print structure of TermNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "LeftTermNode\n" + s + left.toPrint(s +"  ") + "\n"  + s + operator + "\n" +
                              s + "RightTermNode\n"+ s + right.toPrint(s + "  ") + "\n";

        return returnString;
    }

    /**
     * Check TermNode's semantic and call checkSemantic method on every childNode.
     *
     * Child node: ProgNode and listVar.
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        //richiama il checkSemantic per ciascun nodo (left e right)
        semanticErrors.addAll(left.checkSemantics(env));
        semanticErrors.addAll(right.checkSemantics(env));

        return semanticErrors;
    }
    /**
     * Check that the nodes are subtypes of IntTypeNode.
     *
     * @return instance of IntTypeNode()
     */
    public Node typeCheck() {
        if (! ( FOOLlib.isSubtype(left.typeCheck(),new IntTypeNode()) &&
                FOOLlib.isSubtype(right.typeCheck(),new IntTypeNode()) ) ) {
            System.out.println("Operations are allowed only between integers");
            System.exit(0);
        }
        return new IntTypeNode();
    }

    /**
     * Generates assembly code based on logical operator and call codeGeneration on each Node.
     *
     * @return updated string with assembly code.
     */
    public String codeGeneration() {
        //Viene popolata la stringadi ritorno del metodo
        String cgenString = left.codeGeneration() + right.codeGeneration();
            if(operator.equals("*")){
                cgenString += "mult\n";
            } else {
                cgenString += "div\n";
            }
        return cgenString;
    }

}