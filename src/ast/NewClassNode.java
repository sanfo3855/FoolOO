package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewClassNode implements Node{
    private String id;
    private ArrayList<Node> listPar;

    public NewClassNode (String id, ArrayList<Node> listPar) {
        this.id = id;
        this.listPar = listPar;
    }


    public String toPrint(String s) {
        String returnString = s + "NewClassNode\n";
        for(Node ntp : listPar){
            returnString += s + ntp.toPrint(s+"   ") + "\n";
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        int envNL=env.getNestingLevel();
        STentry entryTableTemp=null;
        while (envNL>=0 && entryTableTemp==null){
            entryTableTemp=env.getHashMapNL(envNL--).get("class%"+id);
        }
        if (entryTableTemp==null){
            semanticErrors.add(new SemanticError("New Class "+id+" not declared"));
        }else{
            if(!(listPar.isEmpty())){
                envNL=env.getNestingLevel();
                entryTableTemp=null;
                HashMap<String,STentry> tmpHm=null;
                int keylength;
                while (envNL>=0 && entryTableTemp==null){
                    tmpHm = env.getHashMapNL(envNL--);
                    for (Map.Entry<String,STentry> chkEntry : tmpHm.entrySet()) {

                        String keysharp[] = chkEntry.getKey().split("#");
                        if(keysharp[0].equals("fun")) {
                            String key[] = keysharp[1].split("%");
                            keylength=key.length;
                            if(key[0].equals(id) && key[1].equals("void") && (keylength-4)==listPar.size() && key[keylength-2].equals("class") && key[keylength-1].equals(id) ){
                                entryTableTemp=chkEntry.getValue();
                            }
                        }
                    }
                }
                if(entryTableTemp==null){
                    semanticErrors.add(new SemanticError("Funzione costruttore della classe " + id + " is not declared"));
                }
                for(Node parNode : listPar){
                    semanticErrors.addAll(parNode.checkSemantics(env));
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

