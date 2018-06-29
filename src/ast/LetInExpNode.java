package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class LetInExpNode implements Node {

    private ArrayList<Node> listDec;
    private Node exp;

    /**
     * Constructor for LetInExpNode
     * @param listDec --> Arraylist of declarations inside Let In
     * @param exp --> Node expression
     */
    public LetInExpNode (ArrayList<Node> listDec, Node exp) {
        this.listDec=listDec;
        this.exp=exp;
    }

    /**
     * Prints structure of FunctionNode
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "LetInExpNode" + "\n";
        for(Node ntp : listDec){
            //richiama il toPrint per ciascun nodo dichiarazione
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        if (exp!=null) {
            returnString += s + this.exp.toPrint(s + "   ") + "\n";
        }

        return returnString;
    }

    /**
     * Check LetInExpNode's semantic and call checkSemantic method on every childNode,
     * Child node: listDec (list declaration)
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //Arraylyst per errori semantici
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //Si ottiene l'hashmap dello scope corrente
        HashMap<String,STentry> hashMap = env.getHashMapNL(env.getNestingLevel());
        //viene creata una nuo
        STentry entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec()); //separo introducendo "entry"
        String idPutHM;
        for(Node node : listDec){
            if(node instanceof FunNode ){
                idPutHM = "fun#";
                FunNode funNode=(FunNode) node;
                idPutHM += funNode.getId() +"%";
                idPutHM += ((TypeNode)funNode.getType()).getType();
                ArrayList<Node> parList = funNode.getListVar();
                for (Node nodePar : parList) {
                    TypeNode typeVar = (TypeNode) ((VarDecNode) nodePar).getType();
                    idPutHM += "%" + typeVar.getType();
                }
                if ( hashMap.put(idPutHM,entryTable) != null ){
                    semanticErrors.add(new SemanticError("Fun "+idPutHM+" already declared"));
                }
            }
        }
        for(Node ntc : listDec){
            semanticErrors.addAll(ntc.checkSemantics(env));
        }
        if (exp!=null) {
            semanticErrors.addAll(exp.checkSemantics(env));
        }

        return semanticErrors;
    }

    public Node typeCheck() {

        for (Node node : listDec) {
            node.typeCheck();
        }
        if (exp!=null){
            exp.typeCheck();
        }
        return new VoidTypeNode();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}