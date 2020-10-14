import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        DictDataFile curFile = new DictDataFile();
        DictionaryCommandline myCommand = new DictionaryCommandline();

        while (!myCommand.isQuit()) {
            new GUI();
            int option = sc.nextInt();
            String search;
            switch (option) {
                case 0:
                    myCommand.insertFromCommandline();
                    curFile.Create_Replace_StrFile(myCommand.target,curFile.fileNameT);
                    curFile.Create_Replace_StrFile(myCommand.explain,curFile.fileNameE);
                    curFile.Create_Replace_StrFile(myCommand.prounounce,curFile.fileNameP);
                    break;
                case 1:
                    int length = curFile.GetLengthFromDataFile(curFile.fileNameT);
                    myCommand.target = new String[length];
                    curFile.GetFromDataFile(myCommand.target,curFile.fileNameT);

                    length = curFile.GetLengthFromDataFile(curFile.fileNameE);
                    myCommand.explain = new String[length];
                    curFile.GetFromDataFile(myCommand.explain,curFile.fileNameE);

                    length = curFile.GetLengthFromDataFile(curFile.fileNameP);
                    myCommand.prounounce = new String[length];
                    curFile.GetFromDataFile(myCommand.prounounce,curFile.fileNameP);

                    myCommand.Arr_Dictionary = new Word[length];
                    myCommand.updateWord();
                    break;
                case 2:
                    myCommand.searchWord();
                    break;
                case 3:
                    myCommand.addWord();
                    curFile.Create_Replace_StrFile(myCommand.target,curFile.fileNameT);
                    curFile.Create_Replace_StrFile(myCommand.explain,curFile.fileNameE);
                    curFile.Create_Replace_StrFile(myCommand.prounounce,curFile.fileNameP);
                    break;
                case 4:
                    myCommand.deleteWord();
                    curFile.Create_Replace_StrFile(myCommand.target,curFile.fileNameT);
                    curFile.Create_Replace_StrFile(myCommand.explain,curFile.fileNameE);
                    curFile.Create_Replace_StrFile(myCommand.prounounce,curFile.fileNameP);
                    break;
                case 5:
                    myCommand.showAllWord();
                    break;
                case 6:
                    myCommand.quit();
                    break;
            }

        }
    }
}
