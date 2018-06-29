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

	/**
	 * Return the i-th hashmap of the symbol table
	 * @param i -> nesting level needed
	 * @return i-th hashmap of the symbol table
	 */
	public HashMap<String,STentry> getHashMapNL(int i) {
		return symTable.get(i);
	}

	/**
	 * Return current nesting level
	 *
	 * @return current nesting level
	 */
	public int getNestingLevel() {
		return this.nestingLevel;
	}

	/**
	 * Return offset
	 *
	 * @return offset
	 */
	public int getOffset() {
		return offset;
	}

	/**
	 * Return decremented offset
	 *
	 * @return decremented offset
	 */
	public int getOffsetDec() {
		return offset--;
	}

	/**
	 * Set symTable
	 *
	 * @param symTable
	 */
	public void setSymTable(ArrayList<HashMap<String,STentry>> symTable) {
		this.symTable = symTable;
	}

	/**
	 * Increment Nesting Level and add new HashMap (at
	 * @param hm
	 */
	public void addHashMapNL(HashMap<String,STentry> hm){
		symTable.add(++nestingLevel,hm);
	}

	/**
	 * Remove hashmap at current nesting level and decrement nesting level
	 */
	public void removeHashMapNL(){
		symTable.remove(nestingLevel--);
	}

	/**
	 * Set nesting level
	 * @param nestingLevel
	 */
	public void setNestingLevel(int nestingLevel) {
		this.nestingLevel=nestingLevel;
	}

	/**
	 * Set offset
	 * @param offset
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	
	
}
