package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class DecclassNode implements Node {

    private String id; //id classe
    private String idExt; //id classe estesa di questo nodo classe
    private ArrayList<Node> listVar; //lista dei campi di questo nodo classe
    private ArrayList<Node> listFun; //lista dei metodi di questo nodo classe
    private ArrayList<String> extClassId= new ArrayList<String>(); //lista completa delle superclassi di questo nodo classe


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
            int paroffset=1;
            hashMapClass.put(idClass,new STentry(env.getNestingLevel(),paroffset++));

            /*
            se questo nodo classe estende un'altra classe carico nell'ambiente della classe
            gli identificatori dei campi di tutte le sue superclassi, per poi potervi accedere
            */
            if(idExt!=null){
                for (String nameClassExt: extClassId) {
                    //gli identificatori dei campi delle sue superclassi si trovano nell'ambiente 0
                    for (String classex:env.getHashMapNL(0).keySet()) {
                        if(classex.contains("fieldClass#"+nameClassExt+"%")){
                            String[] fieldClass=classex.split("%");
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
                            if ( hashMapClass.put(fieldClass[1],new STentry(env.getNestingLevel(),nodeType,paroffset++)) != null  ){
                                semanticErrors.add(new SemanticError("Field id "+fieldClass[1]+" already declared"));
                            }
                        }
                    }
                }
            }

            //carico nell'ambiente della classe gli identificatori dei suoi campi
            for(Node varNode : listVar){
                VarDecNode arguments = (VarDecNode) varNode;
                varTypes.add(arguments.getType());
                if ( hashMapClass.put(arguments.getId(),new STentry(env.getNestingLevel(),arguments.getType(),paroffset++)) != null  ){
                    semanticErrors.add(new SemanticError("Parameter id "+arguments.getId()+" already declared"));
                }
            }

            //richiamo il checkSemantics sui nodi funzione di questo nodo classe
            if(listFun.size() > 0){
                //env.setOffset(-2);
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
        //todo
        return "";
    }

}