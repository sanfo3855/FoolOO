import ast.FoolOOVisitorImpl;
import ast.Node;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import parser.FoolOOLexer;
import parser.FoolOOParser;

import java.io.FileInputStream;

public class FoolOOMain {
    public static void main(String[] args) throws Exception {

        String fileName = "code/provaFunz.fool";

        FileInputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        FoolOOLexer lexer = new FoolOOLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        if (lexer.lexicalErrors > 0) {
            System.out.println("The program was not in the right format. Exiting the compilation process now");
        } else {

            FoolOOParser parser = new FoolOOParser(tokens);

            FoolOOVisitorImpl visitor = new FoolOOVisitorImpl();

            Node ast = visitor.visit(parser.start()); //generazione AST

            System.out.print(ast);
        }
    }
}