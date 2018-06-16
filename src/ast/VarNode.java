package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VarNode implements Node {

    private String id;
    private Node type;
    private Node value;

    public VarNode (String id, Node type, Node value) {
        this.id=id;
        this.type=type;
        this.value=value;
    }

    public VarNode (String id, Node type){
        this.id = id;
        this.type = type;
    }


    public String toPrint(String s) {

        return s + this.type.toPrint(s + "   ") + "\n" +
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