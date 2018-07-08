package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class IdTypeNode implements TypeNode {

    private String id;
    //arraylist con i nomi delle classi estese
    private ArrayList<String> extClassId= new ArrayList<String>();

    /**
     * Constructor fo IdTypeNode.
     *
     * @param id --> id string
     */
    public IdTypeNode(String id) {
        this.id=id;
    }

    public IdTypeNode(String id, ArrayList<String> extClassId) {
        this.id=id;
        this.extClassId=extClassId;
    }
    /**
     *
     * @return ArrayList of extended class
     */
    public ArrayList<String> getExtClassId() {
        return extClassId;
    }

    /**
     * Set the extended class' arraylist.
     *
     * @param extClassId -> ArrayList of extended class
     */
    public void setExtClassId(ArrayList<String> extClassId) {
        this.extClassId = extClassId;
    }

    /**
     * Print structure of IdTypeNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s+"IdType\n";
    }

    /**
     *
     * @return id type
     */
    public String getType(){
        return id;
    }

    /**
     * Check IdTypeNode's semantic.
     *
     * @param env -> Environment that holds previously parsed information
     * @return Empty ArrayList of semantic errors
     */
    @Override
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        // nesting level corrente
        int j = env.getNestingLevel();
        STentry tmpEntry = null;

        while (j >= 0 && tmpEntry == null) {
            //controllo iterativamente che esista una classe con il relativo id
            tmpEntry = env.getHashMapNL(j--).get("class%"+id);
        }

        if (tmpEntry == null) {
            //se la classe non esiste restituisco un errore
            semanticErrors.add(new SemanticError("Class Id " + id + " is not declared"));
        }else{
            /* creo una lista delle estensioni di questo nodo classe,
            risalendo classe per classe le loro dichiarazioni */
            ArrayList<String> tempArrayClass=new ArrayList<String>();
            for (String classex:env.getHashMapNL(0).keySet()) {
                if(classex.contains("class%")){
                    if(!classex.contains("fun#")){
                        //salvo tale classe in un arraylist temporaneo
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

    /**
     * Type check is empty because it's a terminal node.
     *
     * @return null
     */
    public Node typeCheck() {
        return null;
    }

    /**
     * It's a terminal Node, than the codeGeneration is empty
     * @return Empty String
     */
    public String codeGeneration() {
        return "";
    }

}  