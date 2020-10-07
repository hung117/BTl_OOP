public class DictionaryCommandline extends DictionaryManagement{
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
    }

    /**
     * original method.
     */
    public void showAllWord() {
        int arr_size = Arr_Dictionary.length;

        System.out.println(super.toString());
        for (int i = 0; i < arr_size; i++) {
            System.out.println(i + "    " + "| " + Arr_Dictionary[i].getWord_target() + "     | " + Arr_Dictionary[i].getWord_explain() + "\r");
        }
    }
    public void searchWord(){
        int arr_size = super.i_wordNum;

        System.out.println("Search Word: ");
        String search = sc.nextLine();
        for(int i = 0; i < arr_size; i++){
            if(Arr_Dictionary[i].getWord_target().equals(search)){
                System.out.println(Arr_Dictionary[i].getWord_explain());
            }
        }
        System.out.println("Your Word Doesnt Exist!");
    }
    public void addWord(){

        System.out.print("insert your new target word: ");
        newTargetWord = sc.next();
        newExplainWord = sc.nextLine();
        // copy old arr + expand
        Word[] newArr_Dictionary = new Word[Arr_Dictionary.length + 1];
        System.arraycopy(Arr_Dictionary,0,newArr_Dictionary,0,Arr_Dictionary.length);
        newArr_Dictionary[newArr_Dictionary.length-1] = new Word();
        newArr_Dictionary[newArr_Dictionary.length-1].setWord_target(newTargetWord);
        newArr_Dictionary[newArr_Dictionary.length-1].setWord_explain(newExplainWord);
        // replace
        Arr_Dictionary = new Word[newArr_Dictionary.length];
        System.arraycopy(newArr_Dictionary,0,Arr_Dictionary,0,newArr_Dictionary.length);
    }
}
