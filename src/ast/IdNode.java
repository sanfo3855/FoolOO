package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IdNode implements Node {

    private String id;
    private STentry entry;
    private int nestinglevel;

    /**
     * Constructor for IdNode.
     *
     * @param id --> name of Node
     */
    public IdNode(String id) {
        this.id=id;
    }

    /**
     * Print structure of IdNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s+"Id:" + id + " at nestlev " + nestinglevel +"\n";
        if(entry!=null){
            returnString +=s+entry.toPrint(s +"   ");
        }
        return returnString;

    }

    /**
     * Check IdNode's semantic.
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //creo arraylist di errori semantici
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //ottengo in j il livello corrente
        int j=env.getNestingLevel();
        STentry tmpEntry=null;
        //controllo iterativamente che tale id sia stato dichiarato
        while (j>=0 && tmpEntry==null){
            tmpEntry = env.getHashMapNL(j--).get(id);
        }
        //ritorno un errore nel caso in cui non sia stato dichiarato
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("id " + id + " is not declared"));
        } else {
            //set della entry con l'id corrente
            entry = tmpEntry;
            //set del nesting level con il livello corrente
            nestinglevel = env.getNestingLevel();
        }
        return semanticErrors;
    }

    /**
     * Check the type of the IdNode and return the corresponding type
     * @return typeNode --> It's a BoolTypeNode, IntTypeNode or IdTypeNode
     */
    public Node typeCheck() {
        //ottiene il tipo dell'id
        String type=((TypeNode) entry.getType()).getType();
        TypeNode typeNode;
        switch (type){
            case "int":
                //identifico typeNode come un nodo IntTypeNode
                typeNode=new IntTypeNode();
                break;
            case "bool":
                //identifico typeNode come un nodo BoolTypeNode
                typeNode=new BoolTypeNode();
                break;
            default:
                //identifico typeNode come un nodo IdTypeNode, e quindi un oggetto type
                typeNode=(TypeNode)entry.getType();
        }
        return typeNode;
    }

    /**
     *
     * @return string of generated code
     */
    public String codeGeneration() {
        String returnString = "push "+entry.getOffset()+"\n";//push offset sullo stack


        if(entry.getOffsetObj()==-1){
            returnString += "lfpof\n";
        }else{
            returnString +="lfp\n"; //carico il fp sullo stack
            //risalgo la catena statica
            for (int i=0; i<nestinglevel-entry.getNestinglevel(); i++){
                returnString+="lpn\nadd\nlw\n";   //Faccio un loadword per ogni scope da risalire
                //Ottengo l'indirizzo dello scope a cui ho la variabile
            }
        }

        returnString+=  "add\n"+ //accede alla posizione della entry
                        "lw\n"; //carica sullo stack il valore all'indirizzo ottenuto

        return returnString;
    }
}