import java.io.*;
import java.nio.channels.FileLockInterruptionException;
import java.util.Scanner;
// handle exception

public class DictDataFile extends Dictionary {

    public String fileNameT = "src\\Target.txt";
    public String fileNameE = "src\\Explain.txt";

    public DictDataFile() {
    }

    /*
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

     */

    public void Create_Replace_StrFile(String[] arr, String curFile) throws IOException {
        try {
            File myFile = new File(curFile);
            PrintWriter pw = new PrintWriter(myFile);
            for (int i = 0; i < arr.length; i++) {
                pw.println(arr[i]);
            }
            pw.close();
            Scanner myReader = new Scanner(myFile);
            //System.out.println("Target data: ");
            while (myReader.hasNextLine()) {
                String curWord = myReader.nextLine();
               // System.out.println(curWord);
            }
            //System.out.println("\n" + "End of file!");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // replace cur data with data from file

    public void GetFromDataFile(String[] arr, String curFile) {
        try {
            File myFile = new File(curFile);
            FileReader fr = new FileReader(myFile);

            BufferedReader bf = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            //System.out.println("SB.length=" + sb.length());
            String[] arrLine = sb.toString().split("\\n");

            int i = 0;
            for (String s : arrLine) {
                //System.out.print("Content: " + s);
                arr[i] = s;
                //System.out.println("    arr[" + i + "]=" + arr[i]);
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int GetLengthFromDataFile(String curFile) {
        int Datalength = 0;
        try {
            File myFile = new File(curFile);
            FileReader fr = new FileReader(myFile);

            BufferedReader bf = new BufferedReader(fr);
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = bf.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            fr.close();
            String[] arrLine = sb.toString().split("\\n");
            Datalength = arrLine.length;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Datalength;
    }
}
