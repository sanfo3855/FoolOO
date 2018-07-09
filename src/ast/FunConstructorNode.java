package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunConstructorNode extends FunClassNode {
    /**
     * Constructor fo Function Constructor Node.
     *
     * @param id --> Constructor name
     * @param listVar --> Constructor parameters
     * @param progNode --> Constructor body
     */
    public FunConstructorNode (String id, ArrayList<Node> listVar, Node progNode) {
        super( id, new IdTypeNode(id), listVar, progNode, null);
    }

    /**
     * Prints structure of FunConstructorNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "FunConstructorNode" + "\n";
        for(Node ntp : this.listVar){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        if (progNode!=null){
            //Aggiunge il corpo del programma alla stringa da stampare
            returnString += s + this.progNode.toPrint(s + "   ");
        }

        return returnString;
    }

    @Override
    /**
     * Check FunConstructorNode's semantic and call checkSemantic method on every childNode.
     *
     * Child node: ProgNode and listVar
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {

        //Arraylist per errori semantici
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        //Creazione nuova entry
        STentry entry = new STentry(env.getNestingLevel(), env.getOffsetDec());

        //Arraylist per lista dei parrametri
        ArrayList<Node> parList = new ArrayList<Node>();

        HashMap<String,STentry> entryHashMap = new HashMap<String,STentry> ();
        //Viene creata una nuova hashmap nell'ambiente
        env.addHashMapNL(entryHashMap);
        STentry entryListVar = null;
        int offsetListVar=1;
        for (Node node: listVar) {
            VarDecNode varDecNode = (VarDecNode) node;
            //Si ottiene il tipo di ciascun parametro
            parList.add(varDecNode.getType());
            entryListVar=new STentry(env.getNestingLevel(),varDecNode.getType(),offsetListVar--);
            if ( entryHashMap.put(varDecNode.getId(),entryListVar) != null  ){
                semanticErrors.add(new SemanticError("Parameter id "+varDecNode.getId()+" already declared"));
            }
        }

        //Aggiunge il tipo nella entry corrente
        entry.addType(new FunTypeNode(parList, type));

        //Viene richiamato il checkSemantics nel corpo del costruttore se != null
        if (progNode!=null) {
            if (progNode instanceof LetInExpNode){
                ((LetInExpNode) progNode).setOffset(offsetListVar-1);
            }
            semanticErrors.addAll(progNode.checkSemantics(env));
        }

        //rimuove l'hashmap dall'ambiente
        env.removeHashMapNL();

        return semanticErrors;
    }

    @Override
    /**
     *  Calls typeCheck() for ProgNode Child.
     *
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
        if (progNode!=null) {
            progNode.typeCheck();
        }
        return new VoidTypeNode();
    }


    /**
     * Generated code for the AsmNode.
     *
     * @return updated codeGeneration string
     */
    public String codeGeneration() {
        String popDec="";
        if (progNode instanceof LetInExpNode){
            for (int i=0; i<((LetInExpNode)progNode).getListDecSize();i++){
                popDec+="pop\n";
            }
        }
        String popVar="";
        for (Node dec:listVar){
            popVar+="pop\n";
        }

        String retCod="lfp\nlpn\nadd\nsfp\npush 0\n";
        String progCod="";
        if (progNode!=null){
            progCod=progNode.codeGeneration();
        }

        String labelTrue=FOOLlib.freshLabel();
        String copyFp="push 0\n" +
                "beq " +labelTrue+"\n"+
                "cfpof\n"+
                labelTrue+":\n";

        FOOLlib.putCode(funl+":\n"+
                "lpn\npushminus\ncfpp\n"+copyFp+ //setta $fp a $sp
                "lra\n"+ //inserimento return address
                progCod+
                retCod+
                "srv\n"+ //pop del return value
                popDec+
                "sra\n"+ // pop del return address
                //"pop\n"+ // pop di AL
                popVar+
         /*cfp*/       "sfp\n"+  // setto $fp a valore del CL
                "lrv\n"+ // risultato della funzione sullo stack
                "lra\n"+"js\n" // salta a $ra
        );

        return "push "+ funl +"\n";
    }
}
