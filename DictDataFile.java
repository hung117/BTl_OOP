import java.io.*;
import java.util.Scanner;
// handle exception

public class DictDataFile extends Dictionary {

    public String fileNameT = "C:\\Users\\Mr. BDHung\\Desktop\\OOP\\include\\Tdata.txt";
    public String fileNameE = "C:\\Users\\Mr. BDHung\\Desktop\\OOP\\include\\Edata.txt";

    public DictDataFile() {
    }

    public void Create_Append_StrFile(String[] arr, String curFile) throws IOException {
        try {
            File myFile = new File(curFile);
            if (myFile.createNewFile()) {
                System.out.println("File created " + myFile.getName());
            } else {
                System.out.println("File already exists");
            }
            // handle file if it was created
            // append file with "boolean" in constructor
            FileWriter fw = new FileWriter(myFile, true);
            // buffer output
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i]);
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
    }

    public void Create_Replace_StrFile(String[] arr, String curFile) throws IOException {
        try {
            File myFile = new File(curFile);
            PrintWriter pw = new PrintWriter(myFile);
            for (int i = 0; i < arr.length; i++) {
                pw.println(arr[i]);
            }
            pw.close();
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
    }
}
