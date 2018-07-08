import lib.FOOLlib;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AllMain {
    public static void main(String[]args) {
        String [] argss = {"","","false","false","false"};

        argss[0]="correct";
        File[] fileCorrect = new File("test/correct").listFiles();
        for (File file : fileCorrect) {
            if (file.isFile() && !file.getName().contains(".asm") && !file.getName().contains("!")) {
                argss[1] = file.getName();
                FoolOOMain.main(argss);
            }
        }

        argss[0]="wrong";
        File[] fileWrong = new File("test/wrong").listFiles();
        for (File file : fileWrong) {
            if (file.isFile() && !file.getName().contains(".asm")) {
                argss[1] = file.getName();
                FoolOOMain.main(argss);
            }
        }
    }
}
