package parser;
public class ExecuteVM {

    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 100;

    private int[] code;
    private int[] memory = new int[MEMSIZE];

    private int ip = 0;
    private int sp = MEMSIZE;

    private int hp = 0;
    private int fp = MEMSIZE;
    private int ra;
    private int rv;
    private int fpo;
    private int pn=0;
    private int fpof=0;

    public ExecuteVM(int[] code) {
        this.code = code;
    }

    public void cpu() {
        while ( true ) {
            if(sp<=hp){
                System.out.println("Out of Memory");
                return;
            }
            int bytecode = code[ip++]; // fetch
            int v1,v2;
            int address;
            switch ( bytecode ) {
                case SVMParser.PUSH:
                    push( code[ip++] );
                    break;
                case SVMParser.POP:
                    pop();
                    break;
                case SVMParser.ADD :
                    v1=pop();
                    v2=pop();
                    push(v2 + v1);
                    break;
                case SVMParser.MULT :
                    v1=pop();
                    v2=pop();
                    push(v2 * v1);
                    break;
                case SVMParser.DIV :
                    v1=pop();
                    v2=pop();
                    push(v2 / v1);
                    break;
                case SVMParser.SUB :
                    v1=pop();
                    v2=pop();
                    push(v2 - v1);
                    break;
                case SVMParser.STOREW : //
                    address = pop();
                    memory[address] = pop();
                    break;
                case SVMParser.LOADW : //
                    push(memory[pop()]);
                    break;
                case SVMParser.BRANCH :
                    address = code[ip];
                    ip = address;
                    break;
                case SVMParser.BRANCHEQ : //
                    address = code[ip++];
                    v1=pop();
                    v2=pop();
                    if (v2 == v1) ip = address;
                    break;
                case SVMParser.BRANCHLESSEQ :
                    address = code[ip++];
                    v1=pop();
                    v2=pop();
                    if (v2 <= v1) ip = address;
                    break;
                case SVMParser.BRANCHGREATEREQ :
                    address = code[ip++];
                    v1=pop();
                    v2=pop();
                    if (v2 >= v1) ip = address;
                    break;
                case SVMParser.JS : //
                    address = pop();
                    ra = ip;
                    ip = address;
                    break;
                case SVMParser.STORERA : //
                    ra=pop();
                    break;
                case SVMParser.LOADRA : //
                    push(ra);
                    break;
                case SVMParser.STORERV : //
                    rv=pop();
                    break;
                case SVMParser.LOADRV : //
                    push(rv);
                    break;
                case SVMParser.LOADFP : //
                    push(fp);
                    break;
                case SVMParser.STOREFP : //
                    fp=pop();
                    break;
                case SVMParser.COPYFP : //
                    fp=sp;
                    break;
                case SVMParser.COPYFPM : //
                    fp=sp-1;
                    break;
                case SVMParser.STOREHP : //
                    hp=pop();
                    break;
                case SVMParser.LOADHP : //
                    push(hp);
                    break;
                case SVMParser.PUSHMINUS:
                    push(-pop());
                    break;
                case SVMParser.PRINT :
                    System.out.println((sp<MEMSIZE)?memory[sp++]:"Empty stack!");
                    break;
                case SVMParser.PUSHTOHP:
                    memory[hp++] = pop();
                    break;
                case SVMParser.STOREFPO : //
                    fpo=pop();
                    break;
                case SVMParser.LOADFPO : //
                    push(fpo);
                    break;
                case SVMParser.COPYFPO : //
                    fp=fpo;
                    break;
                case SVMParser.COPYFPP : //
                    fp=sp+pop();
                    break;
                case SVMParser.LOADFP1 : //
                    push(fp+1);
                    break;
                case SVMParser.STOREPN : //
                    pn=pop();
                    break;
                case SVMParser.LOADPN : //
                    push(pn);
                    break;
                case SVMParser.LOADFPOF:
                    push(fpof);
                    break;
                case SVMParser.COPYFPOF : //
                    fpof=fp;
                    break;
                case SVMParser.HALT :
                    return;
            }
        }
    }

    private int pop() {
        return memory[sp++];
    }

    private void push(int v) {
        memory[--sp] = v;
    }

    public int[] getMemory() {
        return memory;
    }

    public void wipeMemory(){
        memory = new int[MEMSIZE];
        ip = 0;
        sp = MEMSIZE;
        hp = 0;
        fp = MEMSIZE;
        ra=0;
        rv=0;
        fpo=0;
    }
}