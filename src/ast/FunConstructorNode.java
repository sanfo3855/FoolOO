package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FunConstructorNode implements FunInterfaceNode {

    private String id;
    private Node type;
    private ArrayList<Node> listVar;
    private Node progNode;


    public FunConstructorNode (String id, ArrayList<Node> listVar, Node progNode) {
        this.id=id;
        this.listVar=listVar;
        this.progNode=progNode;
        this.type=new IdTypeNode(id);
    }

    public String toPrint(String s) {
        String returnString = s + "FunConstructorNode" + "\n";
        for(Node ntp : this.listVar){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        if (progNode!=null){
            returnString += s + this.progNode.toPrint(s + "   ");
        }

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
        if (progNode!=null) {
            semanticErrors.addAll(progNode.checkSemantics(env));
        }
        env.removeHashMapNL();

        return semanticErrors;
    }

    public Node typeCheck() {
        if (progNode!=null) {
            progNode.typeCheck();
        }
        return null;
    }

    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }
}
