package ast;

import parser.FoolOOBaseVisitor;
import parser.FoolOOParser.*;

import java.util.ArrayList;

public class FoolOOVisitorImpl extends FoolOOBaseVisitor<Node> {

    @Override
    public Node visitStart(StartContext ctx) {
        ArrayList<Node> listBlock = new ArrayList<Node>();
        if(ctx.decclass()!=null){
            for(DecclassContext decclassContext : ctx.decclass()){
                listBlock.add( visit(decclassContext) );
            }
        }
        listBlock.add( visit(ctx.main()) );
        return new FoolNode(listBlock);
    }

    @Override
    public Node visitMain(MainContext ctx) {
        ArrayList<Node> listVar = new ArrayList<Node>();
        Node typeNode = visit(ctx.type());
        Node progNode= visit(ctx.prog());

        return new FunNode(ctx.MAIN().getText(), typeNode, listVar, progNode, null);
    }

    @Override
    public Node visitSingleExp(SingleExpContext ctx) {
        Node node = null;
        if (ctx.stms() != null) {
            node = visit(ctx.stms());
        }
        return node;
    }

    @Override
    public Node visitLetInExp(LetInExpContext ctx) {
        ArrayList<Node> listDec = new ArrayList<Node>();
        for(DecContext dec : ctx.let().dec()){
            listDec.add( visit(dec) );
        }
        Node exp = null;
        if (ctx.stms() != null) {
            exp = visit(ctx.stms());
        }
        return new LetInExpNode(listDec,  exp);
    }

    @Override
    public Node visitSingleExpFun(SingleExpFunContext ctx) {
        Node node = null;
        if (ctx.stms() != null) {
            node = visit(ctx.stms());
        }
        return node;
    }

    @Override
    public Node visitLetInExpFun(LetInExpFunContext ctx) {
        ArrayList<Node> listDec = new ArrayList<Node>();
        for(VarasmContext varasm : ctx.letFun().varasm()){
            listDec.add( visit(varasm) );
        }
        Node exp = null;
        if (ctx.stms() != null) {
            exp = visit(ctx.stms());
        }
        return new LetInExpNode(listDec,  exp);
    }


    @Override
    public Node visitDecclass(DecclassContext ctx) {
        Node decNode;
        ArrayList<Node> listVar = new ArrayList<Node>();
        ArrayList<Node> listFun=new ArrayList<Node>();

        if(ctx.vardec()==null) {
            listVar=null;
        }else{
            for (VardecContext vardec : ctx.vardec()) {
                listVar.add(visit(vardec));
            }
        }
        if(ctx.funClass()!=null){
            for(FunClassContext fun : ctx.funClass()){
                listFun.add( visit(fun) );
            }
        }
        if(ctx.funconstructor()!=null){
            for(FunconstructorContext funconstructor : ctx.funconstructor()){
                listFun.add( visit(funconstructor) );
            }
        }
        if(ctx.ID(1)==null){
           decNode= new DecclassNode(ctx.ID(0).getText(), listVar, listFun);
        }else{
            decNode= new DecclassNode(ctx.ID(0).getText(), listVar, listFun, ctx.ID(1).getText());
        }

        return decNode;
    }

    @Override
    public Node visitVardec(VardecContext ctx) {
        return new VarDecNode(ctx.ID().getText(), visit(ctx.type()));
    }

    @Override
    public Node visitExpDecAsignment(ExpDecAsignmentContext ctx) {
        Node varDecNode = visit(ctx.vardec());
        Node expNode = visit(ctx.exp());

        return new VarNode(varDecNode, expNode);
    }

    @Override
    public Node visitStmDecAsignment(StmDecAsignmentContext ctx) {
        Node varDecNode = visit(ctx.vardec());
        Node stmNode = visit(ctx.stm());

        return new VarNode(varDecNode, stmNode);
    }

    @Override
    public Node visitFun(FunContext ctx) {
        ArrayList<Node> listVar = new ArrayList<Node>();
        Node typeNode = visit(ctx.type());
        for(VardecContext dec : ctx.vardec()){
            listVar.add( visit(dec) );
        }
        Node progNode= visit(ctx.progFun());
        Node retNode=null;
        if(ctx.ret()!=null){
            retNode= visit(ctx.ret());
        }

        return new FunNode(ctx.ID().getText(), typeNode, listVar, progNode, retNode);
    }

    @Override
    public Node visitFunClass(FunClassContext ctx) {
        ArrayList<Node> listVar = new ArrayList<Node>();
        Node typeNode = visit(ctx.type());
        for(VardecContext dec : ctx.vardec()){
            listVar.add( visit(dec) );
        }
        Node progNode= visit(ctx.progFun());
        Node retNode=null;
        if(ctx.ret()!=null){
            retNode= visit(ctx.ret());
        }

        return new FunClassNode(ctx.ID().getText(), typeNode, listVar, progNode, retNode);
    }
    @Override
    public Node visitFunconstructor(FunconstructorContext ctx) {
        ArrayList<Node> listVar = new ArrayList<Node>();
        for(VardecContext dec : ctx.vardec()){
            listVar.add( visit(dec) );
        }
        Node progNode= visit(ctx.progFun());

        return new FunConstructorNode(ctx.ID().getText(), listVar, progNode);
    }

    @Override
    public Node visitReturnFunExp(ReturnFunExpContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public Node visitReturnFunStms(ReturnFunStmsContext ctx) {
        return visit(ctx.stm());
    }

    @Override
    public Node visitVarAssignment(VarAssignmentContext ctx) {
        return visit(ctx.varasm());
    }

    @Override
    public Node visitFunDeclaration(FunDeclarationContext ctx) {
        return visit(ctx.fun());
    }

    @Override
    public Node visitType(TypeContext ctx) {
        String type=ctx.getText();
        Node typeNode;
        if(type.equals("int")){
            typeNode= new IntTypeNode();
        }else{
            if(type.equals("bool")){
                typeNode= new BoolTypeNode();
            }else{
                if(type.equals("void")){
                    typeNode= new VoidTypeNode();
                }else{
                    typeNode= new IdTypeNode(type);
                }
            }
        }
        return typeNode;
    }

    @Override
    public Node visitExp(ExpContext ctx) {
        Node node;
        String leftMinus=null;
        if (ctx.right==null) {
            if(ctx.MINUS().size()==1){
                node = new ExpNode(visit(ctx.left),null,null,"-");
            } else {
                node=visit(ctx.left);
            }

        }else{
            String operator=null;
            if((ctx.PLUS()!=null)) {
                if(ctx.MINUS().size()==1){
                    leftMinus="-";
                }
                operator = "+";
            } else {
                if(ctx.MINUS().size()==2){
                    leftMinus="-";
                }
                operator = "-";
            }
            node=new ExpNode(visit(ctx.left), visit(ctx.right),operator,leftMinus);
        }

        return node;
    }

    @Override
    public Node visitTerm(TermContext ctx) {
        Node node;
        if (ctx.right==null) {
            node= visit(ctx.left);
        }else{
            String operator="";
            if ((ctx.TIMES()!= null)){
                operator = "*";
            }else {
                operator = "/";
            }
            node=new TermNode(visit(ctx.left), visit(ctx.right),operator);
        }

        return node;
    }

    @Override
    public Node visitFactor(FactorContext ctx) {
        Node node;
        boolean notLeft = false;
        boolean notRight = false;

        if (ctx.factorRight()==null) {
            if (ctx.NOT()!=null){
               node = new FactorNode(visit(ctx.left), true);
            }else{
                node= visit(ctx.left);
            }

        }else{
            if (ctx.NOT()!=null){
                notLeft = true;
            }
            if (ctx.factorRight().NOT()!=null){
                notRight = true;
            }
            String operator = "";
            if (ctx.EQ()!=null){
                operator = "==";
            }else if (ctx.GTEQ()!=null){
                operator = ">=";
            }else if (ctx.LTEQ()!=null){
                operator = "<=";
            }else if (ctx.AND()!=null){
                operator = "&&";
            }else if (ctx.OR()!=null){
                operator = "||";
            }

            node=new FactorNode(visit(ctx.left), visit(ctx.factorRight().right), operator, notLeft, notRight);
        }

        return node;
    }

    @Override
    public Node visitStmAssignment(StmAssignmentContext ctx) {
        return new AsmNode(ctx.ID().getText(), visit(ctx.stm()));
    }
    @Override
    public Node visitStmValAssignment(StmValAssignmentContext ctx) {
        return new AsmNode(ctx.ID().getText(), visit(ctx.exp()));
    }

    @Override
    public Node visitStmIf(StmIfContext ctx) {
        Node ifNode;
        if (ctx.elseBranch==null) {
            ifNode=new IfNode(visit(ctx.cond),  visit(ctx.thenBranch));
        }else{
            ifNode=new IfNode(visit(ctx.cond),  visit(ctx.thenBranch), visit(ctx.elseBranch));
        }

        return ifNode;
    }

    @Override
    public Node visitStmPrint(StmPrintContext ctx) {
        return new PrintNode(visit(ctx.exp()));
    }

    @Override
    public Node visitCallFunExp(CallFunExpContext ctx) {
        return visit(ctx.funExp());
    }


    @Override
    public Node visitCallMethod(CallMethodContext ctx) {
        return new CallMethodNode(ctx.ID().getText(), (FunExpNode) visit(ctx.funExp()));
    }

    @Override
    public Node visitFunExp(FunExpContext ctx) {
        ArrayList<Node> listVar = new ArrayList<Node>();
        for(ExpContext expContext : ctx.exp()){
            listVar.add( visit(expContext) );
        }

        return new FunExpNode(ctx.ID().getText(), listVar);
    }

    @Override
    public Node visitStms(StmsContext ctx) {
        ArrayList<Node> listStms = new ArrayList<Node>();
        for(StmContext stmContext : ctx.stm()){
            listStms.add( visit(stmContext) );
        }
        return new StmsNode(listStms);
    }

    @Override
    public Node visitIntVal(IntValContext ctx) {
        return new IntNode(Integer.parseInt(ctx.INTEGER().getText()));
    }

    @Override
    public Node visitBoolVal(BoolValContext ctx) {
        return new BoolNode(Boolean.parseBoolean(ctx.getText()));
    }

    @Override
    public Node visitBaseExp(BaseExpContext ctx) {
        return visit(ctx.exp());
    }

    @Override
    public Node visitIfExp(IfExpContext ctx) {
        Node ifNode;
        if (ctx.elseBranch==null) {
            ifNode=new IfNode(visit(ctx.cond),  visit(ctx.thenBranch));
        }else{
            ifNode=new IfNode(visit(ctx.cond),  visit(ctx.thenBranch), visit(ctx.elseBranch));
        }

        return ifNode;
    }

    @Override
    public Node visitStmsExp(StmsExpContext ctx) {
        return visit(ctx.stm());
    }

    @Override
    public Node visitVarExp(VarExpContext ctx) {
        return new IdNode(ctx.ID().getText());
    }

    @Override
    public Node visitNullVal(NullValContext ctx) {
        return new NullNode();
    }

    @Override
    public Node visitNewClass(NewClassContext ctx) {
        ArrayList<Node> listPar = new ArrayList<Node>();
        for(ExpContext expContext : ctx.exp()){
            listPar.add( visit(expContext) );
        }

        return new NewClassNode(ctx.ID().getText(), listPar);
    }

    @Override
    public Node visitFunExpValue(FunExpValueContext ctx) {
        return visit(ctx.funExp());
    }

    @Override
    public Node visitCallMethodValue(CallMethodValueContext ctx) {
        return new CallMethodNode(ctx.ID().getText(), (FunExpNode) visit(ctx.funExp()));
    }
}