package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class AsmNode implements Node {

    private String id;
    private Node value;
    private STentry entry;

    public AsmNode(String id, Node value) {
        this.id=id;
        this.value=value;
    }

    public String toPrint(String s) {

        return "AsmNode\n" + id ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        int j=env.getNestingLevel();
        STentry tmpEntry=null;
        while (j>=0 && tmpEntry==null){
            tmpEntry = env.getHashMapNL(j--).get(id);
        }
        //System.out.println(tmpEntry.toPrint(""));
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("Id " + id + " is not declared"));
        } else {
            entry=tmpEntry;
        }
        semanticErrors.addAll(value.checkSemantics(env));
        return semanticErrors;
    }

    public Node typeCheck() {
        if( !FOOLlib.isSubtype(entry.getType(), value.typeCheck()) ){
            System.out.println("TypeCheck error for assignement to " + id );
            System.exit(0);
        }
        return new VoidTypeNode();
    }

    public String codeGeneration() {
        return value.codeGeneration()+"halt\n";
    }

}