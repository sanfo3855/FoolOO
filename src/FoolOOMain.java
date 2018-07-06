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
import java.util.concurrent.TimeUnit;

public class FoolOOMain {
    public static void main(String[] args) {
        try {
            TimeUnit.MILLISECONDS.sleep(300);
            String fileName = "test/correct/ifBranchChildSameFather.fool";
            //        String fileName = "code/provaCode.fool";
            //String fileName = "code/provaFoolComplete.fool";

            if (args.length > 0) {
                fileName = "test/" + args[0] + "/" + args[1];
            }
            System.out.println("----" + fileName + "----");
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
                    //            System.out.println("Visualizing AST...");
                    //            System.out.println(ast.toPrint(""));
                    //            System.out.println("END AST...");

                    Environment env = new Environment();
                    ArrayList<SemanticError> err = ast.checkSemantics(env);
                    if (err.size() > 0) {
                        System.out.println("You had: " + err.size() + " errors:");
                        for (SemanticError e : err)
                            System.out.println("\t" + e);
                    } else {
                        Node type = ast.typeCheck(); //type-checking bottom-up
                        //System.out.println(type.toPrint("Type checking ok! Type of the program is: "));

                        // CODE GENERATION  prova.fool.asm
                        String code = ast.codeGeneration();
                        //System.out.println(code);
                        BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".asm"));
                        out.write(code);
                        out.close();
                        //System.out.println("Code generated! Assembling and running generated code.");

                        FileInputStream isASM = new FileInputStream(fileName + ".asm");
                        ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
                        SVMLexer lexerASM = new SVMLexer(inputASM);
                        CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
                        SVMParser parserASM = new SVMParser(tokensASM);

                        parserASM.assembly();

                        //                    System.out.println("You had: " + lexerASM.lexicalErrors + " lexical errors and " + parserASM.getNumberOfSyntaxErrors() + " syntax errors.");
                        //                    if (lexerASM.lexicalErrors > 0 || parserASM.getNumberOfSyntaxErrors() > 0) System.exit(1);

                        //                    System.out.println("Starting Virtual Machine...");
                        ExecuteVM vm = new ExecuteVM(parserASM.code);
                        vm.cpu();
                                            System.out.println("\n\n");
                                            for (int x : vm.getMemory())
                                                System.out.println(x);
                        FOOLlib.wipe();
                        vm.wipeMemory();

                    }
                }
            }
        } catch (Exception ex) {
            String error = "\u001B[31m"+ ex.toString();
            System.out.println(error);
            StackTraceElement [] stackTrace = ex.getStackTrace();
            for(StackTraceElement st: stackTrace) {
                System.out.println(st);
            }
            System.out.println("\u001B[0m");
        }
    }
}