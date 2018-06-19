package ast;

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

    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        HashMap<String,STentry> hm = env.getHashMapNL(env.getNestingLevel());
        STentry entry = new STentry(env.getNestingLevel(), env.getOffsetDec());

        //create key
        String idKey = "fun#"+ id +"|";
        idKey += ((TypeNode) type).getType();
        ArrayList<Node> parList = new ArrayList<Node>();
        for (Node node : listVar) {
            TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
            idKey += "|" + typeVar.getType();
        }

        if ( hm.put(idKey,entry) != null) {
            semanticErrors.add(new SemanticError("Fun " + id + "already declared !"));
        } else {
            for (Node node: listVar) {
                semanticErrors.addAll(node.checkSemantics(env));
            }

            //Create new HashMap
            HashMap<String, STentry> hmNew = new HashMap<String, STentry>();
            env.addHashMapNL(hmNew);
            int paroffset=1;

            for(Node node : listVar){
                VarDecNode arg = (VarDecNode) node;
                parList.add(arg.getType());
                if ( hmNew.put(arg.getId(),new STentry(env.getNestingLevel(),arg.getType(),paroffset++)) != null )
                    semanticErrors.add(new SemanticError("Parameter id "+arg.getId()+" already declared"));
            }
            //add type to current entry
            entry.addType(new FunTypeNode(parList, type));
            semanticErrors.addAll(progNode.checkSemantics(env));
            //close scope
            env.removeHashMapNL();
        }
        return semanticErrors;
    }

    public Node typeCheck() {
        return type.typeCheck();
    }

    public String codeGeneration() {
        return type.codeGeneration()+"halt\n";
    }

}