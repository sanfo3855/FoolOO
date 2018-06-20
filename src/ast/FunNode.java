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


    public FunNode (String id, Node type, ArrayList<Node> listVar, Node progNode) {
        this.id=id;
        this.type=type;
        this.listVar=listVar;
        this.progNode=progNode;
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

        //create key
//        String idKey = "fun#"+ id +"%";
//        idKey += ((TypeNode) type).getType();
//        for (Node node : listVar) {
//            TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
//            idKey += "%" + typeVar.getType();
//        }
//
//        if ( hm.get(idKey) == null) {
//            semanticErrors.add(new SemanticError("Fun " + id + " already declared !"));
//        } else {
            env.addHashMapNL( new HashMap<String, STentry>());

            for (Node node: listVar) {
                parList.add(((VarDecNode) node).getType());
                semanticErrors.addAll(node.checkSemantics(env));
            }
            //add type to current entry
            entry.addType(new FunTypeNode(parList, type));
            semanticErrors.addAll(progNode.checkSemantics(env));
            //close scope
            env.removeHashMapNL();
//        }
        return semanticErrors;
    }

    public Node typeCheck() {
        if (listVar!=null) {
            for (Node var : listVar) {
                var.typeCheck();
            }
        }
        if (!(FOOLlib.isSubtype(progNode.typeCheck(),type))){
            System.out.println("Wrong return type for function " + id);
            System.exit(0);
        }
        return null;
    }

    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }

}