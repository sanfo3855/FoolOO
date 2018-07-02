package util;

import java.util.HashMap;

public class DispatcherTable {

    private static HashMap< String, HashMap<String,String>> dispatchTable = new HashMap< String, HashMap<String,String>>();

    public HashMap< String, HashMap<String,String>> getDispatchTable() {
        return dispatchTable;
    }

    public static boolean putDispatchEntry(String idClass, HashMap<String,String> methodList){
        return dispatchTable.put(idClass,methodList)!=null;
    }

    public static HashMap<String,String> getEntry(String idClass){
        return dispatchTable.get(idClass);
    }



}
