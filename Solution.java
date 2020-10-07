import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    //static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        DictionaryCommandline myCommand = new DictionaryCommandline();
        //myCommand.deleteWord();
        myCommand.insertFromCommandline();
        myCommand.showAllWord();
        myCommand.searchWord();
        myCommand.addWord();
        myCommand.showAllWord();

    }
}
