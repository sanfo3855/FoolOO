package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.ArrayList;
import java.util.HashMap;

public class FoolNode implements Node {

    private ArrayList<Node> listNodi; //lista di tutti i macro nodi del programma, ovvero classi e main

    /**
     * Constructor for FoolNode.
     *
     * @param listNodi list of all the program's macro nodes, ie classes and main
     */
    public FoolNode (ArrayList<Node> listNodi) {
        this.listNodi = listNodi;
    }

    /**
     * Prints structure of FoolNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "FoolNode\n";
        for(Node nodo : listNodi){
            returnString += s + nodo.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    /**
     * Checks FoolNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors= new ArrayList<SemanticError>();//oggetto ritornato dalla funzione e popolato con tutti gli errori semantici riscontrati in FoolNode e tutti i suoi sotto nodi
        env.addHashMapNL(new HashMap<String,STentry>());
        HashMap<String,STentry> hashMap = env.getHashMapNL(env.getNestingLevel());//carico in hashMap l'hashMap del nesting level corrente
        STentry entryTable;
        String idPutHM;
        ArrayList<Node> listVar;
        DecclassNode decclassNode;
        FunNode funMainNode;
        ArrayList<Node> listFun;
        FunAbstractNode funNode;
        //Effettuo una prima passata dei nodi figli di FoolNode salvando nell'ambiente più esterno(env 0) gli identificatori globali
        for(Node nodo : listNodi){ //listNodi è formata da nodi di tipo DecclassNode e FunNode
            //se il nodo esaminato e di tipo DecclassNode lo parso salvando le relative informazioni nell'ambiente
            if(nodo instanceof DecclassNode ){
                decclassNode=(DecclassNode)nodo;
                entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec());
                idPutHM=decclassNode.getId();
                /*
                "class%[idclasse]" -> Struttura dell'identificatore di una singola classe
                Tale id è formato da una stringa "class%" per identificarlo come classe e dall'id della classe
                Salvo nell'ambiente l'identificatore della classe parsata.
                 */
                if ( hashMap.put("class%"+idPutHM,entryTable) != null ){
                    semanticErrors.add(new SemanticError("Class "+idPutHM+" already declared"));
                }
                if(decclassNode.getIdExt()!=null){
                    /*
                    "class%[idclasse]@[idExtendsClass]" -> Struttura dell'identificatore dell'estenzione di una singola classe
                    Tale id è formato da una stringa "class%" per identificarlo come classe, dall'id della classe e  dall'id della classe estesa
                     */
                    idPutHM+="@"+decclassNode.getIdExt();
                    //Salvo nell'ambiente l'identificatore dell'estenzione della classe parsata (se esiste).
                    if ( hashMap.put("class%"+idPutHM,entryTable) != null ){
                        semanticErrors.add(new SemanticError("Class "+idPutHM+" already declared"));
                    }
                }
                listVar=decclassNode.getListVar();
                if(listVar.size()>0){
                    for (int i=0; i<listVar.size(); i++){
                        Node varNode=listVar.get(i);
                        /*
                        "fieldClass#[idclasse]%[nomeVar]%[tipoVar]"
                        Struttura dell'identificatore di una singola variabile di una classe
                         */
                        idPutHM="fieldClass"+i+"#"+decclassNode.getId();
                        idPutHM+="%"+((VarDecNode)varNode).getId();
                        idPutHM+="%"+((TypeNode)((VarDecNode)varNode).getType()).getType();
                        /*
                        Salvo nell'ambiente l'identificatore delle variabili di una classe.
                        Tale id è necessario quando una classe viene estesa per poter ritrovare i campi ereditati
                        */
                        if ( hashMap.put(idPutHM,entryTable) != null ){
                            semanticErrors.add(new SemanticError("Class "+idPutHM+" already declared"));
                        }
                    }
                }
                listFun=decclassNode.getListFun();
                if(listFun.size() > 0) {
                    String idKey;
                    for (Node fun : listFun) {
                        idKey = "fun#";
                        if (fun instanceof FunClassNode) {
                            funNode = (FunClassNode) fun;
                            /*
                            "fun#[idFun]%[tipoFun]%[tipoPar1]%.....%[tipoParN]%class%[idclasse]"
                            Struttura dell'identificatore di un singolo metodo di una classe
                             */
                            idKey += funNode.getId() + "%";
                            idKey += ((TypeNode) funNode.getType()).getType();
                            ArrayList<Node> parList = funNode.getListVar();
                            for (Node node : parList) {
                                TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
                                idKey += "%" + typeVar.getType();
                            }
                            idKey += "%class%" + decclassNode.getId();
                            //Salvo nell'ambiente l'identificatore del metodo di una classe.
                            if (hashMap.put(idKey, new STentry(env.getNestingLevel(),decclassNode.getOffsetListVarPlus())) != null) {
                                semanticErrors.add(new SemanticError("Method " + idKey + " already declared !"));
                            }
                        }
                    }
                }
            }
            //se il nodo esaminato e di tipo FunNode (ovvero solo il main) lo parso salvando le relative informazioni nell'ambiente
            if(nodo instanceof FunNode ){
                entryTable = new STentry(env.getNestingLevel(),env.getOffsetDec());
                /*
                "fun#[idFun]%[tipoFun]%[tipoPar1]%.....%[tipoParN]"
                Struttura dell'identificatore di una singola funzione
                 */
                idPutHM = "fun#";
                funMainNode=(FunNode) nodo;
                idPutHM += funMainNode.getId() +"%";
                idPutHM += ((TypeNode)funMainNode.getType()).getType();
                ArrayList<Node> parList = funMainNode.getListVar();
                for (Node node : parList) {
                    TypeNode typeVar = (TypeNode) ((VarDecNode) node).getType();
                    idPutHM += "%" + typeVar.getType();
                }
                //Salvo nell'ambiente l'identificatore della funzione
                if ( hashMap.put(idPutHM,entryTable) != null ){
                    semanticErrors.add(new SemanticError("Fun "+idPutHM+" already declared"));
                }
//                //controllo che esista una sola funzione main
//                if ( hashMap.put("fun%main",entryTable) != null ){
//                    semanticErrors.add(new SemanticError("Main already declared"));
//                }
            }
        }
        // richiamo il checkSemantics su tutti i nodi figli di FoolNode
        for(Node nodo : listNodi){
            //aggiungo gli errori semantici ritrovati nei figli nell'arrayList di errori semantici di FoolNode
            semanticErrors.addAll(nodo.checkSemantics(env));
        }
        return semanticErrors;
    }

    /**
     * Calls the typeCheck on all its child nodes.
     *
     * @return instance of VoidTypeNode()
     */
    public Node typeCheck() {
        // richiamo il typeCheck su tutti i nodi figli di FoolNode
        for(Node nodo : listNodi){
            nodo.typeCheck();
        }
        return new VoidTypeNode();
    }

    /**
     * Calls the codeGeneration on all its child nodes.
     *
     * @return the generated assembly code
     */
    public String codeGeneration() {
        String code= "push 0\n";
        String end=FOOLlib.freshFunLabel();
        FOOLlib.putLabelEnd(end);
        for(Node nodo : listNodi){
            code += nodo.codeGeneration();
        }
        code+="b "+FOOLlib.getLabelMain()+"\n";
        return code+end+":\nhalt\n"+ FOOLlib.getCode();
    }

}