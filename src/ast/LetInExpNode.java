package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class LetInExpNode implements Node {

    private ArrayList<Node> listDec;
    private Node exp;

    public LetInExpNode (ArrayList<Node> listDec, Node exp) {
        this.listDec=listDec;
        this.exp=exp;
    }

    public String toPrint(String s) {
        String returnString = s + "LetInExpNode" + "\n";
        for(Node ntp : listDec){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        returnString += s + this.exp.toPrint(s + "   ") + "\n";
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        HashMap<String,STentry> hashMap = env.getHashMapNL(env.getNestingLevel());
        STentry entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec()); //separo introducendo "entry"
        String idPutHM;
        for(Node nodo : listDec){
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
        for(Node ntc : listDec){
            semanticErrors.addAll(ntc.checkSemantics(env));
        }
        semanticErrors.addAll(exp.checkSemantics(env));


        return semanticErrors;
    }

    public Node typeCheck() {
        return exp.typeCheck();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}