package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FoolNode implements Node {

    private ArrayList<Node> listNodi;

    public FoolNode (ArrayList<Node> listNodi) {
        this.listNodi = listNodi;
    }

    public String toPrint(String s) {
        String returnString = s + "FoolNode\n";
        for(Node nodo : listNodi){
            returnString += s + nodo.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors= new ArrayList<SemanticError>();
        env.addHashMapNL(new HashMap<String,STentry>());
        HashMap<String,STentry> hashMap = env.getHashMapNL(env.getNestingLevel());
        STentry entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec()); //separo introducendo "entry"
        String idPutHM;
        for(Node nodo : listNodi){
            if(nodo instanceof DecclassNode ){
                idPutHM=((DecclassNode)nodo).getId();
                if ( hashMap.put("class%"+idPutHM,entryTable) != null ){
                    semanticErrors.add(new SemanticError("Class "+idPutHM+" is not declared"));
                }
            }
            if(nodo instanceof FunNode ){
                idPutHM = "fun#";
                FunNode funNode=(FunNode) nodo;
                idPutHM += funNode.getId() +"%";
                idPutHM += ((TypeNode)funNode.getType()).getType();
                ArrayList<Node> parList = funNode.getListVar();
                for (Node node : parList) {
                    TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
                    idPutHM += "%" + typeVar.getType();
                }
                if ( hashMap.put(idPutHM,entryTable) != null ){
                    semanticErrors.add(new SemanticError("Fun "+idPutHM+" is not declared"));
                }
            }
        }
        for(Node nodo : listNodi){
            semanticErrors.addAll(nodo.checkSemantics(env));
        }
        return semanticErrors;
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