import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        DictionaryCommandline myCommand = new DictionaryCommandline();
        while (myCommand.isQuit() != true) {
            new GUI();
            int option = sc.nextInt();
            String search;
            switch (option){
                case 0:
                    myCommand.insertFromCommandline();
                    break;
                case 1:
                    myCommand.searchWord();
                    break;
                case 2:
                    myCommand.addWord();
                    break;
                case 3:
                    myCommand.deleteWord();
                    break;
                case 4:
                    myCommand.showAllWord();
                    break;
                case 5:
                    myCommand.quit();
            }

        }
        /*

        String folderPath = "C:\\Users\\Mr. BDHung\\Desktop\\OOP\\include";
        String fileName = sc.nextLine();
        fileName = folderPath + "\\" + fileName + ".txt";
        System.out.println(fileName);


        try {
            File myFile = new File(fileName);
            if (myFile.createNewFile()) {
                System.out.println("file created " + myFile.getName());
            } else {
                System.out.println("File already exists");
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

         */
    }
}
