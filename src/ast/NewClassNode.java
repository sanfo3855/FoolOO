package ast;

import lib.FOOLlib;
import parser.ExecuteVM;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
public class NewClassNode implements Node{

    private FunExpNode funExpNode;
    private String id;
    private ArrayList<String> extClassId= new ArrayList<String>();
    private int sizeListParm= 0;
    private int hpAddress=-1;

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
        String idTemp=id;
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

        for(int i=-1; i<extClassId.size(); i++){
            if (i == -1) {
                idTemp=id;
            }else{
                idTemp=extClassId.get(i);
            }
            for (String classex:env.getHashMapNL(0).keySet()) {
                if(classex.contains("fieldClass#")){
                    if(classex.contains(idTemp)){
                        sizeListParm++;
                    }
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

    public String codeGeneration() {//todo
        String code="";
//        String objectLabel=FOOLlib.freshClassLabel();

        if(funExpNode.getEntry()!=null){
            code=funExpNode.codeGeneration();
        }
        String pushPar="";
        hpAddress=ExecuteVM.getHp();
        for(int i=0; i<sizeListParm; i++){
            pushPar+="push 0\n" +
                     "pthp\n"; //todo implementa in SVM memory[hp++]=pop()
        }
//        FOOLlib.putCode(objectLabel+":\n"+
//                "cfp\n"+ //setta $fp a $sp
//                "lra\n"+ //inserimento return address
//                pushPar+
//                "sra\n"+ // pop del return address
//                "pop\n"+ // pop di AL
//                "sfp\n"+  // setto $fp a valore del CL
//                "lrv\n"+ // risultato della funzione sullo stack
//                "lra\n"+"js\n" // salta a $ra
//        );

        return
                //"push "+ objectLabel + "\n"+
                        code;
    }

}

