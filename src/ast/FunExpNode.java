package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.*;

public class FunExpNode implements Node {

    private String id;//nome della funzione
    private String typeClassMethod;//nome della classe su cui viene ricercata la funzione
    private ArrayList<Node> listParam;//lista dei parametri della funzione
    private ArrayList<Node> typeParam=new ArrayList<Node>();
    private STentry entry;////entry table dell'id
    private int nestinglevel;//nestinglevel dell'entry

    /**
     * Constructor for FunExpNode.
     *
     * @param id function name
     * @param listParam list of function parameters
     */
    public FunExpNode (String id, ArrayList<Node> listParam) {
        this.id =id;
        this.listParam = listParam;
    }

    /**
     * Set the name of the class on which the function is searched.
     *
     * @param typeClassMethod Function Class Name
     */
    public void setTypeClassMethod(String typeClassMethod) {
        this.typeClassMethod = typeClassMethod;
    }

    /**
     * Prints structure of FunExpNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "FunExpNode" + "\n";
        for(Node ntp : listParam){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    /**
     * Checks FunExpNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //Cerco una funzione con listParam.length() parametri
        int j=env.getNestingLevel();
        STentry tmpEntry = null;
        HashMap<String,STentry> tmpHm=null;
        HashMap<String,STentry> hmClassExt=env.getHashMapNL(0);
        ArrayList<String> keyType= new ArrayList<String>();
        int keylength=0;
        while (j>=0 && tmpEntry==null){
            tmpHm = env.getHashMapNL(j--);
            for (Map.Entry<String,STentry> chkEntry : tmpHm.entrySet()) {
                if (tmpEntry == null) {
                    keyType = new ArrayList<String>();
                    String keysharp[] = chkEntry.getKey().split("#");
                    if (keysharp[0].equals("fun")) {
                        String[] key = keysharp[1].split("%");
                        keyType.addAll(Arrays.asList(key));

                        keylength = key.length;
                        if ((keylength - 2 == listParam.size()) && (key[0].equals(id))) {
                            tmpEntry = chkEntry.getValue();
                        } else {
                            if (typeClassMethod != null) {//controlla se la funzione ricercata è da ricercare fra i metodi di classe o fra le funzioni definite nel main
                                if (key[0].equals(id) && (keylength - 4) == listParam.size() && key[keylength - 2].equals("class") && key[keylength - 1].equals(typeClassMethod)) {
                                    tmpEntry = chkEntry.getValue();
                                } else {
                                    for (String keyfun : hmClassExt.keySet()) {
                                        String[] splitKey = keyfun.split("@");
                                        if (splitKey.length > 1 && splitKey[0].split("%")[1].equals(typeClassMethod)) {
                                            if (key[0].equals(id) && (keylength - 4) == listParam.size() && key[keylength - 2].equals("class") && key[keylength - 1].equals(splitKey[1])) {
                                                tmpEntry = chkEntry.getValue();
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("Funzio id " + id + " is not declared"));
        } else {
            int keySub=0;
            if (!(keylength-2 == listParam.size()) && (keyType.get(0).equals(id))) {
                keySub=2;
            }
            for(int i=1; i<keylength-keySub; i++){
                if(keyType.get(i).equals("int")){
                    if(i==1){
                        tmpEntry.addType(new IntTypeNode());
                    }else{
                        typeParam.add(new IntTypeNode());
                    }
                }
                else if (keyType.get(i).equals("bool")) {
                    if(i==1){
                        tmpEntry.addType(new BoolTypeNode());
                    }else{
                        typeParam.add(new BoolTypeNode());
                    }
                }
                else {
                    if(i==1){
                        tmpEntry.addType(new IdTypeNode(keyType.get(i)));
                    }else{
                        typeParam.add(new IdTypeNode(keyType.get(i)));
                    }
                }
            }
            entry=tmpEntry;
        }
        //checkSemantics per listParam
        for(Node ntc : listParam){
            semanticErrors.addAll(ntc.checkSemantics(env));
        }

        return semanticErrors;
    }

    /**
     * Check that each parameter is a subtype of the corresponding one in the function declaration.
     *
     * @return the type of return of the function
     */
    public Node typeCheck() {
        for(int i=0; i<listParam.size(); i++){
            if(!FOOLlib.isSubtype(listParam.get(i).typeCheck(),typeParam.get(i))){
                System.out.println("Wrong type " + typeParam.get(i).toPrint("") + " for param " + i + " in " +id );
                System.exit(0);
            }
        }
        return entry.getType();
    }

    /**
     * codeGeneration
     * @return string code
     */
    public String codeGeneration() {
        return "";
    }

}