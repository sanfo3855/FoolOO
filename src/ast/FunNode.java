package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunNode  implements Node {

    private String id;
    private Node type;

    public FunNode (String i, Node t) {
        id=i;
        type=t;
    }

    public String toPrint(String s) {

        return "Start\n" + type.toPrint("  ") ;
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