package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IfNode implements Node {

    private Node cond;
    private Node thenBranch;
    private Node elseBranch;

    public IfNode(Node cond, Node thenBranch, Node elseBranch) {
        this.cond = cond;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public IfNode(Node cond, Node thenBranch) {
        this.cond = cond;
        this.thenBranch = thenBranch;
    }

    public String toPrint(String s) {
        String returnString = s + "IfNodeCond\n" + s + cond.toPrint("  ") +"\n" +
                s + "IfNodeThenBranch\n" + s + thenBranch.toPrint("  ") +"\n";
        if(this.elseBranch!=null){
            returnString += s + "IfNodeElseBranch\n" + s +cond.toPrint("  ") +"\n";
        }
        return returnString;

    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        semanticErrors.addAll(cond.checkSemantics(env));
        semanticErrors.addAll(thenBranch.checkSemantics(env));
        if(elseBranch!=null){
            semanticErrors.addAll(elseBranch.checkSemantics(env));
        }

        return semanticErrors;
    }

    public Node typeCheck() {
        Node nodo=null;
        if (!(FOOLlib.isSubtype(cond.typeCheck(),new BoolTypeNode()))) {
            System.out.println("non boolean condition in if");
            System.exit(0);
        }
        Node thenB = thenBranch.typeCheck();
        Node elseB = elseBranch.typeCheck();
        if (FOOLlib.isSubtype(thenB,elseB))
            nodo= elseB;
        if (FOOLlib.isSubtype(elseB,thenB))
            nodo= thenB;
        if(nodo==null) {
            System.out.println("Incompatible types in then else branches");
            System.exit(0);
        }
        return nodo;
    }

    public String codeGeneration() {
        return cond.codeGeneration()+"halt\n";
    }

}