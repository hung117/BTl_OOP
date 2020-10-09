import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    Scanner sc = new Scanner(System.in);
    protected int  i_wordNum;
    private boolean quit = false;
    /**
     * Cons_Des.
     */
    public DictionaryManagement(){}
    /**
     * Inherited method
     */
    public String toString(){
        return "No  " + "| English        " + "| VietNamese" ;
    }
    /**
     * original dmMethod.
     */
    public void insertFromCommandline() {
        System.out.print("insert number of words: ");
         i_wordNum = sc.nextInt();
         //return i_wordNum;
    }

    public boolean isQuit() {
        return quit;
    }

    public boolean quit(){
        quit = true;
        return quit;
    }
    public void DictionaryBasic(){
        insertFromCommandline();

    }
    DictDataFile tempFile = new DictDataFile();

    public DictDataFile getTempFile() {
        return tempFile;
    }


    public void insertFromFile(){

    }



}
