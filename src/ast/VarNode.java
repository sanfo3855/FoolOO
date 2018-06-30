package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;
import java.util.ArrayList;
import java.util.Set;

public class VarNode implements Node {

    private Node varDec;
    private Node value;

    /**
     * Constructor for VarNode.
     *
     * @param varDec --> Node declaration
     * @param value --> value of Node declaration
     */
    public VarNode (Node varDec, Node value) {
        this.varDec=varDec;
        this.value=value;
    }

    /**
     * Prints structure of VarNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        return s + "VarNode\n" +
                s + this.varDec.toPrint(s + "   ") + "\n" +
                s + this.value.toPrint(s + "  ") + "\n" ;
    }

    /**
     * Checks VarNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //chiamo check semantics nel nodo vardec
        semanticErrors.addAll(varDec.checkSemantics(env));
        //chiamo check semantics nel nodo value
        semanticErrors.addAll(value.checkSemantics(env));

        return semanticErrors;
    }

    /**
     * Check the subtyping relation between value and vardec.
     *
     * @return null
     */
    public Node typeCheck() {
        if (! (FOOLlib.isSubtype(value.typeCheck(), varDec.typeCheck())) ){
            //genero errore nel caso in cui il sottotipo non sia verificato
            System.out.println("Incompatible value for variable "+((VarDecNode)varDec).getId());
            System.exit(0);
        }
        return null;
    }

    /**
     *
     * @return
     */
    public String codeGeneration() {
        return value.codeGeneration()+"halt\n";
    }

}