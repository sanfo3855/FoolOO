package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewClassNode implements Node{
    private String id;
    private ArrayList<Node> listPar;
    private ArrayList<String> extClassId= new ArrayList<String>();
    private String constructor;

    /**
     * Constructor for NewClassNode.
     *
     * @param id --> class name
     * @param listPar --> class parameters
     */
    public NewClassNode (String id, ArrayList<Node> listPar) {
        this.id = id;
        this.listPar = listPar;
    }

    /**
     * Print structure of NewClassNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "NewClassNode\n";
        for(Node ntp : listPar){
            returnString += s + ntp.toPrint(s+"   ") + "\n";
        }
        return returnString;
    }

    /**
     * Checks NewClassNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    //todo finire commenti e javadoc
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        //creazione arraylist di errori semantici
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        //ottengo iterativamente il nome della classe scorrendo i vari nesting level
        int envNL=env.getNestingLevel();
        STentry entryTableTemp=null;
        while (envNL>=0 && entryTableTemp==null){
            entryTableTemp=env.getHashMapNL(envNL--).get("class%"+id);
        }
        if (entryTableTemp==null){
            //se non esiste un entry con il dato id restituisce errore semantico
            semanticErrors.add(new SemanticError("New Class "+id+" not declared"));
        }else{
            if(!(listPar.isEmpty())){
                envNL=env.getNestingLevel();
                entryTableTemp=null;
                HashMap<String,STentry> tmpHm;
                int keylength;
                while (envNL>=0 && entryTableTemp==null){
                    tmpHm = env.getHashMapNL(envNL--);
                    for (Map.Entry<String,STentry> chkEntry : tmpHm.entrySet()) {

                        String keysharp[] = chkEntry.getKey().split("#");
                        if(keysharp[0].equals("fun")) {
                            String key[] = keysharp[1].split("%");
                            keylength=key.length;
                            if(key[0].equals(id) && key[1].equals(id) && (keylength-4)==listPar.size() && key[keylength-2].equals("class") && key[keylength-1].equals(id) ){
                                entryTableTemp=chkEntry.getValue();
                                constructor = chkEntry.getKey();

                            }
                        }
                    }
                }
                if(entryTableTemp==null){
                    semanticErrors.add(new SemanticError("Funzione costruttore della classe " + id + " is not declared"));
                }
                for(Node parNode : listPar){
                    semanticErrors.addAll(parNode.checkSemantics(env));
                }
            }
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

    public Node typeCheck() {
        if (listPar.size() > 0) {
            Node parTypeNode;
            String keyTemp[] = constructor.split("%");
            String[] constructorParType = new String[keyTemp.length-4];
            System.arraycopy(keyTemp, 2, constructorParType, 0,keyTemp.length-4);
            for(int i= 0; i < listPar.size(); i++){
                String type=constructorParType[i];
                if (type.equals("int")) {
                    parTypeNode = new IntTypeNode();
                } else if (type.equals("bool")) {
                    parTypeNode = new BoolTypeNode();
                } else {
                    parTypeNode = new IdTypeNode(id);
                }
                if (!(FOOLlib.isSubtype(listPar.get(i).typeCheck(), parTypeNode))) {
                    System.out.println("Type mismatch: Espected " + type);
                    System.exit(0);
                }
            }
        }
        Node idTypeNode=new IdTypeNode(id);
        ((IdTypeNode) idTypeNode).setExtClassId(extClassId);
        return idTypeNode;
    }

    public String codeGeneration() {
        //todo
        return "";
    }

}

