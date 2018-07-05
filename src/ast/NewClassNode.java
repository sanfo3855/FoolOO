package ast;

import parser.ExecuteVM;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class NewClassNode implements Node{

    private CallMethodNode methodCall;
    private String id;
    private ArrayList<String> extClassId= new ArrayList<String>();
    private ArrayList<Node> listPar= new ArrayList<Node>();
    private int sizeListParm= 0;
    private String idCallMethod="";

    /**
     * Constructor for NewClassNode.
     *
     * @param id --> class name
     * @param listPar --> class parameters
     */
    public NewClassNode (String id, ArrayList<Node> listPar) {
        this.id=id;
        this.listPar=listPar;
    }

    public String getId() {
        return id;
    }

    public ArrayList<String> getExtClassId() {
        return extClassId;
    }

    public void setIdCallMethod(String idCallMethod) {
        this.idCallMethod = idCallMethod;
        this.methodCall = new CallMethodNode(idCallMethod, new FunExpNode(id, listPar));
        this.methodCall.setMethodClass(id);
    }

    /**
     * Print structure of NewClassNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString=s + "NewClassNode\n";
        returnString+=methodCall.toPrint(s+"   ");
        return returnString;
    }

    /**
     * Checks NewClassNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        //Ottiene la lista degli id delle classi dall'ambiente più esterno
        ArrayList<String> tempArrayClass=new ArrayList<String>();
        for (String classex:env.getHashMapNL(0).keySet()) {
            if(classex.contains("class%")){
                if(!classex.contains("fun#")){
                    tempArrayClass.add(classex.substring(6, classex.length()));
                }
            }
        }
        //Riempie la lista delle classi da cui la nuova classe eredita
        boolean cond=true;
        String idTemp=id;
        String[] arrExt;
        while (cond){
            cond=false;
            for (String classex:tempArrayClass) {
                arrExt=classex.split("@");
                if(idTemp.equals(arrExt[0]) && arrExt.length==2){
                    idTemp=arrExt[1];
                    extClassId.add(arrExt[1]);
                    cond=true;
                }
            }
        }

        for(int i=-1; i<extClassId.size(); i++){
            if (i == -1) {
                idTemp=id;
            }else{
                idTemp=extClassId.get(i);
            }
            for (String classex:env.getHashMapNL(0).keySet()) {
                if(classex.contains("fieldClass#")){
                    if(classex.contains(idTemp)){
                        sizeListParm++;
                    }
                }
            }
        }

        //Chiama il checkSemantic di funExpNode
        if(methodCall.getSizeListParam()==0){
            methodCall.checkSemantics(env);
        }else{
            semanticErrors.addAll(methodCall.checkSemantics(env));
        }
        return semanticErrors;
    }

    public Node typeCheck() {
        if(methodCall.getSizeListParam()>0){
            methodCall.typeCheck();
        }
        //Setta come tipo l'Id della classe
        Node idTypeNode=new IdTypeNode(id);
        ((IdTypeNode) idTypeNode).setExtClassId(extClassId);
        return idTypeNode;
    }

    public String codeGeneration() {
        String code="push "+ExecuteVM.getHpCode()+"\n";

        for(int i=0; i<sizeListParm; i++){
            ExecuteVM.incHpCode();
            code+="push 11\n" +
                     "pthp\n";
        }

        if(methodCall.getMethodCall().getEntry()!=null){
            code+=methodCall.codeGeneration();
        }
        return code;
    }

}

