package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VarNode implements Node {

    private Node varDec;
    private Node value;

    public VarNode (Node varDec, Node value) {
        this.varDec=varDec;
        this.value=value;
    }

    public VarNode (Node varDec){
        new VarNode(varDec, null);
    }


    public String toPrint(String s) {

        return s + this.varDec.toPrint(s + "   ") + "\n" +
                s + this.value.toPrint(s + "  ") + "\n" ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        return value.checkSemantics(env);
    }

    public Node typeCheck() {
        return value.typeCheck();
    }

    public String codeGeneration() {
        return value.codeGeneration()+"halt\n";
    }

}