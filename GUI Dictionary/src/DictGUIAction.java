import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class DictGUIAction extends DictionaryManagement {
    //@Override

    public boolean addWord(String strT, String strE, String strP, ArrayList<Word> data) {
        Word newWord = new Word(strT, strE, strP);
        for (int i = 0; i < data.toArray().length; i++) {
            if (data.get(i).getWord_target().equals(strT))
                return false;
        }
        data.add(newWord);
        return true;

    }

    public String showWord(ArrayList<Word> data)  {
        String temptStr = "No     " + "| English        " + "| VietNamese" + "      | Pronounce" + "\n";

        for( int i=0; i<data.toArray().length; i++){
            int index = i+1;
            temptStr = temptStr + "NO#" + index + "  " + data.get(i).getWord_target() + "                   " + data.get(i).getWord_explain() + "                     " + data.get(i).getPronounce() + "\n";
        }
        return temptStr;
    }

    public String deleteWord(ArrayList<Word> data, String wordToDelete)  {
        boolean haveWord=false;
        for(int i=0; i< data.toArray().length; i++){
            if(data.get(i).getWord_target().equals(wordToDelete)){
                data.remove(i);
                haveWord=true;
            }
            if(haveWord){
                return "Delete successfully";
            }

        }
        return "Your Word doesn't exist";


    }
    public String searchWord(String wordToSearch, ArrayList<Word> data, AtomicBoolean suggested)  {

        if(wordToSearch.equals("")) return "Please enter word";
        String firstRow = "English       " + "| VietNamese" + "      | Pronounce" + "\n";
        int wtsLength = wordToSearch.length();
        String suggestList = "";

        for(int i=0; i<data.toArray().length; i++){
            if(data.get(i).getWord_target().equals(wordToSearch)){
                return firstRow +  data.get(i).getWord_target() + "                  " + data.get(i).getWord_explain() + "                     " + data.get(i).getPronounce();
            }
            if(data.get(i).getWord_target().length()<wtsLength) continue;
            if(data.get(i).getWord_target().substring(0,wtsLength).equals(wordToSearch))
                suggestList = suggestList + data.get(i).getWord_target() + "\n";
        }

        if(!suggestList.equals("")){
            suggested.set(true);
            return "Your word doesn't exist here are some suggestion\n" + suggestList;
        }
        return "Your word doesn't exist";
    }
    public void readFile(ArrayList<Word> data) throws IOException {
        File fileT = new File("src\\Tdata.txt");
        File fileE = new File("src\\Edata.txt");
        File fileP = new File("src\\Pdata.txt");

        BufferedReader readT = new BufferedReader(new FileReader(fileT));
        BufferedReader readE = new BufferedReader(new FileReader(fileE));
        BufferedReader readP = new BufferedReader(new FileReader(fileP));

        String lineT = readT.readLine();
        String lineE = readE.readLine();
        String lineP = readP.readLine();
        while(lineT != null){
            addWord(lineT,lineE,lineP,data);
            lineT = readT.readLine();
            lineE = readE.readLine();
            lineP = readP.readLine();
        }
        readE.close();
        readP.close();
        readT.close();
    }
    public void writeToFile(ArrayList<Word> data) throws IOException {
        File fileT = new File("src\\Tdata.txt");
        File fileE = new File("src\\Edata.txt");
        File fileP = new File("src\\Pdata.txt");

        BufferedWriter writeT = new BufferedWriter(new FileWriter(fileT));
        BufferedWriter writeE = new BufferedWriter(new FileWriter(fileE));
        BufferedWriter writeP = new BufferedWriter(new FileWriter(fileP));

        for(int i=0; i<data.toArray().length; i++){
            writeT.write(data.get(i).getWord_target()+"\n");
            writeE.write(data.get(i).getWord_explain()+"\n");
            writeP.write(data.get(i).getPronounce()+"\n");
        }

        writeT.close();
        writeE.close();
        writeP.close();

    }
}
