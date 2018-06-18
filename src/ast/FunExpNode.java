package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FunExpNode implements Node {

    private String id;
    private ArrayList<Node> listParam;
    private STentry entry;
    private int nestinglevel;

    public FunExpNode (String id, ArrayList<Node> listParam) {
        this.id =id;
        this.listParam = listParam;
    }

    public String toPrint(String s) {
        String returnString = s + "FunExpNode" + "\n";
        for(Node ntp : listParam){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //da controllare
        //Cerco una funzione con listParam.length() parametri
        int j=env.getNestingLevel();
        STentry tmpEntry = null;
        HashMap<String,STentry> tmpHm=null;
        while (j>=0 && tmpEntry==null){
            tmpHm = env.getHashMapNL(j--);
            for (Map.Entry<String,STentry> chkEntry : tmpHm.entrySet()) {
                String key[] = chkEntry.getKey().split("|");
                String id = key[1];
                String paramType = key[3];
                if(id.equals(id) && paramType.length()==listParam.size()){
                    tmpEntry=chkEntry.getValue();
                }
            }
        }
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("Id " + id + " is not declared"));
        }

        //checkSemantics per listParam
        for(Node ntc : listParam){
            semanticErrors.addAll(ntc.checkSemantics(env));
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