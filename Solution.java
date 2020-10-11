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
                    break;
                case 1:
                    int length = curFile.GetLengthFromDataFile(curFile.fileNameT);
                    myCommand.target = new String[length];
                    curFile.GetFromDataFile(myCommand.target,curFile.fileNameT);
                    System.out.println("LENGTH = " + length);
                    length = curFile.GetLengthFromDataFile(curFile.fileNameE);
                    myCommand.explain = new String[length];
                    curFile.GetFromDataFile(myCommand.explain,curFile.fileNameE);
                    System.out.println("LENGTH = " + length);
                    myCommand.Arr_Dictionary = new Word[length];
                    for(Word w:myCommand.Arr_Dictionary){
                        System.out.println("w= " + w);
                    }
                    myCommand.updateWord();
                    break;
                case 2:
                    myCommand.searchWord();
                    break;
                case 3:
                    myCommand.addWord();
                    curFile.Create_Replace_StrFile(myCommand.target,curFile.fileNameT);
                    curFile.Create_Replace_StrFile(myCommand.explain,curFile.fileNameE);
                    break;
                case 4:
                    myCommand.deleteWord();
                    curFile.Create_Replace_StrFile(myCommand.target,curFile.fileNameT);
                    curFile.Create_Replace_StrFile(myCommand.explain,curFile.fileNameE);
                    break;
                case 5:
                    myCommand.showAllWord();
                    break;
                case 6:
                    myCommand.quit();
                    break;
            }

        }

        /*
        System.out.println("\n" + "End of loop! Arr,length = " + myCommand.target.length);
        for (int i = 0; i < myCommand.target.length; i++) {
            System.out.print("\n" + "After loop condition !!!!");
            System.out.println(myCommand.target[i] + "\n");
            System.out.println("Target.toString = " + myCommand.target.toString());
        }

         */

        /*
        String folderPath = "C:\\Users\\Mr. BDHung\\Desktop\\OOP\\include";
        System.out.print("Insert your file name: ");
        String fileName = sc.next();
        fileName = folderPath + "\\" + fileName + ".txt";
        System.out.println(fileName);
        */
/*
        String fileName1 = "C:\\Users\\Mr. BDHung\\Desktop\\OOP\\include\\Tdata.txt";
        String fileName2 = "C:\\Users\\Mr. BDHung\\Desktop\\OOP\\include\\Edata.txt";
        try {
            File myFile = new File(fileName1);
            if (myFile.createNewFile()) {
                System.out.println("file created " + myFile.getName());

            } else {
                System.out.println("File already exists");

            }
            // handle file if it was created
            // append file with "boolean" in constructor
            FileWriter fw = new FileWriter(myFile, true);
            // buffer output
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < myCommand.target.length; i++) {
                bw.write(myCommand.target[i]);

            }
            bw.close();
            Scanner myReader = new Scanner(myFile);
            System.out.println("Target data: ");
            while (myReader.hasNextLine()) {
                String curWord = myReader.nextLine();
                System.out.println(curWord);
            }
            System.out.println("\n" + "End of file!");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // Explain data
        try {
            File myFile = new File(fileName2);
            if (myFile.createNewFile()) {
                System.out.println("file created " + myFile.getName());

            } else {
                System.out.println("File already exists");

            }
            // handle file if it was created
            // append file with "boolean" in constructor
            FileWriter fw = new FileWriter(myFile, true);
            // buffer output
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < myCommand.explain.length; i++) {
                bw.write(myCommand.explain[i]);

            }
            bw.close();
            Scanner myReader = new Scanner(myFile);
            System.out.println("Explain data: ");
            while (myReader.hasNextLine()) {
                String curWord = myReader.nextLine();
                System.out.println(curWord);
            }
            System.out.println("\n" + "End of file!");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    */
    }
}
