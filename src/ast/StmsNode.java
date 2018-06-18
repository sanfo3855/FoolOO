package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class StmsNode implements Node {

    private ArrayList<Node> listNodi;

    public StmsNode(ArrayList<Node> listNodi) {
        this.listNodi = listNodi;
    }

    public String toPrint(String s) {
        String returnString = s + "StmsNode\n";
        for(Node nodo : listNodi){
            returnString += s + nodo.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> err= new ArrayList<SemanticError>();
        for(Node nodo : listNodi){
            err.addAll(nodo.checkSemantics(env));
        }
        return err;
    }

    public Node typeCheck() {

        Node nodoRes=null;
        for(Node nodo : listNodi){
            nodoRes = nodo.typeCheck();
        }
        return nodoRes;
    }

    public String codeGeneration() {
        String code= "";
        for(Node nodo : listNodi){
            code += nodo.codeGeneration()+"halt\n";
        }
        return code+"halt\n";
    }

}