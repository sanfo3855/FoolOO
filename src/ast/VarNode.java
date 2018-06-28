package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class VarNode implements Node {

    private Node varDec;
    private Node value;

    public VarNode (Node varDec, Node value) {
        this.varDec=varDec;
        this.value=value;
    }

    public VarNode (Node varDec){
        new VarNode(varDec, null);
    }


    public String toPrint(String s) {

        return s + "VarNode\n" +
                s + this.varDec.toPrint(s + "   ") + "\n" +
                s + this.value.toPrint(s + "  ") + "\n" ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        semanticErrors.addAll(varDec.checkSemantics(env));
        semanticErrors.addAll(value.checkSemantics(env));

        return semanticErrors;
    }

    public Node typeCheck() {
        //System.out.println("VarNode - "+((VarDecNode)varDec).getId()+" - "+varDec.typeCheck()+" - "+value.typeCheck());

        if (! (FOOLlib.isSubtype(value.typeCheck(), varDec.typeCheck())) ){
            System.out.println("Incompatible value for variable "+((VarDecNode)varDec).getId());
            System.exit(0);
        }
        return null;
    }

    public String codeGeneration() {
        return value.codeGeneration()+"halt\n";
    }

}