package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class DecclassNode implements Node {

    private String id;
    private String idExt;
    private ArrayList<Node> listVar;

    //TODO non serve
    private Node exp;


    public DecclassNode (String id, ArrayList<Node> listVar, String idExt) {
        this.id = id;
        this.idExt= idExt;
        this.listVar = listVar;
    }
    public DecclassNode (String id, ArrayList<Node> listVar) {
        new DecclassNode(id,listVar,"object");
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