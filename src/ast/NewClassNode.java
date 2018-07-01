package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewClassNode implements Node{

    private FunExpNode funExpNode;
    private String id;
    private ArrayList<String> extClassId= new ArrayList<String>();

    /**
     * Constructor for NewClassNode.
     *
     * @param id --> class name
     * @param listPar --> class parameters
     */
    public NewClassNode (String id, ArrayList<Node> listPar) {
        this.id=id;
        if(listPar.size() > 0){
            this.funExpNode = new FunExpNode(id, listPar);
            this.funExpNode.setTypeClassMethod(id);
        }else{
            this.funExpNode = null;
        }
    }

    /**
     * Print structure of NewClassNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString=s + "NewClassNode\n";
        if(funExpNode!=null){
            returnString+=funExpNode.toPrint(s+"   ");
        }
        return returnString;
    }

    /**
     * Checks NewClassNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    //todo finire commenti e javadoc
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
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

        if(funExpNode!=null){
            semanticErrors.addAll(funExpNode.checkSemantics(env));
        }
        return semanticErrors;
    }

    public Node typeCheck() {
        if(funExpNode!=null){
            funExpNode.typeCheck();
        }
        Node idTypeNode=new IdTypeNode(id);
        ((IdTypeNode) idTypeNode).setExtClassId(extClassId);
        return idTypeNode;
    }

    public String codeGeneration() {
        String code="";
        if(funExpNode!=null){
            code=funExpNode.codeGeneration();
        }
        return code;
    }

}

