import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        DictDataFile curFile = new DictDataFile();
        DictGUIAction myCommand = new DictGUIAction();
        //GUI GUI= new GUI();

        SwingGUI myGUI = new SwingGUI();
        myGUI.CreateGUI();
        curFile.Create_Replace_StrFile(myCommand.target,curFile.fileNameT);
        curFile.Create_Replace_StrFile(myCommand.explain,curFile.fileNameE);
        curFile.Create_Replace_StrFile(myCommand.pronounce,curFile.fileNameP);

    }
}
