package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VarDecNode implements Node {

    private String id;
    private Node type;

    public VarDecNode (String id, Node type) {
        this.id=id;
        this.type=type;
    }


    public String toPrint(String s) {

        return s + this.id + "\n" +
                s + this.type.toPrint(s + "  ") + "\n" ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        return type.checkSemantics(env);
    }

    public Node typeCheck() {
        return type.typeCheck();
    }

    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }

}