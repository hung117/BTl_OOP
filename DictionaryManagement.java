import java.util.Scanner;

public class DictionaryManagement extends Dictionary{
    Scanner sc = new Scanner(System.in);
    protected int  i_wordNum;
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
    public void DictionaryBasic(){
        insertFromCommandline();

    }
    public void insertFromFile(){

    }

}
