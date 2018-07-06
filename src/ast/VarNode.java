package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;
import java.util.ArrayList;

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

        /* NestingLevel attuale*/
        int j=env.getNestingLevel();

        /* Dichiarazione di STentry in cui salvare
        la dichiarazione della variabile (se trovata) */
        STentry tmpEntry=null;
        String id;
        while (j>=0 && tmpEntry==null){
            id=((VarDecNode)varDec).getId();

            /* Effettuo una ricerca nell'HashMap relativa al j-esimo nestingLevel
            della chiave "id". Se la trova salva l'entry relativa ed esce dal ciclo. */
            tmpEntry = env.getHashMapNL(j--).get(id);
            if(tmpEntry!=null){
                if(value instanceof NewClassNode){
                    TypeNode type=new IdTypeNode(((NewClassNode) value).getId());
                    ((IdTypeNode) type).setExtClassId(((NewClassNode) value).getExtClassId());
                    tmpEntry.addType(type);
                    env.getHashMapNL(j).replace(id,tmpEntry);
                    ((NewClassNode) value).setIdCallMethod(id);
                }else if (value instanceof IfNode){
                    Node thenB=((IfNode)value).getThenBranch();
                    Node elseB=((IfNode)value).getElseBranch();
                    if(thenB instanceof NewClassNode){
                        ((NewClassNode) thenB).setIdCallMethod(id);
                    }
                    if(elseB instanceof NewClassNode){
                        ((NewClassNode) elseB).setIdCallMethod(id);
                    }

                }
            }
        }
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

        String returnString=value.codeGeneration();

        if(value instanceof NewClassNode){
            NewClassNode newClassNode=(NewClassNode) value;
            if(newClassNode.isCodGenMethod()){
                returnString+=newClassNode.getMethodCall().codeGeneration()+"pop\n";
            }
        }

        return returnString;
    }

}