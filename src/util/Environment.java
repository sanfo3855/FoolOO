package util;

import ast.STentry;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
	
	private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<>();
	private int nestingLevel = -1;
	private int offset = 0;

	public ArrayList<HashMap<String,STentry>> getSymTable() {
		return this.symTable;
	}

	public HashMap<String,STentry> getHashMapNL(int i) {
		return this.symTable.get(i);
	}

	public int getNestingLevel() {
		return this.nestingLevel;
	}

	public int getOffset() {
		return this.offset;
	}

	public int getOffsetDec() {
		return this.offset--;
	}

	public void setSymTable(ArrayList<HashMap<String,STentry>> symTable) {
		this.symTable = symTable;
	}

	public void addHashMapNL(HashMap<String,STentry> hm){
		this.symTable.add(++this.nestingLevel,hm);
	}

	public void removeHashMapNL(){
		this.symTable.remove(nestingLevel--);
	}


	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel=nestingLevel;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
	
	
	
}
