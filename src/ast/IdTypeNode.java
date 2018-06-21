package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class IdTypeNode implements TypeNode {

    String id;
    private ArrayList<String> extClassId= new ArrayList<String>();

    public IdTypeNode(String id) {
        this.id=id;
    }

    public ArrayList<String> getExtClassId() {
        return extClassId;
    }

    public void setExtClassId(ArrayList<String> extClassId) {
        this.extClassId = extClassId;
    }

    public String toPrint(String s) {
        return s+"IdType\n";
    }

    public Node typeCheck() {
        return null;
    }

    public String codeGeneration() {
        return "";
    }

    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        int j = env.getNestingLevel();
        STentry tmpEntry = null;
        while (j >= 0 && tmpEntry == null) {
            tmpEntry = env.getHashMapNL(j--).get("class%"+id);
        }
        if (tmpEntry == null) {
            semanticErrors.add(new SemanticError("Class Id " + id + " is not declared"));
        }else{
            ArrayList<String> tempArrayClass=new ArrayList<String>();
            for (String classex:env.getHashMapNL(0).keySet()) {
                if(classex.contains("class%")){
                    if(!classex.contains("fun#")){
                        tempArrayClass.add(classex.substring(6, classex.length()));
                    }
                }
            }

            boolean cond=true;
            String idExtClass=id;
            while (cond){
                cond=false;
                for (String classex:tempArrayClass) {
                    String[] arrExt=classex.split("@");
                    if(idExtClass.equals(arrExt[0]) && arrExt.length==2){
                        idExtClass=arrExt[1];
                        extClassId.add(arrExt[1]);
                        cond=true;
                    }
                }
            }
        }
        return semanticErrors;
    }


    public String getType(){
        return id;
    }
}  