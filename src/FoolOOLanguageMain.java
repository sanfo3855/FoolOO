import ast.FoolOOVisitorImpl;
import ast.Node;

import lib.FOOLlib;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.*;
import util.Environment;
import util.SemanticError;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;

public class FoolOOLanguageMain {
    public static void main(String[] args) {
        String err = "\u001B[31m";
        String stopErr = "\u001B[0m";
        try {
            String fileName = null;
            if(args.length==1 && args[0].endsWith(".fool")){
                fileName = args[0];
                FileInputStream is = new FileInputStream(fileName);
                ANTLRInputStream input = new ANTLRInputStream(is);
                FoolOOLexer lexer = new FoolOOLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                if (lexer.lexicalErrors > 0) {
                    System.out.println("Lexical Error found. Exiting process\n");
                } else {
                    FoolOOParser parser = new FoolOOParser(tokens);
                    FoolOOVisitorImpl visitor = new FoolOOVisitorImpl();
                    //Generazione AST
                    Node ast = visitor.visit(parser.start());
                    if (parser.getNumberOfSyntaxErrors() == 0) {
                        Environment env = new Environment();
                        ArrayList<SemanticError> error = ast.checkSemantics(env);
                        if (error.size() > 0) {
                            System.out.println(err+"You have: " + error.size() + " errors:");
                            for (SemanticError e : error)
                                System.out.println("\t" + e);
                            System.out.println(stopErr);
                        } else {
                            Node type = ast.typeCheck(); //type-checking bottom-up
                            // CODE GENERATION  prova.fool.asm
                            String code = ast.codeGeneration();
                            BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".asm"));
                            out.write(code);
                            out.close();

                            FileInputStream isASM = new FileInputStream(fileName + ".asm");
                            ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
                            SVMLexer lexerASM = new SVMLexer(inputASM);
                            CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
                            SVMParser parserASM = new SVMParser(tokensASM);

                            parserASM.assembly();

                            ExecuteVM vm = new ExecuteVM(parserASM.code);
                            vm.cpu();
                            FOOLlib.wipe();
                            vm.wipeMemory();
                        }
                    }
                }
            } else {
                System.out.println(err);
                if(args.length==1){
                    System.out.println("Fool language <file>.fool needed. \n\tFound " + args[0]);
                } else {
                    System.out.println("Fool language <file>.fool needed.");
                }

                System.out.println(stopErr);
            }
        } catch (Exception ex) {
            System.out.println(err);
            System.out.println( ex.toString() );
//            StackTraceElement [] stack = ex.getStackTrace();
//            for(StackTraceElement st: stack) {
//                System.out.println(st);
//            }
            System.out.println(stopErr);
        }
    }
}