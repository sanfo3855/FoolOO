package ast;

import util.DispatcherTable;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DecclassNode implements Node {

    private String id; //id classe
    private String idExt; //id classe estesa di questo nodo classe
    private ArrayList<Node> listVar; //lista dei campi di questo nodo classe
    private ArrayList<Node> listFun; //lista dei metodi di questo nodo classe
    private ArrayList<String> extClassId= new ArrayList<String>(); //lista completa delle superclassi di questo nodo classe
    private int offsetListVar=3;
    private int numberVar=0;

    /**
     * Constructor for DecclassNode (with extends).
     *
     * @param id id class
     * @param listVar list of fields of this class node
     * @param listFun list of methods of this class node
     * @param idExt id class extended of this class node
     */
    public DecclassNode (String id, ArrayList<Node> listVar, ArrayList<Node> listFun, String idExt) {
        this.id = id;
        this.listVar = listVar;
        this.listFun= listFun;
        this.idExt= idExt;
    }

    /**
     * Constructor for DecclassNode (without extends).
     *
     * @param id id class
     * @param listVar list of fields of this class node
     * @param listFun list of methods of this class node
     */
    public DecclassNode (String id, ArrayList<Node> listVar, ArrayList<Node> listFun) {
        this.id = id;
        this.listVar = listVar;
        this.listFun= listFun;
        this.idExt= null;
    }

    /**
     * @return id class
     */
    public String getId() {
        return id;
    }

    /**
     * @return id class extended of this class node
     */
    public String getIdExt() {
        return idExt;
    }

    /**
     * @return list of fields of this class node
     */
    public ArrayList<Node> getListVar() {
        return listVar;
    }

    /**
     * @return list of methods of this class node
     */
    public ArrayList<Node> getListFun() {
        return listFun;
    }

    public int getOffsetListVarPlus() {
        return offsetListVar;
    }


    /**
     * Prints structure of DecclassNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "DecclassNode\n";
        if(idExt!=null){
            returnString += s + "Extends "+idExt+ "\n";
        }

        for(Node varDec :  listVar){
            returnString += s + varDec.toPrint(s + "   ") + "\n";
        }
        for(Node fun : listFun){
            returnString += s + fun.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    /**
     * Checks DecclassNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        HashMap<String,STentry> hashMap = env.getHashMapNL(env.getNestingLevel());
        //se questo nodo classe estende un'altra classe controllo che la classe estesa esista
        if( idExt!=null && hashMap.get("class%"+idExt) == null ){
            semanticErrors.add(new SemanticError("Class idExtends "+idExt+" is not declared"));
        }else{
            //creo una lista delle estensioni di questo nodo classe, risalendo classe per classe le loro dichiarazioni
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
            String idClass="class%"+id;
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
            //creo l'ambiente di livello 1 ovvero l'ambiente della classe caricando l'hashMapClass
            env.addHashMapNL(hashMapClass);
            ArrayList<Node> varTypes = new ArrayList<Node>();
            hashMapClass.put(idClass,new STentry(env.getNestingLevel(),offsetListVar));
            hashMapClass.put("this",new STentry(env.getNestingLevel(), new IdTypeNode(id, extClassId),offsetListVar));

            HashMap<String,STentry> hmClassExt=env.getHashMapNL(0);
            Iterator iteratorExt;
            String keyVar;
            int countVar=0;
            /*
            se questo nodo classe estende un'altra classe carico nell'ambiente della classe
            gli identificatori dei campi di tutte le sue superclassi, per poi potervi accedere
            */
            if(idExt!=null){
                for (String nameClassExt: extClassId) {
                    //gli identificatori dei campi delle sue superclassi si trovano nell'ambiente 0

                    iteratorExt=hmClassExt.entrySet().iterator();
                    countVar=0;
                    while (iteratorExt.hasNext()) {
                        keyVar = ((Map.Entry<String, STentry>) iteratorExt.next()).getKey();
                        if(keyVar.contains("fieldClass"+countVar+"#"+nameClassExt+"%")){
                            countVar++;
                            String[] fieldClass=keyVar.split("%");
                            Node nodeType;
                            //parso il tipo del campo per poter salvare il relativo nodo nell'entryTable
                            switch (fieldClass[2]){
                                case "int":
                                    nodeType= new IntTypeNode();
                                    break;
                                case "bool":
                                    nodeType= new BoolTypeNode();
                                    break;
                                default:
                                    nodeType= new IdTypeNode(fieldClass[2]);
                            }
                            if ( hashMapClass.put(fieldClass[1],new STentry(env.getNestingLevel()+1,nodeType,offsetListVar++)) != null  ){
                                semanticErrors.add(new SemanticError("Field id "+fieldClass[1]+" already declared"));
                            }else{
                                iteratorExt=hmClassExt.entrySet().iterator();
                                numberVar++;
                            }
                        }
                    }
                }
            }

            //carico nell'ambiente della classe gli identificatori dei suoi campi
            for(Node varNode : listVar){
                VarDecNode arguments = (VarDecNode) varNode;
                varTypes.add(arguments.getType());
                if ( hashMapClass.put(arguments.getId(),new STentry(env.getNestingLevel()+1,arguments.getType(),offsetListVar++)) != null  ){
                    semanticErrors.add(new SemanticError("Parameter id "+arguments.getId()+" already declared"));
                }else{
                    numberVar++;
                }
            }

            //richiamo il checkSemantics sui nodi funzione di questo nodo classe
            if(listFun.size() > 0){
                for(Node fun : listFun){
                    semanticErrors.addAll(fun.checkSemantics(env));
                }
            }
            env.removeHashMapNL();
        }
        return semanticErrors;
    }

    /**
     * Check that there is no cyclic declaration of extensions between classes
     * Calls the typeCheck on all its child nodes
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
        if(idExt!= null){
            //Controllo che non ci sia una dichiarazione ciclica di estensioni fra classi
            for (String idExtClass: extClassId) {
                if(id.equals(idExtClass)){
                    System.out.println("Cyclic inheritance involving "+ id);
                    System.exit(0);
                }
            }
        }
        //Invoco il typeCheck sui nodi funzione della classe
        for(Node nodo : listFun){
            nodo.typeCheck();
        }
        return new VoidTypeNode();
    }

    /**
     *
     * @return
     */
    public String codeGeneration() {
        String returnString = "";
        FunClassNode funClassNode;
        HashMap<String,String> methodList=new HashMap<String,String>();
        String methodDT;
        String codFunAbs;
        for (Node fun: listFun) {
            funClassNode=(FunClassNode) fun;
            methodDT=funClassNode.getId()+"%"+((TypeNode)funClassNode.getType()).getType();
            for(Node typePar: funClassNode.getListVar()){
                methodDT+="%"+((TypeNode)((VarDecNode)typePar).getType()).getType();
            }
            codFunAbs=funClassNode.getFunl();
            methodList.put(methodDT, codFunAbs);
        }
        if(idExt!=null){
            methodDT="";
            for(String s: extClassId){
                methodDT+=s+"%";
            }
            methodList.put("extends", methodDT);
        }

        methodList.put("numberVar", numberVar+"");
        DispatcherTable.putDispatchEntry(id, methodList);

        for (Node fun: listFun) {
            returnString+=fun.codeGeneration();
        }
        return returnString;
    }

}