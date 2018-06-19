package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FunExpNode implements Node {

    private String id;
    private String typeClassMethod;
    private ArrayList<Node> listParam;
    private STentry entry;
    private int nestinglevel;

    public FunExpNode (String id, ArrayList<Node> listParam) {
        this.id =id;
        this.listParam = listParam;
    }

    public void setTypeClassMethod(String typeClassMethod) {
        this.typeClassMethod = typeClassMethod;
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
                String keysharp[] = chkEntry.getKey().split("#");
                if(keysharp[0].equals("fun")) {
                    String key[] = keysharp[1].split("%");
                    int keylength=key.length;
                    if ((keylength-2 == listParam.size()) && (key[0].equals(id))) {
                        tmpEntry = chkEntry.getValue();
                    }else{
                        if (key[0].equals(id)  && (keylength-4)==listParam.size() && key[keylength-2].equals("class") && key[keylength-1].equals(typeClassMethod)) {
                            tmpEntry = chkEntry.getValue();
                        }
                    }
                }
            }
        }
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("Funzio id " + id + " is not declared"));
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