package ast;

import util.Environment;
import util.SemanticError;
import java.util.ArrayList;
import java.util.Set;

public class StmsNode implements Node {

    private ArrayList<Node> listNode;

    /**
     * Constructor for stmsNode.
     *
     * @param listNodi --> child nodes
     */
    public StmsNode(ArrayList<Node> listNodi) {
        this.listNode = listNodi;
    }

    /**
     * Print structure of StmsNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "StmsNode\n";
        for(Node node : listNode){
            returnString += s + node.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    /**
     * Check Stms's semantic and call checkSemantic method on every childNode.
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        ArrayList<SemanticError> semanticErrors= new ArrayList<SemanticError>();

        //ottengo gli id al livello 1 di tutte le chiavi per ottenere il nome della classe
        Set<String> keySetTemp = env.getHashMapNL(1).keySet();

        //stringa temp per salvare il nome della classe
        String classTemp=null;
        for (String s:keySetTemp) {
            if(s.contains("class%")){
                //ottengo il nome della classe
                classTemp=s.split("%")[1];
            }
        }
        for(Node node : listNode){
            //richiamo check semantic per ciascun nodo presente
            semanticErrors.addAll(node.checkSemantics(env));
        }

        //ritorna l'arraylist di errori semantici
        return semanticErrors;
    }

    /**
     * It call typeCheck for every child of listNode.
     *
     * @return a node nodeRes
     */
    public Node typeCheck() {
        Node nodeRes=null;
        for(Node node : listNode){
            nodeRes = node.typeCheck();
        }
        return nodeRes;
    }

    /**
     *
     * @return
     */
    public String codeGeneration() {
        String code= "";
        for(Node nodo : listNode){
            code += nodo.codeGeneration();
        }
        return code;
    }

}