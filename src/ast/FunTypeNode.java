package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunTypeNode implements Node{

    private ArrayList<Node> listVar;
    private Node ret;

    public FunTypeNode(ArrayList<Node> listVar, Node ret){
        this.listVar = listVar;
        this.ret= ret;
    }
    public String toPrint(String s) { //
        String varlst="";
        for (Node var:listVar)
            varlst+=var.toPrint(s+"  ");
        return s+"ArrowType\n" + varlst + ret.toPrint(s+"  ->") ;
    }

    public Node getReturn () { //
        return this.ret;
    }

    public ArrayList<Node> getListVar () { //
        return listVar;
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //TODO
        return new ArrayList<SemanticError>();
    }

    public Node typeCheck () {
        return null;
    }

    public String codeGeneration() {
        return "";
    }

}
