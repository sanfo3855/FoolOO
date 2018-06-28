package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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

        Set<String> keySetTemp = env.getHashMapNL(1).keySet();
        String classTemp=null;
        for (String s:keySetTemp) {
            if(s.contains("class%")){
                classTemp=s.split("%")[1];
            }
        }
        for(Node nodo : listNodi){
            if(classTemp!=null && nodo instanceof FunExpNode){
                ((FunExpNode) nodo).setTypeClassMethod(classTemp);
            }
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