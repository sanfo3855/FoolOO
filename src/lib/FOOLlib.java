package lib;

import ast.*;

import java.util.ArrayList;

public class FOOLlib {

    private static int labCount=0;

    private static int funLabCount=0;

    private static String funCode="";

    private static String labelMain="";
    private static String labelEnd="";

    /**
     * Checks subtyping between Node a and Node b
     *
     * Node a <: Node b (Is Node a subtype of Node b?)
     *
     * Nodes can be: Int, Bool, Null or Class
     *
     *
     * SUBTYPING PATTERN
     * Bool <: Int
     * Null <: Class
     * Class A <: Class B if
     *    - A extends B
     *    - A extends C   and   C extends B
     *
     * @param a -> Node a
     * @param b -> Node a
     * @return true or false
     */
    public static boolean isSubtype (Node a, Node b) {
        boolean res=false;
        if(b!=null && a!=null){
            if(b instanceof IdTypeNode && a instanceof NullNode){
                res=true;
            }
            if(!res && ((a instanceof BoolTypeNode) && (b instanceof IntTypeNode))){
                res=true;
            }
            if(!res && a.getClass().equals(b.getClass())){
                if(a instanceof IdTypeNode){

                    String nomeClasseA= ((IdTypeNode) a).getType();
                    String nomeClasseB= ((IdTypeNode) b).getType();
                    if( nomeClasseA.equals(nomeClasseB) ){
                        res=true;
                    }else{
                        for(String extClassA: ((IdTypeNode) a).getExtClassId()){
                            if( nomeClasseB.equals(extClassA) ){
                                res=true;
                            }
                        }
                    }
                }else{
                    res=true;
                }
            }
        }
        return res;
    }

    /**
     *
     * @return fresh label in code generation
     */
    public static String freshLabel() {
        return "label"+(labCount++);
    }

    /**
     *
     * @return fresh label for function in code generation
     */
    public static String freshFunLabel() {
        return "function"+(funLabCount++);
    }

    /**
     * Put code "c" in funCode
     *
     * @param c -> code to put
     */
    public static void putCode(String c) {
        funCode+="\n"+c; //aggiunge una linea vuota di separazione prima di funzione
    }

    /**
     *
     * @return funCode
     */
    public static String getCode() {
        return funCode;
    }

    /**
     * Put main label in labelMain
     *
     * @param label -> main label
     */
    public static void putLabelMain(String label) {
        labelMain=label;
    }

    /**
     *
     * @return main label
     */
    public static String getLabelMain() {
        return labelMain;
    }

    /**
     * Put label end of function
     *
     * @param label -> ending label
     */
    public static void putLabelEnd(String label) {
        labelEnd=label;
    }

    /**
     *
     * @return label end of function
     */
    public static String getLabelEnd() {
        return labelEnd;
    }

    /**
     * Check if Node a and Node b have same father
     *
     * @param a -> Node
     * @param b -> Node
     * @return true or false
     */
    public static IdTypeNode extendedFatherHimself(Node a, Node b) {
        IdTypeNode node=null;
        if(a instanceof IdTypeNode && b  instanceof IdTypeNode){
            ArrayList<String> extClass=new ArrayList<String>();
            ArrayList<String> extClassA=((IdTypeNode) a).getExtClassId();
            ArrayList<String> extClassB=((IdTypeNode) b).getExtClassId();

            int i=0;
            int y=0;
            while(node == null && i<extClassA.size()){
                while(node == null && y<extClassB.size()){
                    if (extClassA.get(i).equals(extClassB.get(y))){
                        node=new IdTypeNode(extClassA.get(i));
                        for(int z=i+1; z<extClassA.size(); i++){
                            extClass.add(extClassA.get(z));
                        }
                        node.setExtClassId(extClass);
                    }
                    y++;
                }
                i++;
                y=0;
            }
        }
        return node;
    }

    /**
     * Wipe FOOLlib field
     */
    public static void wipe(){
        labCount=0;
        funLabCount=0;
        funCode="";
        labelMain="";
        labelEnd="";
    }
}