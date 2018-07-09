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

    /**
     * Calls checkSemantic on child node.
     * @param env -> Environment that holds previously parsed information
     * @return
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        return exp.checkSemantics(env);
    }

    /**
     * Calls typeCheck on child node
     * @return VoidTypeNode()
     */
    public Node typeCheck() {
        exp.typeCheck();
        return new VoidTypeNode();
    }

    /**
     *
     * @return string of generated code
     */
    public String codeGeneration() {
        return exp.codeGeneration()+"print\n";
    }

}

