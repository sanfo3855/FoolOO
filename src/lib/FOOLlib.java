package lib;

import ast.*;

import java.util.ArrayList;

public class FOOLlib {
  
  private static int labCount=0; 
  
  private static int funLabCount=0; 

  private static String funCode=""; 

  //valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
    boolean res=false;
    if(a instanceof IdTypeNode && b instanceof NullNode){
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
          for(String extClassB: ((IdTypeNode) b).getExtClassId()){
            if( nomeClasseA.equals(extClassB) ){
              res=true;
            }
          }
        }
      }else{
        res=true;
      }
    }

    return res;
  } 
  
  public static String freshLabel() { 
	return "label"+(labCount++);
  } 

  public static String freshFunLabel() { 
	return "function"+(funLabCount++);
  } 
  
  public static void putCode(String c) { 
    funCode+="\n"+c; //aggiunge una linea vuota di separazione prima di funzione
  } 
  
  public static String getCode() { 
    return funCode;
  } 


}