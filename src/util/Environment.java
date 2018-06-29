package util;

import ast.STentry;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {

	/* SymbolTable*/
	private ArrayList<HashMap<String,STentry>>  symTable = new ArrayList<>();
	/* Current nesting level*/
	private int nestingLevel = -1;

	private int offset = 0;

	/**
	 * Return a list of hashmap, each one contains the symbol table of one nesting level
	 *
	 * @return List of HashMap of every NestingLevel
	 */
	public ArrayList<HashMap<String,STentry>> getSymTable() {
		return symTable;
	}

	public HashMap<String,STentry> getHashMapNL(int i) {
		return symTable.get(i);
	}

	public int getNestingLevel() {
		return this.nestingLevel;
	}

	public int getOffset() {
		return offset;
	}

	public int getOffsetDec() {
		return offset--;
	}

	public void setSymTable(ArrayList<HashMap<String,STentry>> symTable) {
		this.symTable = symTable;
	}

	public void addHashMapNL(HashMap<String,STentry> hm){
		symTable.add(++nestingLevel,hm);
	}

	public void removeHashMapNL(){
		symTable.remove(nestingLevel--);
	}


	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel=nestingLevel;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
	
}
