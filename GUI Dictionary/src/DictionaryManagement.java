import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    Scanner sc = new Scanner(System.in);
    protected int i_wordNum;
    private boolean quit = false;

    /**
     * Cons_Des.
     */
    public DictionaryManagement() {
    }
    /**
     * Inherited method
     */
    public String toString() {
        return "No  " + "| English        " + "| VietNamese" + "  | Pronounce";
    }

    /**
     * original dmMethod.
     */
    public void insertFromCommandline() {
        System.out.print("Insert number of words for new Arr: ");
        i_wordNum = 0;
        try{
            i_wordNum = Integer.parseInt(sc.nextLine());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public boolean isQuit() {
        return quit;
    }

    public boolean quit() {
        quit = true;
        return quit;
    }

    public void DictionaryBasic() {
        insertFromCommandline();
    }

    public void updateArray() {
        target = new String[Arr_Dictionary.length];
        explain = new String[Arr_Dictionary.length];
        pronounce = new String[Arr_Dictionary.length];

        for (int i = 0; i < Arr_Dictionary.length; i++) {
            target[i] = "";
            target[i] = Arr_Dictionary[i].getWord_target();
            explain[i] = "";
            explain[i] = Arr_Dictionary[i].getWord_explain();
            pronounce[i] = "";
            pronounce[i] = Arr_Dictionary[i].getPronounce();

        }

            System.out.println("arr.length = " + Arr_Dictionary.length);
            System.out.println("target= " + target[Arr_Dictionary.length-1] + " explain= " + explain[Arr_Dictionary.length-1] + " pronounce=" + pronounce[Arr_Dictionary.length-1]);
    }

    public void updateWord() {
        for (int i = 0; i < Arr_Dictionary.length; i++) {
            Arr_Dictionary[i] = new Word();
            Arr_Dictionary[i].setWord_target(target[i]);
            Arr_Dictionary[i].setWord_explain(explain[i]);
            Arr_Dictionary[i].setPronounce(pronounce[i]);
        }
    }
}
