package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class DecclassNode implements Node {

    private String id;
    private String idExt;
    private ArrayList<Node> listVar;
    private ArrayList<Node> listFun;

    //TODO non serve
    private Node exp;


    public DecclassNode (String id, ArrayList<Node> listVar, ArrayList<Node> listFun, String idExt) {
        this.id = id;
        this.listVar = listVar;
        this.listFun= listFun;
        this.idExt= idExt;
    }
    public DecclassNode (String id, ArrayList<Node> listVar, ArrayList<Node> listFun) {
        this.id = id;
        this.listVar = listVar;
        this.listFun= listFun;
    }

    public String toPrint(String s) {
        String returnString = s + "DecclassNode\n";

        for(Node varDec :  listVar){
            returnString += s + varDec.toPrint("   ") + "\n";
        }
        for(Node fun : listFun){
            returnString += s + fun.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {

        return exp.checkSemantics(env);
    }

    public Node typeCheck() {
        return exp.typeCheck();
    }

    public String codeGeneration() {
        return exp.codeGeneration()+"halt\n";
    }

}