package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunNode  implements Node {

    private String id;
    private Node type;
    private ArrayList<Node> listVar;
    private Node progNode;
    private Node retNode;


    public FunNode (String id, Node type, ArrayList<Node> listVar, Node progNode, Node retNode) {
        this.id=id;
        this.type=type;
        this.listVar=listVar;
        this.progNode=progNode;
        this.retNode=retNode;
    }

    public String toPrint(String s) {
        String returnString = s + "FunNode" + "\n";
        for(Node ntp : this.listVar){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        returnString += s + this.progNode.toPrint(s + "   ");
        return returnString;
    }

    public String getId() {
        return id;
    }

    public Node getType() {
        return type;
    }

    public ArrayList<Node> getListVar() {
        return listVar;
    }

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        HashMap<String,STentry> hm = env.getHashMapNL(env.getNestingLevel());
        STentry entry = new STentry(env.getNestingLevel(), env.getOffsetDec());
        ArrayList<Node> parList = new ArrayList<Node>();
        env.addHashMapNL( new HashMap<String, STentry>());
        for (Node node: listVar) {
            parList.add(((VarDecNode) node).getType());
            semanticErrors.addAll(node.checkSemantics(env));
        }
        entry.addType(new FunTypeNode(parList, type));
        semanticErrors.addAll(progNode.checkSemantics(env));
        if(retNode!=null){
            semanticErrors.addAll(retNode.checkSemantics(env));
        }else{
            if (!(type instanceof VoidTypeNode)){//diverso da void
                semanticErrors.add(new SemanticError("Missing return"));
            }
        }
        env.removeHashMapNL();

        return semanticErrors;
    }

    public Node typeCheck() {
        if(retNode!=null){
            if( !FOOLlib.isSubtype(type, retNode.typeCheck()) ){
                System.out.println("Wrong return type for function " + id );
                System.exit(0);
            }
        }
        return null;
    }

    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }

}