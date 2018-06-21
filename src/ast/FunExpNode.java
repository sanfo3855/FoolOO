package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FunExpNode implements Node {

    private String id;
    private String typeClassMethod;
    private ArrayList<Node> listParam;
    private STentry entry;
    private ArrayList<Node> typeParam;
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
        HashMap<String,STentry> hmClassExt=env.getHashMapNL(0);
        while (j>=0 /*&& tmpEntry==null*/){
            tmpHm = env.getHashMapNL(j--);
            for (Map.Entry<String,STentry> chkEntry : tmpHm.entrySet()) {
                String keysharp[] = chkEntry.getKey().split("#");
                if(keysharp[0].equals("fun")) {
                    String key[] = keysharp[1].split("%");
                    int keylength=key.length;
                    if ((keylength-2 == listParam.size()) && (key[0].equals(id))) {
                        tmpEntry = chkEntry.getValue();
                        for(int i=2; i<keylength-2; i++){
                            if(key[i].equals("int")) listParam.add(new IntTypeNode());
                            else if (key[i].equals("bool")) listParam.add(new BoolTypeNode());
                            else listParam.add(new IdTypeNode(key[i]));
                        }
                    }else{
                        if(typeClassMethod!=null) {
                            if (key[0].equals(id) && (keylength - 4) == listParam.size() && key[keylength - 2].equals("class") && key[keylength - 1].equals(typeClassMethod)) {
                                tmpEntry = chkEntry.getValue();
                                for(int i=2; i<keylength-4; i++){
                                    if(key[i].equals("int")) listParam.add(new IntTypeNode());
                                    else if (key[i].equals("bool")) listParam.add(new BoolTypeNode());
                                    else listParam.add(new IdTypeNode(key[i]));
                                }
                            } else {
                                for (String keyfun : hmClassExt.keySet()) {
                                    String[] splitKey = keyfun.split("@");
                                    if (splitKey.length > 1 && splitKey[0].split("%")[1].equals(typeClassMethod)) {
                                        if (key[0].equals(id) && (keylength - 4) == listParam.size() && key[keylength - 2].equals("class") && key[keylength - 1].equals(splitKey[1])) {
                                            tmpEntry = chkEntry.getValue();
                                            for(int i=2; i<keylength-4; i++){
                                                if(key[i].equals("int")) listParam.add(new IntTypeNode());
                                                else if (key[i].equals("bool")) listParam.add(new BoolTypeNode());
                                                else listParam.add(new IdTypeNode(key[i]));
                                            }
                                        }
                                    }
                                }

                            }
                        }else{
                            if (key[0].equals(id) && (keylength - 4) == listParam.size() && key[keylength - 2].equals("class")) {
                                tmpEntry = chkEntry.getValue();
                                for(int i=2; i<keylength-4; i++){
                                    if(key[i].equals("int")) listParam.add(new IntTypeNode());
                                    else if (key[i].equals("bool")) listParam.add(new BoolTypeNode());
                                    else listParam.add(new IdTypeNode(key[i]));
                                }
                            }
                        }
                    }
                }
            }
        }
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("Funzio id " + id + " is not declared"));
        } else {
            entry=tmpEntry;
        }


        //checkSemantics per listParam
        for(Node ntc : listParam){
            semanticErrors.addAll(ntc.checkSemantics(env));
        }

        return semanticErrors;
    }

    public Node typeCheck() {
        Node returnType = entry.getType();
        for(int i=0; i<listParam.size(); i++){
            System.out.println(i);
            if(!FOOLlib.isSubtype(listParam.get(i).typeCheck(),typeParam.get(i))){
                System.out.println("Wrong type " + typeParam.get(i).toPrint("") + " for param " + i + " in " +id );
                System.exit(0);
            }
        }
        return returnType;
    }

    public String codeGeneration() {
        return "";
    }

}