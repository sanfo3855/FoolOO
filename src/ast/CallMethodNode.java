package ast;

import util.DispatcherTable;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class CallMethodNode implements Node {

    private String id; //id oggetto chiamante il metodo
    private FunExpNode methodCall; //nodo rappresentante il metodo chiamato da id
    private STentry entry; //entry table dell'id
    private int nestinglevel;//nestinglevel dell'entry


    /**
     * Constructor for CallMethodNode.
     *
     * @param id object's id calling the method
     * @param methodCall id Method call
     */
    public CallMethodNode (String id, FunExpNode methodCall) {
        this.id =id;
        this.methodCall = methodCall;
    }

    public FunExpNode getMethodCall() {
        return methodCall;
    }

    public void setMethodClass(String typeClassMethod) {
        this.methodCall.setTypeClassMethod(typeClassMethod);
    }


    public int getSizeListParam() {
        return methodCall.getSizeListParam();
    }

    public STentry getEntry() {
        return entry;
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
            methodCall.setTypeClassMethod(idType);
            //invoco il checkSemantics sul nodo rappresentante il metodo chiamato dall'oggetto, ovvero un nodo FunExpNode
            semanticErrors.addAll(methodCall.checkSemantics(env));
        }
        //salvo l'STentry dell'id e il relativo nes
        entry = entryTableTemp;
        nestinglevel = env.getNestingLevel();
        return semanticErrors;
    }

    /**
     * Calls the typeCheck on methodCall that is a node FunExpNode.
     *
     * @return instance of TypeNode
     */
    public Node typeCheck() {
        TypeNode typeReturn=null;
        typeReturn=(TypeNode) methodCall.typeCheck();

        return typeReturn;
    }

    /**
     * Generated code for the methodCall. It search the method inside the Dispatcher Table
     * @return bLabel --> String with the specific method function
     */
    public String codeGeneration() {
        //creo la chiave che verrà utilizzata per cercare la funzione nella dispatcher table
        String key = methodCall.getId()+ "%" + ((TypeNode)methodCall.getEntry().getType()).getType();
        //completo la chiave con i tipi dei parametri della funzione
        for (Node param : methodCall.getTypeParam()){
            key+= "%"+ ((TypeNode)param).getType();
        }

        //ottengo il nome della classe a cui apaprtiene il metodo
        String className = methodCall.getTypeClassMethod();
        String bLabel;
        /* se il metodo non è in quella classe ma è a sua volta ereditato, ottengo il metodo
        dalla dispatcher table scorrendo le varie classi ereditate*/
        if ((bLabel = DispatcherTable.getEntry(className).get(key)) == null){
            String stringExtension = DispatcherTable.getEntry(className).get("extends");
            String[] listExtension = stringExtension.split("%");
            int i=0;
            while(bLabel==null){
                bLabel = DispatcherTable.getEntry(listExtension[i++]).get(key);
            }
        }
        return bLabel;
    }
}