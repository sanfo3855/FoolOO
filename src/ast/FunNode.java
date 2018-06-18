package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class FunNode  implements Node {

    private String id;
    private Node type;
    private ArrayList<Node> listVar;
    private Node progNode;


    public FunNode (String id, Node type, ArrayList<Node> listVar, Node progNode) {
        this.id=id;
        this.type=type;
        this.listVar=listVar;
        this.progNode=progNode;
    }

    public String toPrint(String s) {
        String returnString = s + "FunNode" + "\n";
        for(Node ntp : this.listVar){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        returnString += s + this.progNode.toPrint(s + "   ");
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();


        //todo


        return semanticErrors;
    }

    public Node typeCheck() {
        return type.typeCheck();
    }

    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }

}