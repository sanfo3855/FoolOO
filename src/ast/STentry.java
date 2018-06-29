package ast;

public class STentry {

    private int nestinglevel;
    private Node type;
    private int offset;

    /**
     * Constructor for STentry without type
     * @param nestinglevel --> entry nesting level
     * @param offset --> entry offset
     */
    public STentry(int nestinglevel, int offset) {
        this.nestinglevel = nestinglevel;
        this.offset = offset;
    }

    /**
     * Constructor for Stentry with type
     * @param nestinglevel --> entry nesting level
     * @param type --> entry type
     * @param offset --> entry offset
     */
    public STentry(int nestinglevel, Node type, int offset) {
        this.nestinglevel = nestinglevel;
        this.type = type;
        this.offset = offset;
    }

    /**
     * Add the type of the entry
     * @param type
     */
    public void addType(Node type) {
        this.type = type;
    }

    /**
     * Return the type of the entry
     * @return type
     */
    public Node getType() {
        return this.type;
    }

    /**
     * Return the offset of the entry
     * @return offset
     */
    public int getOffset() {
        return this.offset;
    }

    /**
     * Get the nesting level of the entry
     * @return nesting level
     */
    public int getNestinglevel() {
        return this.nestinglevel;
    }

    /**
     * Print structure of STentry
     * @param s parent Indentation, incremented at every toPrint
     * @return updated string that prints Abstract Syntax Tree Structure
     */
    public String toPrint(String s) {
        String returnPrint;
        if(type!=null){
            returnPrint = s + "STentry: nestlev " + Integer.toString(this.nestinglevel) + "\n" +
                    s + "STentry: type\n" +
                    this.type.toPrint(s + "  ") +
                    s + "STentry: offset " + Integer.toString(this.offset) + "\n";
        } else {
            returnPrint = s + "STentry: nestlev " + Integer.toString(this.nestinglevel) + "\n" +
                    s + "STentry: offset " + Integer.toString(this.offset) + "\n";
        }
        return returnPrint;
    }
}  