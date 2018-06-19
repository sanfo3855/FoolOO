package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class DecclassNode implements Node {

    private String id;
    private String idExt;
    private ArrayList<Node> listVar;
    private ArrayList<Node> listFun;


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
        this.idExt= null;
    }

    public String toPrint(String s) {
        String returnString = s + "DecclassNode\n";
        if(idExt!=null){
            returnString += s + "Extends "+idExt+ "\n";
        }

        for(Node varDec :  listVar){
            returnString += s + varDec.toPrint("   ") + "\n";
        }
        for(Node fun : listFun){
            returnString += s + fun.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        HashMap<String,STentry> hashMap = env.getHashMapNL(env.getNestingLevel());
        STentry entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec()); //separo introducendo "entry"

        if ( hashMap.put("class|"+id,entryTable) != null ){
            semanticErrors.add(new SemanticError("Class id "+id+" already declared"));
        }else{
            if( hashMap.get(idExt) != null ){
                semanticErrors.add(new SemanticError("Class idExtends "+idExt+" already declared"));
            }else{

                HashMap<String,STentry> hashMapVar = new HashMap<String,STentry> ();
                env.addHashMapNL(hashMapVar);
                ArrayList<Node> varTypes = new ArrayList<Node>();
                int paroffset=1;

                for(Node varNode : listVar){
                    VarDecNode arguments = (VarDecNode) varNode;
                    varTypes.add(arguments.getType());
                    if ( hashMapVar.put(arguments.getId(),new STentry(env.getNestingLevel(),arguments.getType(),paroffset++)) != null  ){
                        semanticErrors.add(new SemanticError("Parameter id "+arguments.getId()+" already declared"));
                    }
                }
                if(listFun.size() > 0){
                    env.setOffset(-2);
                    for(Node fun : listFun){
                        semanticErrors.addAll(fun.checkSemantics(env));
                    }
                }
                env.removeHashMapNL();
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