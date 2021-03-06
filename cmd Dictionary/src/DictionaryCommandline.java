import java.io.IOException;

public class DictionaryCommandline extends DictionaryManagement {
    //int arr_size = super.i_wordNum;
    //int arr_size = super.i_wordNum;
    //Arr_Dictionary = new Word[arr_size];

    /**
     * override method.
     */
    @Override
    public void insertFromCommandline() {
        super.insertFromCommandline();
        int arr_size = i_wordNum;
        Arr_Dictionary = new Word[arr_size];

        for (int i = 0; i < arr_size; i++) {
            Arr_Dictionary[i] = new Word();
            String set = sc.next();
            Arr_Dictionary[i].setWord_target(set);
            set = sc.nextLine();
            Arr_Dictionary[i].setWord_explain(set);

        }
        updateArray();
    }

    /**
     * original method.
     */

    public void showAllWord() {
        int arr_size = Arr_Dictionary.length;

        System.out.println(super.toString());
        for (int i = 0; i < arr_size; i++) {
            System.out.printf("%d %3s %-8s %s %-10s %n", i, "|", Arr_Dictionary[i].getWord_target(), "      | ", Arr_Dictionary[i].getWord_explain());
        }
    }

    public void searchWord() {
        int arr_size = super.Arr_Dictionary.length;
        String target = " ";
        String explain = " ";
        int index = 0;
        System.out.print("Search Word: ");
        String search = sc.nextLine();
        int searchSize = search.length();
        //System.out.println("searchSize= " + searchSize);
        for (int i = 0; i < arr_size; i++) {
            if (Arr_Dictionary[i].getWord_target().equals(search)) {
                target = Arr_Dictionary[i].getWord_target();
                explain = Arr_Dictionary[i].getWord_explain();
                break;
            }
        }
            if(target != " "){
                System.out.printf("%s %3s %-8s %s %s %-10s %n", index, "|", target, "explain", "      | ", explain);
            }
            else { suggestWord(search);
            /*else if (Arr_Dictionary[i].getWord_target().substring(0, searchSize).equals(search)) {
                target = Arr_Dictionary[i].getWord_target();
                explain = Arr_Dictionary[i].getWord_explain();
                // out current iteration;
                System.out.printf("%s %3s %-8s %s %s %-10s %s %n", "you meant :target", "|", target, "explain", "      | ", explain, "?");
                exist = true;
                continue;
                */

            }
        }
    public void suggestWord(String incompleteWord){
        int icWordSize = incompleteWord.length();
        int dataSize = Arr_Dictionary.length;
        int[] sgList = new int[dataSize]; // suggestions list by index
        int sgCount = 0 ;
        for(int i=0 ; i<dataSize ; i++){
            if(Arr_Dictionary[i].getWord_target().substring(0,icWordSize).equals(incompleteWord)){
                sgList[sgCount] = i;
                sgCount++;
            }
        }
        if(sgCount!=0) {
            System.out.println("Your word doesn't exist, here are some suggestions:" );
            for (int i = 0; i < sgCount; i++) {
                System.out.println(Arr_Dictionary[sgList[i]].getWord_target() + "\n");
            }
        }
        else System.out.println("Your word doesn't exist" + "\n");
    }
    public void addWord(){

        System.out.print("insert your new target word: ");
        newTargetWord = sc.next();
        newExplainWord = sc.nextLine();
        // copy old arr + expand
        Word[] newArr_Dictionary = new Word[Arr_Dictionary.length + 1];
        System.arraycopy(Arr_Dictionary, 0, newArr_Dictionary, 0, Arr_Dictionary.length);
        newArr_Dictionary[newArr_Dictionary.length - 1] = new Word();
        newArr_Dictionary[newArr_Dictionary.length - 1].setWord_target(newTargetWord);
        newArr_Dictionary[newArr_Dictionary.length - 1].setWord_explain(newExplainWord);
        // replace
        Arr_Dictionary = new Word[newArr_Dictionary.length];
        System.arraycopy(newArr_Dictionary, 0, Arr_Dictionary, 0, newArr_Dictionary.length);
        if (Arr_Dictionary != null && Arr_Dictionary.length == newArr_Dictionary.length) {
            System.out.println("add new word successfully");
        } else {
            System.out.println("St gone wrong");
        }
        updateArray();
    }


    public void deleteWord(){
        int arr_size = super.Arr_Dictionary.length;
        int idx = 0;
        Word[] newArr = new Word[arr_size - 1];
        System.out.print("which word you want to delete? " + "\n" + "   " + "$I want to delete: ");
        newTargetWord = sc.nextLine();

        for (int i = 0; i < arr_size; i++) {
            if (newTargetWord.equals(Arr_Dictionary[i].getWord_target())) {
                break;
            }
            idx++;
        }
        // case: head, middle, last
        if (idx == 0) {
            //System.out.println("HEAD!   idx: " + idx);

            System.arraycopy(Arr_Dictionary, 1, newArr, 0, arr_size - 1);
            Arr_Dictionary = newArr;
        } else if (idx == arr_size - 1) {
            //System.out.println("LAST!   idx: " + idx);

            System.arraycopy(Arr_Dictionary, 0, newArr, 0, arr_size - 1);
            Arr_Dictionary = newArr;

        } else if (idx >= arr_size) {
            System.out.println("Invalid Input, There's nothing to delete");
        } else {
            //System.out.println("MID!    idx: " + idx);
            for (int i = idx; i < arr_size - 1; i++) {
                Arr_Dictionary[i] = Arr_Dictionary[i + 1];
            }
            System.arraycopy(Arr_Dictionary, 0, newArr, 0, arr_size - 1);
            Arr_Dictionary = newArr;
        }
        if (Arr_Dictionary != null && Arr_Dictionary.length == newArr.length) {
            System.out.println("delete new word successfully");
        } else {
            System.out.println("St gone wrong");
        }
        updateArray();
    }


}
