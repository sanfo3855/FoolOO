package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

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
            entryTableTemp=env.getHashMapNL(envNL).get("class|"+id);
        }
        if (entryTableTemp==null){
            semanticErrors.add(new SemanticError("Class "+id+" not declared"));
        }else{
            if(!(listPar.isEmpty())){


                //todo controllare id esistenza funzione id id(parametri----)


//            for(Node varNode : listPar){
//                semanticErrors.addAll(varNode.checkSemantics(env));
//            }
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

