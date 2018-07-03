package ast;

import lib.FOOLlib;
import util.Environment;
import util.SemanticError;

import java.util.*;

public class FunExpNode implements Node {

    private String id;//nome della funzione
    private String typeClassMethod;//nome della classe su cui viene ricercata la funzione
    private ArrayList<Node> listParam;//lista dei parametri della funzione

    private ArrayList<Node> typeParam=new ArrayList<Node>();
    private STentry entry;////entry table dell'id
    private int nestingLevel;//nestinglevel dell'entry

    /**
     * Constructor for FunExpNode.
     *
     * @param id function name
     * @param listParam list of function parameters
     */
    public FunExpNode (String id, ArrayList<Node> listParam) {
        this.id =id;
        this.listParam = listParam;
        this.typeClassMethod=null;
    }

    public ArrayList<Node> getTypeParam() {
        return typeParam;
    }

    public ArrayList<Node> getListParam() {
        return listParam;
    }

    public int getSizeListParam() {
        return listParam.size();
    }

    public String getId() {
        return id;
    }

    public STentry getEntry() {
        return entry;
    }

    /**
     * Set the name of the class on which the function is searched.
     *
     * @param typeClassMethod Function Class Name
     */
    public void setTypeClassMethod(String typeClassMethod) {
        this.typeClassMethod = typeClassMethod;
    }

    public String getTypeClassMethod() {
        return typeClassMethod;
    }

    /**
     * Prints structure of FunExpNode and call toPrint method on every child node.
     *
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnString = s + "FunExpNode" + "\n";
        for(Node ntp : listParam){
            returnString += s + ntp.toPrint(s + "   ") + "\n";
        }
        return returnString;
    }

    /**
     * Checks FunExpNode's semantic and call checkSemantic method on every child Node.
     *
     * @param env -> Environment that holds previously parsed information
     * @return updated ArrayList of semantic errors
     */
    public ArrayList<SemanticError> checkSemantics(Environment env) {
        ArrayList<SemanticError> semanticErrors = new ArrayList<SemanticError>();
        //Se typeClassMethod!=null sto effettuando una chiamata di metodo tramite x.m(); con m FunExpNode
        if(typeClassMethod==null){
            /*
            Se typeClassMethod==null controllo che l'ambiente in cui sto
            richiamando la funzione sia una classe. Se lo è salvo in typeClassMethod
            il nome della classe attuale, per poter utilizzare le funzioni definite
            nella classe e nelle superclassi.
             */
            Set<String> keySetTemp = env.getHashMapNL(1).keySet();
            String classTemp=null;
            for (String s:keySetTemp) {
                if(s.contains("class%")){
                    //ottengo il nome della classe
                    classTemp=s.split("%")[1];
                }
            }
            if(classTemp!=null ){
                //set della classe al cui appartiene il metodo
                typeClassMethod=classTemp;
            }
        }

        int j=env.getNestingLevel();
        STentry tmpEntry = null;
        HashMap<String,STentry> hmClassExt=env.getHashMapNL(0);
        ArrayList<String> keyType= new ArrayList<String>();
        int keylength=0;
        Iterator iteratorHM;
        Map.Entry<String,STentry> entryHM;
        /*
        Scorro tutti gli ambienti, pertendo dal più interno, per ricercare
        l'identificatore della funzione o del metodo della classe.
         */
        while (j>=0 && tmpEntry==null){
            iteratorHM = env.getHashMapNL(j--).entrySet().iterator();
            /*
            Scorro tutte le entry dell'hashMap al livello j caricando ogni entry in entryHM
            Inoltre poichè scorro tutta l'hashmap dell'entry corrente devo controllare che l'entry ricercata
            non sia già stata trovata quindi tmpEntry==null
             */
            while(iteratorHM.hasNext() && tmpEntry==null){
                entryHM = (Map.Entry<String,STentry>)iteratorHM.next();
                keyType = new ArrayList<String>();
                //divido l'dentificatore in corrispondenza del simbolo "#"
                String keysharp[] = entryHM.getKey().split("#");
                /*
                Controlla se la prima parte dell'identificatore corrisponde alla stringa "fun".
                Se ciò avviene vuol dire che tale entry identifica una funzione e quindi è da controllare.
                 */
                if (keysharp[0].equals("fun")) {
                    /*
                    Essendo l'identificatore di una fiìunzione nel keysharp[1] avrò tutte
                    le informazioni che identificano una funzione separate dal simbolo "%".
                    Quindi le divido e le salvo nell'ArrayList keyType.
                     */
                    keyType.addAll(Arrays.asList(keysharp[1].split("%")));
                    keylength = keyType.size();
                    //controllo se il nome della funzione nell'entry corrisponde all'id
                    if(keyType.get(0).equals(id)){
                        //se i parametri passati sono di numero uguale a qualli dell'entry ho trovato l'entry che cercavo
                        if (keylength - 2 == listParam.size()) {
                            tmpEntry = entryHM.getValue();
                        } else {
                            /*
                            Controlla se la funzione che si sta cercando è da ricercare fra i metodi di
                            una specifica classe definita in typeClassMethod. Se la funzione non dovrà essere
                            cercata in tale ambiente typeClassMethod sarà inizializzato a null.
                             */
                            if (typeClassMethod != null && (keylength - 4) == listParam.size() && keyType.get(keylength - 2).equals("class")) {
                                /*
                                Se la classe di appartenenza del metodo è la stessa definita in typeClassMethod, ho trovato l'entry ricercata.
                                Altrimenti cerco fra le sovraclassi della classe definita in typeClassMethod.
                                 */
                                if (keyType.get(keylength - 1).equals(typeClassMethod)) {
                                    tmpEntry = entryHM.getValue();
                                } else {
                                    for (String keyfun : hmClassExt.keySet()) {
                                        String[] splitKey = keyfun.split("@");
                                        if (splitKey.length > 1 && splitKey[0].split("%")[1].equals(typeClassMethod)) {
                                            if (keyType.get(keylength - 1).equals(splitKey[1])) {
                                                tmpEntry = entryHM.getValue();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(tmpEntry==null){
            semanticErrors.add(new SemanticError("Funz id " + id + " is not declared"));
        } else {
            /*
            Se l'entry è stata trovata vuol dire che esiste una funzione che corrisponde a quella ricercata,
            quindi salviamo nella variabile di classe typeParam la lista dei tipi dei parametri della funzione trovata e
            settiamo il tipo dell'entry con il tipo di ritorno della funzione
             */
            int keySub=0;
            if (!(keylength-2 == listParam.size()) && (keyType.get(0).equals(id))) {
                keySub=2;
            }
            for(int i=1; i<keylength-keySub; i++){
                /*
                Nel keyType avrò delle stringhe quindi per avere la classe corrispondente dovrò
                parsarle e aggire di conseguenza. ciò avviene nel seguente switch-case
                 */
                switch (keyType.get(i)){
                    case "int":
                        if(i==1){
                            tmpEntry.addType(new IntTypeNode());
                        }else{
                            typeParam.add(new IntTypeNode());
                        }
                        break;
                    case "bool":
                        if(i==1){
                            tmpEntry.addType(new BoolTypeNode());
                        }else{
                            typeParam.add(new BoolTypeNode());
                        }
                        break;
                    default:
                        if(i==1){
                            tmpEntry.addType(new IdTypeNode(keyType.get(i)));
                        }else{
                            typeParam.add(new IdTypeNode(keyType.get(i)));
                        }
                }
            }
            entry=tmpEntry;
            nestingLevel=env.getNestingLevel();
        }
        //checkSemantics per listParam
        for(Node ntc : listParam){
            semanticErrors.addAll(ntc.checkSemantics(env));
        }

        return semanticErrors;
    }

    /**
     * Check that each parameter is a subtype of the corresponding one in the function declaration.
     *
     * @return the type of return of the function
     */
    public Node typeCheck() {
        for(int i=0; i<listParam.size(); i++){
            if(!FOOLlib.isSubtype(listParam.get(i).typeCheck(),typeParam.get(i))){
                System.out.println("Wrong type " + typeParam.get(i).toPrint("") + " for param " + i + " in " +id );
                System.exit(0);
            }
        }
        return entry.getType();
    }

    /**
     * codeGeneration
     * @return string code
     */
    public String codeGeneration() {
        String returnString = "lfp\n"; //carico il frame pointer sullo stack
        String AR = "";
        for (int i = listParam.size()-1; i>=0; i--){
            returnString += listParam.get(i).codeGeneration(); //eseguo il push dei parametri del chiamante
        }

        for (int i=0; i<nestingLevel-entry.getNestinglevel(); i++) {
            AR+= "lw\n"; //esegue loadword per ciascun livello da risalire
        }

        returnString+= "lfp\n"+ AR + //carico frame pointer nello stack e risalgo catena statica
                        "push "+ entry.getOffset() +"\n" + //push dell'offset sullo stack
                        "lfp\n"+AR + //risale catena statica
                        "add\n"+
                        "lw\n"+ //carico sullo stack il valore all'indirizzo ottenuto
                        "js\n";

        return returnString;
    }

}