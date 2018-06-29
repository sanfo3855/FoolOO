package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class VarDecNode implements Node {

    private String id;
    private Node type;

    /**
     * Constructor for Declaration Variable
     * @param id --> Variable's name
     * @param type --> Variable's type
     */
    public VarDecNode (String id, Node type) {
        this.id=id;
        this.type=type;
    }

    /**
     * Method that return Variable's name
     * @return id
     */
    public String getId(){
        return id;
    }

    /**
     * Method that return Variable's type
     * @return type
     */
    public Node getType(){
        return type;
    }

    /**
     * Prints structure of VarDecNode
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s + "VarDecNode" + "\n" +
                s + s + "Id: " + id + "\n" +
                s + s + "Type: " + type.toPrint( "") + "\n" ;
    }

    /**
     * Check VarDecNode's semantic. It checks that there aren't multiple declarations of the same variables
     * Child node: ProgNode and listVar
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //arraylist per errori semantici
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
     * The type check of a variable returns the variable's type
     * @return type --> Type of the declared variable
     */
    public Node typeCheck() {
        return type;
    }

    /**
     *
     * @return
     */
    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }

}