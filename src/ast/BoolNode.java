package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class BoolNode implements Node {
    private boolean val;

    public BoolNode(boolean val) {
        this.val=val;
    }

    public String toPrint(String s) {
       if (val)
           return s+"Bool:true\n";
       else
           return s+"Bool:false\n";
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return new ArrayList<SemanticError>();
    }

    public Node typeCheck() {
        return new BoolTypeNode();
    }

    public String codeGeneration() {
        return "push "+(val?1:0)+"\n";
    }

}