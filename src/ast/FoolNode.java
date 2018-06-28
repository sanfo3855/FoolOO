package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FoolNode implements Node {

    private ArrayList<Node> listNodi;

    public FoolNode (ArrayList<Node> listNodi) {
        this.listNodi = listNodi;
    }

    public String toPrint(String s) {
        String returnString = s + "FoolNode\n";
        for(Node nodo : listNodi){
            returnString += s + nodo.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors= new ArrayList<SemanticError>();
        env.addHashMapNL(new HashMap<String,STentry>());
        HashMap<String,STentry> hashMap = env.getHashMapNL(env.getNestingLevel());
        STentry entryTable; //separo introducendo "entry"
        String idPutHM;
        ArrayList<Node> listVar;
        DecclassNode decclassNode;
        FunNode funMainNode;
        ArrayList<Node> listFun;
        FunInterfaceNode funNode;
        for(Node nodo : listNodi){
            if(nodo instanceof DecclassNode ){
                decclassNode=(DecclassNode)nodo;
                entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec()); //separo introducendo "entry"
                idPutHM=decclassNode.getId();
                if ( hashMap.put("class%"+idPutHM,entryTable) != null ){
                    semanticErrors.add(new SemanticError("Class "+idPutHM+" already declared"));
                }
                if(decclassNode.getIdExt()!=null){
                    idPutHM+="@"+decclassNode.getIdExt();
                    if ( hashMap.put("class%"+idPutHM,entryTable) != null ){
                        semanticErrors.add(new SemanticError("Class "+idPutHM+" already declared"));
                    }
                }
                listVar=decclassNode.getListVar();
                if(listVar.size()>0){
                    for (Node varNode:listVar) {//"fieldClass#idclasse%nomeVar%tipoVar"
                        idPutHM="fieldClass#"+decclassNode.getId();
                        idPutHM+="%"+((VarDecNode)varNode).getId();
                        idPutHM+="%"+((TypeNode)((VarDecNode)varNode).getType()).getType();
                        if ( hashMap.put(idPutHM,entryTable) != null ){
                            semanticErrors.add(new SemanticError("Class "+idPutHM+" already declared"));
                        }
                    }
                }
                listFun=decclassNode.getListFun();
                if(listFun.size() > 0) {
                    String idKey;
                    for (Node fun : listFun) {
                        idKey = "fun#";
                        if (fun instanceof FunInterfaceNode) {
                            funNode = (FunInterfaceNode) fun;
                            idKey += funNode.getId() + "%";
                            idKey += ((TypeNode) funNode.getType()).getType();
                            ArrayList<Node> parList = funNode.getListVar();
                            for (Node node : parList) {
                                TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
                                idKey += "%" + typeVar.getType();
                            }
                            idKey += "%class%" + decclassNode.getId();
                            if (hashMap.put(idKey, entryTable) != null) {
                                semanticErrors.add(new SemanticError("FunClass " + idKey + " already declared !"));
                            }
                        }
                    }
                }
            }
            if(nodo instanceof FunNode ){
                entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec()); //separo introducendo "entry"
                idPutHM = "fun#";
                funMainNode=(FunNode) nodo;
                idPutHM += funMainNode.getId() +"%";
                idPutHM += ((TypeNode)funMainNode.getType()).getType();
                ArrayList<Node> parList = funMainNode.getListVar();
                for (Node node : parList) {
                    TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
                    idPutHM += "%" + typeVar.getType();
                }
                if ( hashMap.put(idPutHM,entryTable) != null ){
                    semanticErrors.add(new SemanticError("Fun "+idPutHM+" already declared"));
                }
            }
        }
        for(Node nodo : listNodi){
            semanticErrors.addAll(nodo.checkSemantics(env));
        }
        if(listNodi.size()==3){
            System.out.println("  ");
        }

//        for (String k:hashMap.keySet()) {
//            if(k.contains("fun#"))
//            System.out.println(k);
//        }
        return semanticErrors;
    }

    public Node typeCheck() {
        for(Node nodo : listNodi){
            nodo.typeCheck();
        }
        return new VoidTypeNode();
    }

    public String codeGeneration() {
        String code= "";
        for(Node nodo : listNodi){
            code += nodo.codeGeneration()+"halt\n";
        }
        return code+"halt\n";
    }

}