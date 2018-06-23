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
    private ArrayList<String> extClassId= new ArrayList<String>();


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

    public String getId() {
        return id;
    }

    public String getIdExt() {
        return idExt;
    }

    public ArrayList<Node> getListVar() {
        return listVar;
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
        String idClass="class%"+id;
        if(idExt!=null){
            idClass+="@"+idExt;
        }
        if ( hashMap.get(idClass) == null ){
            semanticErrors.add(new SemanticError("Class "+id+" is not declared"));
        }else{
            if( idExt!=null && hashMap.get("class%"+idExt) == null ){
                semanticErrors.add(new SemanticError("Class idExtends "+idExt+" is not declared"));
            }else{
                //crea lista estenzioni della classe
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

                HashMap<String,STentry> hashMapClass = new HashMap<String,STentry> ();
                env.addHashMapNL(hashMapClass);
                STentry entry = new STentry(env.getNestingLevel(), env.getOffsetDec());
                ArrayList<Node> varTypes = new ArrayList<Node>();
                int paroffset=1;

                if(idExt!=null){
                    for (String nameClassExt: extClassId) {
                        for (String classex:env.getHashMapNL(0).keySet()) {
                            if(classex.contains("fieldClass#"+nameClassExt+"%")){
                                String[] fieldClass=classex.split("%");
                                Node nodeType;
                                if(fieldClass[2].equals("int")){
                                    nodeType= new IntTypeNode();
                                }else if(fieldClass[2].equals("bool")){
                                    nodeType= new BoolTypeNode();
                                }else{
                                    nodeType= new IdTypeNode(fieldClass[2]);
                                }
                                if ( hashMapClass.put(fieldClass[1],new STentry(env.getNestingLevel(),nodeType,paroffset++)) != null  ){
                                    semanticErrors.add(new SemanticError("Field id "+fieldClass[1]+" already declared"));
                                }
                            }
                        }
                    }
                }
                for(Node varNode : listVar){
                    VarDecNode arguments = (VarDecNode) varNode;
                    varTypes.add(arguments.getType());
                    if ( hashMapClass.put(arguments.getId(),new STentry(env.getNestingLevel(),arguments.getType(),paroffset++)) != null  ){
                        semanticErrors.add(new SemanticError("Parameter id "+arguments.getId()+" already declared"));
                    }
                }
                //create key
                if(listFun.size() > 0){
                    String idKey;
                    for(Node fun : listFun){
                        idKey = "fun#";
                        if(fun instanceof FunInterfaceNode){
                            FunInterfaceNode funNode=(FunInterfaceNode) fun;
                            idKey += funNode.getId() +"%";
                            idKey += ((TypeNode)funNode.getType()).getType();
                            ArrayList<Node> parList = funNode.getListVar();
                            for (Node node : parList) {
                                TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
                                idKey += "%" + typeVar.getType();
                            }
                            idKey+="%class%"+id;
                            if ( hashMap.put(idKey,entry) != null) {
                                semanticErrors.add(new SemanticError("FunClass " + idKey + " already declared !"));
                            }
                        }
                    }
                    env.setOffset(-2);
                    for(Node fun : listFun){
                        semanticErrors.addAll(fun.checkSemantics(env));
                    }
                }
//                for (String keyfun: hashMapClass.keySet()) {
//                    if (keyfun.split("#")[0].equals("fun")){
//                        System.out.println("CIAO");
//                        if ( hashMap.put(keyfun+"%class%"+id,entryTable) != null ){
//                            semanticErrors.add(new SemanticError(keyfun+" already defined in class "+id+ ""));
//                        }
//                    }
//                }
                env.removeHashMapNL();
            }
        }
        return semanticErrors;
    }

    public Node typeCheck() {
        if(idExt!= null)
        for (String idExtClass: extClassId) {
            if(id.equals(idExtClass)){
                System.out.println("Cyclic inheritance involving "+ id);
                System.exit(0);
            }
        }
        for(Node nodo : listFun){
            nodo.typeCheck();
        }
        return new VoidTypeNode();
    }

    public String codeGeneration() {
        return "";
    }

}