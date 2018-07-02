package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class VarDecNode implements Node {

    private String id;
    private Node type;
    private ArrayList<String> extClassId= new ArrayList<String>();

    /**
     * Constructor for Declaration Variable.
     *
     * @param id --> Variable's name
     * @param type --> Variable's type
     */
    public VarDecNode (String id, Node type) {
        this.id=id;
        this.type=type;
    }

    /**
     *
     * @return Variable's name (id)
     */
    public String getId(){
        return id;
    }

    /**
     *
     * @return Variable's type
     */
    public Node getType(){
        return type;
    }

    /**
     * Prints structure of VarDecNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s + "VarDecNode" + "\n" +
                s + s + "Id: " + id + "\n" +
                s + s + "Type: " + type.toPrint( "") + "\n" ;
    }

    /**
     * Check VarDecNode's semantic. It checks that there aren't multiple declarations of the same variables.
     *
     * Child node: ProgNode and listVar.
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
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
        String idTemp=((TypeNode)type).getType();
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

        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //si ottiene l'hashmap del livello corrente
        HashMap<String,STentry> hm = env.getHashMapNL(env.getNestingLevel());
        //viene creata una nuova entry per la dichiarazione della variabile con il relativo tipo
        STentry entry = new STentry(env.getNestingLevel(),type,env.getOffsetDec());

        //si controlla che l'inserimento di tale entry non sia già esistente
        if( hm.put(id,entry) != null ){
            //viene generato un errore semantico nel caso in cui sia già stata inizializzata
            semanticErrors.add(new SemanticError("Multiple declaration of " + id + " at " + env.getNestingLevel()));
        }
        //si richiama il check semantics nel type
        semanticErrors.addAll(type.checkSemantics(env));
        //ritorna l'arraylist di errori semantici
        return semanticErrors;
    }

    /**
     * The type check of a variable returns the variable's type.
     *
     * @return variable's type
     */
    public Node typeCheck() {
        Node idTypeNode=type;
        if(type instanceof IdTypeNode){
            ((IdTypeNode) type).setExtClassId(extClassId);
        }
        return idTypeNode;
    }

    /**
     *
     * @return empty string
     */
    public String codeGeneration() {
        /* Non devo generare code*/
        return "";
    }

}