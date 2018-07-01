package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
public class NewClassNode implements Node{

    private FunExpNode funExpNode;
    private String id;
    private ArrayList<String> extClassId= new ArrayList<String>();

    /**
     * Constructor for NewClassNode.
     *
     * @param id --> class name
     * @param listPar --> class parameters
     */
    public NewClassNode (String id, ArrayList<Node> listPar) {
        this.id=id;
        this.funExpNode = new FunExpNode(id, listPar);
        this.funExpNode.setTypeClassMethod(id);
    }

    /**
     * Print structure of NewClassNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString=s + "NewClassNode\n";
        returnString+=funExpNode.toPrint(s+"   ");
        return returnString;
    }

    /**
     * Checks NewClassNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

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

        //Chiama il checkSemantic di funExpNode
        if(funExpNode.getSizeListParam()==0){
            funExpNode.checkSemantics(env);
        }else{
            semanticErrors.addAll(funExpNode.checkSemantics(env));
        }
        return semanticErrors;
    }

    public Node typeCheck() {
        if(funExpNode.getSizeListParam()>0){
            funExpNode.typeCheck();
        }
        //Setta come tipo l'Id della classe
        Node idTypeNode=new IdTypeNode(id);
        ((IdTypeNode) idTypeNode).setExtClassId(extClassId);
        return idTypeNode;
    }

    public String codeGeneration() {
        String code="";
        if(funExpNode.getEntry()!=null){
            code=funExpNode.codeGeneration();
        }
        return code;
    }

}

