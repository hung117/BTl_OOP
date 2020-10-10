import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        DictionaryCommandline myCommand = new DictionaryCommandline();

        while (!myCommand.isQuit()) {
            new GUI();
            int option = sc.nextInt();
            String search;
            switch (option) {
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
                    break;
            }

        }

        System.out.println("\n" + "End of loop! Arr,length = " + myCommand.target.length);
        for (int i = 0; i < myCommand.target.length; i++) {
            System.out.print("\n" + "After loop condition !!!!");
            System.out.println(myCommand.target[i] + "\n");
            System.out.println("Target.toString = " + myCommand.target.toString());
        }


        String folderPath = "C:\\Users\\Mr. BDHung\\Desktop\\OOP\\include";
        System.out.print("Insert your file name: ");
        String fileName = sc.next();
        fileName = folderPath + "\\" + fileName + ".txt";
        System.out.println(fileName);


        try {
            File myFile = new File(fileName);
            if (myFile.createNewFile()) {
                System.out.println("file created " + myFile.getName());
                // handle file if it was created
                    // append file with "boolean" in constructor
                FileWriter fw = new FileWriter(myFile,true);
                BufferedWriter bw = new BufferedWriter(fw);


                // output writer
                BufferedWriter ow = null;
                ow = new BufferedWriter(new FileWriter(fileName));
                ow.write(Arrays.toString(myCommand.target));
                
                Scanner myReader = new Scanner(myFile);
                while(myReader.hasNextLine()){
                    String curWord = myReader.nextLine();
                    System.out.println(curWord);
                }
                System.out.println("\n" + "End of file!");
            } else {
                System.out.println("File already exists");
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
