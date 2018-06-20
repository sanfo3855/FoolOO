package ast;

import util.Environment;
import util.SemanticError;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CallMethodNode implements Node {

    private String id;
    private String idType;
    private ArrayList<Node> listSubFun;
    private STentry entry;
    private int nestinglevel;


    public CallMethodNode (String id, ArrayList<Node> listSubFun) {
        this.id =id;
        this.listSubFun=listSubFun;
    }

    public String toPrint(String s) {
        String returnString = s + "CallMethodNode\n";
        for( Node ntp : listSubFun){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }

        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        int envNL=env.getNestingLevel();
        STentry entryTableTemp=null;

        while (envNL>=0 && entryTableTemp==null){
            entryTableTemp=env.getHashMapNL(envNL--).get(id);
        }
        if (entryTableTemp==null){
            semanticErrors.add(new SemanticError("Id "+id+" not declared"));
        }else{
            this.entry = entryTableTemp;
            this.nestinglevel = env.getNestingLevel();

            STentry entryID=null;
            entryID=env.getHashMapNL(env.getNestingLevel()).get(id);
            idType=((TypeNode)entryID.getType()).getType();
            for(Node fun : listSubFun){
                if(fun instanceof FunExpNode){
                    ((FunExpNode) fun).setTypeClassMethod(idType);
                    semanticErrors.addAll(fun.checkSemantics(env));
                    idType=null;
                }
            }
        }

        return semanticErrors;
    }

    public Node typeCheck() {
        return null;
    }

    public String codeGeneration() {
        return "";
    }

}