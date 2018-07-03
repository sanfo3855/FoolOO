package ast;

import lib.FOOLlib;

import java.util.ArrayList;

/**
 * Interface that extends Node and define new methods
 * that have to be implemented in every node that implement FunAbstractNode
 */
public abstract class FunAbstractNode implements Node {
    protected String id;
    protected Node type;
    protected ArrayList<Node> listVar;
    protected Node progNode;
    protected Node retNode;

    /**
     *
     * @return Function's ID
     */
    String getId(){
        return id;
    }

    /**
     *
     * @return instance of TypeNode that represent node's type
     */
    Node getType(){
        return type;
    }

    /**
     *
     * @return Node's ArrayList variables
     */
    ArrayList<Node> getListVar(){
        return listVar;
    }

    /**
     *
     * @return
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
        String funl=FOOLlib.freshFunLabel();
        String end="";
        if(id.equals("main")){
            FOOLlib.putLabelMain(funl);
            end="b "+FOOLlib.getLabelEnd()+"\n";
        }else if (!(type instanceof VoidTypeNode)){
            end= "sfp\n"+  // setto $fp a valore del CL
                    "lrv\n"+ // risultato della funzione sullo stack
                    "lra\n"+"js\n"; // salta a $ra
        }
        String retCod="";
        if(retNode!=null){
            retCod=retNode.codeGeneration();
        }
        String progCod="";
        if (progNode!=null){
            progCod=progNode.codeGeneration();
        }
        FOOLlib.putCode(funl+":\n"+
                "cfp\n"+ //setta $fp a $sp
                "lra\n"+ //inserimento return address
                progCod+
                retCod+
                "srv\n"+ //pop del return value
                popDec+
                "sra\n"+ // pop del return address
                "pop\n"+ // pop di AL
                popVar+
                end
        );

        return "push "+ funl +"\n";
    }
}
