package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class AsmNode implements Node {

    private String id;  //Variable's ID
    private Node value; //Value assigned to id
    private STentry entry; //field that holds AsmNode SymbolTable entry

    /**
     * Constructor for AsmNode.
     * It takes 2 parameters:
     * @param id -> Variable's ID
     * @param value -> Value assigned to id
     */
    public AsmNode(String id, Node value) {
        this.id=id;
        this.value=value;
    }

    /**
     * Prints structure of AsmNode
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {

        return s + "AsmNode\n" + s +s + "Id:" + id ;
    }

    /**
     * Checks AsmNode's semantic and call checkSemantic method on every child Node
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
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

    /**
     * Check that value field is subtype of id's type (saved in node's entry field)
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
           // System.out.println("AsmNode - "+id+" - "+entry.getType()+" - "+value.typeCheck());

        if( !FOOLlib.isSubtype(value.typeCheck(), entry.getType()) ){
            System.out.println("TypeCheck error for assignement to " + id );
            System.exit(0);
        }
        return new VoidTypeNode();
    }


    /**
     *
     * @return
     */
    public String codeGeneration() {
        return value.codeGeneration()+"halt\n";
    }

}