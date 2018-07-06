import lib.FOOLlib;

import java.io.File;

public class AllMain {
    public static void main(String[]args) throws Exception{
        String [] argss = {"",""};

        argss[0]="correct";
        File dir = new File("test/correct/");
        argss[1]= "asignment";
        FoolOOMain.main(argss);

        argss[1] = "classDeclaration";
        FoolOOMain.main(argss);

        argss[1] = "methodCall";
        FoolOOMain.main(argss);

        argss[1] = "function";
        FoolOOMain.main(argss);

        argss[0]="wrong";
        argss[1]= "asignment";
        FoolOOMain.main(argss);

        argss[1]= "classDeclaration";
        FoolOOMain.main(argss);
    }
}
