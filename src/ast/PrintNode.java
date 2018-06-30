package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class PrintNode implements Node{

    private Node exp;

    public PrintNode(Node exp) {
        this.exp = exp;
    }


    public String toPrint(String s) {
        return s + exp.toPrint(s + "   ");
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return exp.checkSemantics(env);
    }

    public Node typeCheck() {
        exp.typeCheck();
        return new VoidTypeNode();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}

