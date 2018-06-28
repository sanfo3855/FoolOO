package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class VarDecNode implements Node {

    private String id;
    private Node type;

    public VarDecNode (String id, Node type) {
        this.id=id;
        this.type=type;
    }


    public String getId(){
        return id;
    }

    public Node getType(){
        return type;
    }

    public String toPrint(String s) {
        return s + "VarDecNode" + "\n" +
                s + s + "Id: " + id + "\n" +
                s + s + "Type: " + type.toPrint( "") + "\n" ;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        HashMap<String,STentry> hm = env.getHashMapNL(env.getNestingLevel());
        STentry entry = new STentry(env.getNestingLevel(),type,env.getOffsetDec());

        if( hm.put(id,entry) != null ){
            semanticErrors.add(new SemanticError("Multiple declaration of " + id + " at " + env.getNestingLevel()));
        }
        semanticErrors.addAll(type.checkSemantics(env));

        return semanticErrors;
    }

    public Node typeCheck() {
        return type;
    }

    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }

}