package ast;

import util.Environment;
import util.SemanticError;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class CallMethodNode implements Node {

    private String id;
    private Map<String, ArrayList<Node>> listField;
    private STentry entry;
    private int nestinglevel;

    //TODO non serve
    private Node exp;

    public CallMethodNode (String id, Map<String, ArrayList<Node>> listField) {
        this.id =id;
        this.listField=listField;
    }

    public String toPrint(String s) {
        String returnString = s + "CallMethodNode\n";
        for(Map.Entry<String,ArrayList<Node>> entry : this.listField.entrySet()){
            for( Node ntp : entry.getValue()){
                returnString += s + ntp.toPrint(s + "   ") + "\n";
            }
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();


        //todo


        return semanticErrors;
    }

    public Node typeCheck() {
        return exp.typeCheck();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}