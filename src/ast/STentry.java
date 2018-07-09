package ast;

public class STentry {

    private int nestinglevel;
    private Node type;
    private int offset;
    private int offsetObj;

    /**
     * Constructor for STentry without type.
     *
     * @param nestinglevel --> entry nesting level
     * @param offset --> entry offset
     */
    public STentry(int nestinglevel, int offset) {
        this.nestinglevel = nestinglevel;
        this.offset = offset;
    }

    /**
     * Constructor for STentry with type.
     *
     * @param nestinglevel --> entry nesting level
     * @param type --> entry type
     * @param offset --> entry offset
     */
    public STentry(int nestinglevel, Node type, int offset) {
        this.nestinglevel = nestinglevel;
        this.type = type;
        this.offset = offset;
        this.offsetObj = 0;
    }

    public STentry(int nestinglevel, Node type, int offset, int offsetObj) {
        this.nestinglevel = nestinglevel;
        this.type = type;
        this.offset = offset;
        this.offsetObj = offsetObj;
    }

    /**
     * Add the type of the entry.
     *
     * @param type
     */
    public void addType(Node type) {
        this.type = type;
    }

    /**
     *
     * @return type of the entry
     */
    public Node getType() {
        return this.type;
    }

    /**
     *
     * @return offset of the entry
     */
    public int getOffset() {
        return this.offset;
    }

    /**
     *
     * @return nesting level of the entry
     */
    public int getNestinglevel() {
        return this.nestinglevel;
    }

    /**
     *
     * @return offset object
     */
    public int getOffsetObj() {
        return offsetObj;
    }

    /**
     * Print structure of STentry.
     *
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