import java.util.Scanner;

public class Solution {
    static final Scanner sc = new Scanner(System.in);
    /*
    static String toString(){
        return "No  " + "| English      " + "| VietNamese" + "r";
    }
    */

    // @Override
    public static String toStrindg() {
        return "No  " + "| English      " + "| VietNamese" + "\n";
    }

    public static void main(String[] args) {

        DictionaryCommandline myCommand = new DictionaryCommandline();
        myCommand.insertFromCommandline();
        myCommand.showAllWord();
        myCommand.searchWord();


    }
}
