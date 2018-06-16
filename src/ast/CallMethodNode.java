package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.Map;

public class CallMethodNode implements Node {

    private String id;
    private Map<String, ArrayList<Node>> listField;

    //TODO non serve
    private Node exp;

    public CallMethodNode (String id, Map<String, ArrayList<Node>> listField) {
        this.id =id;
        this.listField=listField;
    }

    public String toPrint(String s) {

        return "Start\n" + exp.toPrint("  ") ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        return exp.checkSemantics(env);
    }

    public Node typeCheck() {
        return exp.typeCheck();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}