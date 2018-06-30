package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class CallMethodNode implements Node {

    private String id; //id oggetto chiamante il metodo
    private Node methodCall; //nodo rappresentante il metodo chiamato da id
    private STentry entry; //entry table dell'id
    private int nestinglevel;//nestinglevel dell'entry


    /**
     * Constructor for CallMethodNode.
     *
     * @param id object's id calling the method
     * @param methodCall id Method call
     */
    public CallMethodNode (String id, Node methodCall) {
        this.id =id;
        this.methodCall = methodCall;
    }

    /**
     * Prints structure of CallMethodNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "CallMethodNode\n";
        returnString += s + methodCall.toPrint(s + "   ") + "\n";
        return returnString;
    }

    /**
     * Checks CallMethodNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        int envNL=env.getNestingLevel();
        STentry entryTableTemp=null;

        /*
        Cerco l'STentry dell'oggetto chiamante il metodo.
        L'identificatore dell'oggetto viene ricercato in tutte le
        hashmap dal nestinglevel corrente sino al nestinglevel 0
         */
        while (envNL>=0 && entryTableTemp==null){
            entryTableTemp=env.getHashMapNL(envNL--).get(id);
        }
        if (entryTableTemp==null){
            semanticErrors.add(new SemanticError("Id "+id+" not declared"));
        }else{
            //carico in idType il nome della classe dell'oggetto id
            String idType=((TypeNode)entryTableTemp.getType()).getType();
            if(methodCall instanceof FunExpNode){
                ((FunExpNode) methodCall).setTypeClassMethod(idType);
                //invoco il checkSemantics sul nodo rappresentante il metodo chiamato dall'oggetto, ovvero un nodo FunExpNode
                semanticErrors.addAll(methodCall.checkSemantics(env));
            }
        }
        //salvo l'STentry dell'id e il relativo nes
        entry = entryTableTemp;
        nestinglevel = envNL;
        return semanticErrors;
    }

    /**
     * Calls the typeCheck on methodCall that is a node FunExpNode.
     *
     * @return instance of TypeNode
     */
    public Node typeCheck() {
        TypeNode typeReturn=null;
        if(methodCall instanceof FunExpNode){
            typeReturn=(TypeNode) methodCall.typeCheck();
        }

        return typeReturn;
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