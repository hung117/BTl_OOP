import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class DictGUIAction extends DictionaryManagement {
    //@Override

    public void addWord(String strT, String strE, String strP) throws IOException {
        File fileT = new File("src\\Tdata.txt");
        File fileE = new File("src\\Edata.txt");
        File fileP = new File("src\\Pdata.txt");

        BufferedReader checkDup = new BufferedReader(new FileReader(fileT));

        FileWriter fwT = new FileWriter(fileT,true);
        FileWriter fwE = new FileWriter(fileE,true);
        FileWriter fwP = new FileWriter(fileP,true);

        String lineT = checkDup.readLine();
        while (lineT != null){
            if(lineT.equals(strT)){
                return;
            }
            lineT = checkDup.readLine();
        }
        fwT.write(strT+"\n");
        fwE.write(strE+"\n");
        fwP.write(strP+"\n");

        checkDup.close();
        fwE.close();
        fwP.close();
        fwT.close();
    }

    public String showWord(DictDataFile curFile) throws FileNotFoundException {
        String temptStr = "No     " + "| English        " + "| VietNamese" + "      | Pronounce" + "\n";
        int counter = 1;
        try {

            File dataT = new File(curFile.fileNameT);
            File dataE = new File(curFile.fileNameE);
            File dataP = new File(curFile.fileNameP);
            Scanner readT = new Scanner(dataT);
            Scanner readE = new Scanner(dataE);
            Scanner readP = new Scanner(dataP);
            while (readT.hasNextLine()) {
                temptStr = temptStr + "NO#" + counter + "  " + readT.nextLine() + "                   " + readE.nextLine() + "                     " + readP.nextLine() + "\n";
                counter++;
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return temptStr;
    }

    public boolean deleteWord(String wordToDelete) throws IOException {

        File fileT = new File("src\\Tdata.txt");
        File fileE = new File("src\\Edata.txt");
        File fileP = new File("src\\Pdata.txt");

        BufferedReader check = new BufferedReader(new FileReader(fileT));

        String checkLine = check.readLine();
        boolean checkWord = false;

        while (checkLine != null){
            if(checkLine.equals(wordToDelete)) {
                checkWord = true;
            }
            checkLine=check.readLine();
        }
        check.close();

        if (!checkWord) {
            return false;
        }else {

            BufferedReader inT = new BufferedReader(new FileReader(fileT));
            BufferedReader inE = new BufferedReader(new FileReader(fileE));
            BufferedReader inP = new BufferedReader(new FileReader(fileP));

            String lineT = inT.readLine();
            String lineE = inE.readLine();
            String lineP = inP.readLine();

            File tempT = new File("src\\tempT.txt");
            File tempE = new File("src\\tempE.txt");
            File tempP = new File("src\\tempP.txt");

            FileWriter outT = new FileWriter(tempT, true);
            FileWriter outE = new FileWriter(tempE, true);
            FileWriter outP = new FileWriter(tempP, true);

            while (lineT != null) {

                if (!lineT.equals(wordToDelete)) {
                    outT.write(lineT + "\n");
                    if (lineE != null) outE.write(lineE + "\n");
                    if (lineP != null) outP.write(lineP + "\n");
                }

                lineT = inT.readLine();
                lineE = inE.readLine();
                lineP = inP.readLine();
            }
            inT.close();
            inE.close();
            inP.close();

            outT.close();
            outE.close();
            outP.close();

            if(fileT.delete() && fileE.delete() &&fileP.delete()){
                //System.out.println("deleted");
            }

            if (tempT.renameTo(fileT) && tempE.renameTo(fileE) && tempP.renameTo(fileP)) {
                //System.out.println("success");
            }
        }
        return true;
    }
    public String searchWord(String wordToSearch, AtomicBoolean suggested) throws IOException {
        if(wordToSearch.equals("")) return "Please enter word";
        String firstRow = "English       " + "| VietNamese" + "      | Pronounce" + "\n";
        int wtsLength = wordToSearch.length();
        String suggestList = "";

        File fileT = new File("src\\Tdata.txt"); BufferedReader readT = new BufferedReader(new FileReader(fileT));
        File fileE = new File("src\\Edata.txt"); BufferedReader readE = new BufferedReader(new FileReader(fileE));
        File fileP = new File("src\\Pdata.txt"); BufferedReader readP = new BufferedReader(new FileReader(fileP));

        String lineT= readT.readLine();
        String lineE= readE.readLine();
        String lineP= readP.readLine();
        while(lineT != null){
            if(lineT.equals(wordToSearch)){
                return firstRow +  lineT + "                  " + lineE + "                     " + lineP;
            }else if(lineT.substring(0,wtsLength).equals(wordToSearch)){
                suggestList += lineT + "\n";
            }
            lineT = readT.readLine();
            lineE = readE.readLine();
            lineP = readP.readLine();
        }
        if(!suggestList.equals("")){
            suggested.set(true);
            return "Your word doesn't exist here are some suggestion\n" + suggestList;
        }
        return "Your word doesn't exist";
    }
}
