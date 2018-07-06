package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public class IfNode implements Node {

    private Node cond;
    private Node thenBranch;
    private Node elseBranch;

    /**
     * Constructor for IfNode with elseBranch.
     *
     * @param cond --> Condition Node
     * @param thenBranch --> Then Node
     * @param elseBranch --> Else Node
     */
    public IfNode(Node cond, Node thenBranch, Node elseBranch) {
        this.cond = cond;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    /**
     * Constructor for IfNode without elseBranch.
     *
     * @param cond
     * @param thenBranch
     */
    public IfNode(Node cond, Node thenBranch) {
        this.cond = cond;
        this.thenBranch = thenBranch;
    }

    public Node getThenBranch() {
        return thenBranch;
    }

    public Node getElseBranch() {
        return elseBranch;
    }

    /**
     * Prints structure of IfNode.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "IfNodeCond\n" +
                s+s + cond.toPrint(s +"  ") +"\n" +
                s + "IfNodeThenBranch\n"
                + s+s + thenBranch.toPrint(s + "  ") +"\n";
        if(this.elseBranch!=null){
            returnString += s + "IfNodeElseBranch\n" +
                    s+s +elseBranch.toPrint(s + "  ") +"\n";
        }
        return returnString;

    }

    /**
     * Check IfNode's semantic and Calls checkSemantic method on every childNode.
     *
     * Child node: condition, thenBranch and elseBranch.
     *
     * @param env -> Environment that holds previously parsed information
     * @return  updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();

        //richiamo check semantic nel nodo condizione
        semanticErrors.addAll(cond.checkSemantics(env));

        //richiamo check semantic nel nodo then
        semanticErrors.addAll(thenBranch.checkSemantics(env));

        //se esiste, richiamo il check semantic nel nodo else
        if(elseBranch!=null){
            semanticErrors.addAll(elseBranch.checkSemantics(env));
        }

        //ritorno l'arraylist di errori semantici
        return semanticErrors;
    }

    /**
     * Check that type check of condition's content is subtype of boolTypeNode. Check that branches are compatible.
     *
     * Call type check for each condition's branch.
     *
     * Returns TypeNode of a branch, only if is written something like:
     *      a = if(cond) then value else value
     *
     * @return TypeNode or null
     */
    public Node typeCheck() {
        //Nodo di ritorno
        Node node=null;
        //Condizione di tipo bool
        if (!(FOOLlib.isSubtype(cond.typeCheck(),new BoolTypeNode()))) {
            System.out.println("If condition is not boolean");
            System.exit(0);
        }

        //richiama type check per ogni branch
        Node thenB = thenBranch.typeCheck();
        Node elseB=null;
        if (elseBranch != null) {
            elseB= elseBranch.typeCheck();
        }

        if (elseB != null) {
            //controllo che then ed else siano sottotipi tra loro, altrimenti restituisco errore
            if (FOOLlib.isSubtype(thenB,elseB)){
                node = elseB;
            }
            if (node==null){
                if (FOOLlib.isSubtype(elseB,thenB)){
                    node = thenB;
                }else{
                    node=FOOLlib.extendedFatherHimself(thenB,elseB);
                }
            }
        }else{
            /*
            nel caso in cui l'else non esista viene ritornato void poichè
            se utilizzo l'if per assegnare un valore a una variabile deve
            esistere anche l'else altrimenti deve dare errore di tipo.
            Così facendo se esiste solo il then ritornerà sempre Void.
             */
            node=new VoidTypeNode();
        }

        if(node==null) {
            System.out.println("Incompatible types in then else branches");
            System.exit(0);
        }
        //ritorno il nodo.
        return node;
    }

    /**
     *
     * @return
     */
    public String codeGeneration() {
        String code="";
        String l1 = FOOLlib.freshLabel();
        String l2 = FOOLlib.freshLabel();
        String thenCode=thenBranch.codeGeneration();
        String elseCode=elseBranch.codeGeneration();

        code+= cond.codeGeneration()+
                "push 1\n"+
                "beq "+ l1 +"\n";
        if(elseBranch!=null){
            code+=elseCode;
        }
        code+="b " + l2 + "\n" +
                l1 + ":\n"+
                thenCode+
                l2 + ":\n";
        return code;
    }

}