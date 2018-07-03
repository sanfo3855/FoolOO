package ast;

import lib.FOOLlib;
import util.DispatcherTable;

import java.util.ArrayList;

public class FunClassNode  extends FunAbstractNode {
    /**
     * Constructor for FunctionNode.
     *
     * @param id --> Function name
     * @param type --> Function type
     * @param listVar --> Function parameters
     * @param progNode --> Function body program
     * @param retNode --> Function return node
     */
    public FunClassNode (String id, Node type, ArrayList<Node> listVar, Node progNode, Node retNode) {
        super(id, type, listVar, progNode, retNode);
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

        String retCod="";
        if(retNode!=null){
            retCod=retNode.codeGeneration();
        }
        String progCod="";
        if (progNode!=null){
            progCod=progNode.codeGeneration();
        }



//        int sizeVarHp=0;
//        if(y==0){
//            sizeVarHp=Integer.parseInt(DispatcherTable.getEntry(className).get("numberVar"));
//        }else{
//            sizeVarHp=Integer.parseInt(DispatcherTable.getEntry(listExtension.get(--y)).get("numberVar"));
//        }
//        String retHpVar="";
//        for(int i = sizeVarHp; i>0; i--){
//            retHpVar +=;//todo
//        }



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
                "sfp\n"+  // setto $fp a valore del CL
                "lrv\n"+ // risultato della funzione sullo stack
                "lra\n"+"js\n" // salta a $ra
        );

        return "push "+ funl +"\n";
    }

}