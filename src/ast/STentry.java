package ast;

public class STentry {

    private int nestinglevel;
    private Node type;
    private int offset;

    public STentry(int nestinglevel, int offset) {
        this.nestinglevel = nestinglevel;
        this.offset = offset;
    }

    public STentry(int nestinglevel, Node type, int offset) {
        this.nestinglevel = nestinglevel;
        this.type = type;
        this.offset = offset;
    }

    public void addType(Node type) {
        this.type = type;
    }

    public Node getType() {
        return this.type;
    }

    public int getOffset() {
        return this.offset;
    }

    public int getNestinglevel() {
        return this.nestinglevel;
    }

    public String toPrint(String s) { //
        return s + "STentry: nestlev " + Integer.toString(this.nestinglevel) + "\n" +
                s + "STentry: type\n" +
//                this.type.toPrint(s + "  ") +
                s + "STentry: offset " + Integer.toString(this.offset) + "\n";
    }
}  