package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CallMethodNode implements Node {

    private String id;
    private String idType;
    private Node subFun;
    private STentry entry;
    private int nestinglevel;


    public CallMethodNode (String id, Node subFun) {
        this.id =id;
        this.subFun =subFun;
    }

    public String toPrint(String s) {
        String returnString = s + "CallMethodNode\n";
        returnString += s + subFun.toPrint(s + "   ") + "\n";


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
            if(subFun instanceof FunExpNode){
                ((FunExpNode) subFun).setTypeClassMethod(idType);
                semanticErrors.addAll(subFun.checkSemantics(env));
            }
        }
        return semanticErrors;
    }

    public Node typeCheck() {
        TypeNode typeReturn=null;
        if(subFun instanceof FunExpNode){
            typeReturn=(TypeNode)subFun.typeCheck();
        }

        return typeReturn;
    }


    public String codeGeneration() {
        return "";
    }

}