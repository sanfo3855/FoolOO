package ast;

import org.antlr.v4.runtime.tree.TerminalNode;
import parser.FoolOOBaseVisitor;
import parser.FoolOOParser.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoolOOVisitorImpl extends FoolOOBaseVisitor<Node> {


    @Override
    public Node visitMainDeclaration(MainDeclarationContext ctx) {
        ArrayList<Node> listVar = new ArrayList<Node>();
        Node typeNode = visit(ctx.type());

        return new FunNode(ctx.MAIN().getText(), typeNode, listVar);
    }

    @Override
    public Node visitSingleExp(SingleExpContext ctx) {
        return visit(ctx.exp());
    }

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
        Node decNode;
        ArrayList<Node> listVar = new ArrayList<Node>();

        for(VardecContext dec : ctx.vardec()){
            listVar.add( visit(dec) );
        }

        if(ctx.eextends()==null){
           decNode= new DecclassNode(ctx.ID().getText(), listVar);
        }else{
            decNode= new DecclassNode(ctx.ID().getText(), listVar, ctx.eextends().getText());
        }

        return decNode;
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
        ArrayList<Node> listVar = new ArrayList<Node>();

        Node typeNode = visit(ctx.type());

        for(VardecContext dec : ctx.vardec()){
            listVar.add( visit(dec) );
        }

        return new FunNode(ctx.ID().getText(), typeNode, listVar);
    }

    @Override
    public Node visitType(TypeContext ctx) {
        String type=ctx.getText();
        Node typeNode=null;
        if(type.equals("int")){
            typeNode= new IntTypeNode();
        }else{
            if(type.equals("bool")){
                typeNode= new BoolTypeNode();
            }else{
                if(type.equals("void")){
                    typeNode= new VoidTypeNode();
                }else{
                    Pattern pattern = Pattern.compile("[a-zA-Z]+[a-zA-Z0-9]");
                    Matcher matcher = pattern.matcher(type);

                    System.out.print(type+"....\n");
                    if (matcher.matches()){

                        System.out.print(true);
                        typeNode= new IdTypeNode();
                    }
                }
            }
        }

        //this will never happen thanks to the parser
        return typeNode;
    }

    @Override
    public Node visitExp(ExpContext ctx) {
        Node node;

        if (ctx.right==null) {
            node= visit(ctx.left);
        }else{
            node=new ExpNode(visit(ctx.left), visit(ctx.right));
        }
        return node;
    }

    @Override
    public Node visitTerm(TermContext ctx) {
        Node node;

        if (ctx.right==null) {
            node= visit(ctx.left);
        }else{
            node=new TermNode(visit(ctx.left), visit(ctx.right));
        }
        return node;
    }

    @Override
    public Node visitFactor(FactorContext ctx) {
        Node node;

        if (ctx.right==null) {
            node= visit(ctx.left);
        }else{
            node=new FactorNode(visit(ctx.left), visit(ctx.right));
        }
        return node;
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
    public Node visitFunExp(FunExpContext ctx) {
        ArrayList<Node> listVar = new ArrayList<Node>();

        for(ExpContext dec : ctx.exp()){
            listVar.add( visit(dec) );
        }
        return new FunExpNode(ctx.ID().getText(), listVar);
    }

    @Override
    public Node visitCallMethod(CallMethodContext ctx) {

        Map<String, ArrayList<Node>> listField= new HashMap<String, ArrayList<Node>>();
        ArrayList<Node> listVar;

        for(TerminalNode id : ctx.ID()){
            if(!(id.equals(ctx.ID(0)))){
                listVar = new ArrayList<Node>();
                for(ExpContext dec : ctx.exp()){
                    listVar.add( visit(dec) );
                }
                listField.put(id.getText(),listVar);
            }
        }
        return new CallMethodNode(ctx.ID(0).getText(), listField);
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
}