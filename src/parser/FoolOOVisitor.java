// Generated from /Users/MatteoMarchesini/FoolOO/src/parser/FoolOO.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FoolOOParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FoolOOVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(FoolOOParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mainDeclaration}
	 * labeled alternative in {@link FoolOOParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainDeclaration(FoolOOParser.MainDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDeclaration}
	 * labeled alternative in {@link FoolOOParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(FoolOOParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link FoolOOParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExp(FoolOOParser.SingleExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link FoolOOParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetInExp(FoolOOParser.LetInExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#decclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecclass(FoolOOParser.DecclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(FoolOOParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(FoolOOParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expDecAsignment}
	 * labeled alternative in {@link FoolOOParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpDecAsignment(FoolOOParser.ExpDecAsignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmDecAsignment}
	 * labeled alternative in {@link FoolOOParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmDecAsignment(FoolOOParser.StmDecAsignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(FoolOOParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#funconstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunconstructor(FoolOOParser.FunconstructorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnFunExp}
	 * labeled alternative in {@link FoolOOParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFunExp(FoolOOParser.ReturnFunExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnFunStms}
	 * labeled alternative in {@link FoolOOParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnFunStms(FoolOOParser.ReturnFunStmsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link FoolOOParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignment(FoolOOParser.VarAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDeclaration}
	 * labeled alternative in {@link FoolOOParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDeclaration(FoolOOParser.FunDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(FoolOOParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(FoolOOParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(FoolOOParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(FoolOOParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#factorRight}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorRight(FoolOOParser.FactorRightContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmIf}
	 * labeled alternative in {@link FoolOOParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmIf(FoolOOParser.StmIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmPrint}
	 * labeled alternative in {@link FoolOOParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmPrint(FoolOOParser.StmPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callFunExp}
	 * labeled alternative in {@link FoolOOParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunExp(FoolOOParser.CallFunExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callMethod}
	 * labeled alternative in {@link FoolOOParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallMethod(FoolOOParser.CallMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmAsignment}
	 * labeled alternative in {@link FoolOOParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmAsignment(FoolOOParser.StmAsignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmValAsignment}
	 * labeled alternative in {@link FoolOOParser#stm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmValAsignment(FoolOOParser.StmValAsignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#funExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunExp(FoolOOParser.FunExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FoolOOParser#stms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStms(FoolOOParser.StmsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(FoolOOParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVal(FoolOOParser.BoolValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseExp(FoolOOParser.BaseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExp(FoolOOParser.IfExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmsExp}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmsExp(FoolOOParser.StmsExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExp(FoolOOParser.VarExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullVal}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullVal(FoolOOParser.NullValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newClass}
	 * labeled alternative in {@link FoolOOParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewClass(FoolOOParser.NewClassContext ctx);
}