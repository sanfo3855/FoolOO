package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class AsmNode implements Node {

    private String id;
    private Node value;

    public AsmNode(String id, Node value) {
        this.id=id;
        this.value=value;
    }

    public String toPrint(String s) {

        return "AsmNode\n" + id ;
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