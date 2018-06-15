package ast;

import parser.FoolOOBaseVisitor;
import parser.FoolOOParser.*;

import java.util.ArrayList;

public class FoolOOVisitorImpl extends FoolOOBaseVisitor<Node> {

//    @Override
//    public Node visitStart(StartContext ctx) {
//        return visitChildren(ctx.);
//    }


//    @Override
//    public Node visitProgDeclaration(ProgDeclarationContext ctx) {
//        return visitChildren(ctx);
//    }
//
//
//    @Override
//    public Node visitClassDeclaration(ClassDeclarationContext ctx) {
//        return visitChildren(ctx);
//    }

//    @Override
//    public Node visitSingleExp(SingleExpContext ctx) {
//        return visitChildren(ctx);
//    }

    @Override
    public Node visitLetInExp(LetInExpContext ctx) {
        //resulting node of the right type
        LetInExpNode res;

        //list of declarations in @res
        ArrayList<Node> listDec = new ArrayList<Node>();

        //visit all nodes corresponding to declarations inside the let context and store them in @declarations
        //notice that the ctx.let().dec() method returns a list, this is because of the use of * or + in the grammar
        //antlr detects this is a group and therefore returns a list
        for(DecContext dec : ctx.let().dec()){
            listDec.add( visit(dec) );
        }

        //visit exp context
        Node exp = visit( ctx.exp() );

        //build @res accordingly with the result of the visits to its content
        res = new LetInExpNode(listDec,  exp);

        return res;
    }

    @Override
    public Node visitDecclass(DecclassContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitEextends(EextendsContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitLet(LetContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitVardec(VardecContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitVarasm(VarasmContext ctx) {
        //declare the result node
        VarNode result;

        //visit the type
        Node typeNode = visit(ctx.vardec().type());

        //visit the exp
        Node expNode = visit(ctx.exp());

        //build the varNode
        return new VarNode(ctx.vardec().ID().getText(), typeNode, expNode);
    }

    @Override
    public Node visitFun(FunContext ctx) {
        return visitChildren(ctx);
    }
//
//    @Override
//    public Node visitVarAssignment(VarAssignmentContext ctx) {
//        return visitChildren(ctx);
//    }
//
//    @Override
//    public Node visitFunDeclaration(FunDeclarationContext ctx) {
//        return visitChildren(ctx);
//    }

//    @Override
//    public Node visitType(TypeContext ctx) {
//        return visitChildren(ctx);
//    }

    @Override
    public Node visitExp(ExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitTerm(TermContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitFactor(FactorContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitStmExpAsignment(StmExpAsignmentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitStmAsignment(StmAsignmentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitStmValAsignment(StmValAsignmentContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitStmIf(StmIfContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitStmPrint(StmPrintContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitFunExp(FunExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitCallMethod(CallMethodContext ctx) {
        return visitChildren(ctx);
    }

//    @Override
//    public Node visitStms(StmsContext ctx) {
//        return visitChildren(ctx);
//    }

    @Override
    public Node visitIntVal(IntValContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitBoolVal(BoolValContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitReturnFun(ReturnFunContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitBaseExp(BaseExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitIfExp(IfExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitStmsExp(StmsExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitVarExp(VarExpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitNullVal(NullValContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Node visitNewClass(NewClassContext ctx) {
        return visitChildren(ctx);
    }
}