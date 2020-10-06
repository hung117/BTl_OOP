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
        int arr_size = super.i_wordNum;
        Arr_Dictionary = new Word[arr_size];
        for (int i = 0; i < arr_size; i++) {
            Arr_Dictionary[i] = new Word();
            String set = sc.next();
            Arr_Dictionary[i].setWord_target(set);
            set = sc.nextLine();
            Arr_Dictionary[i].setWord_explain(set);
            /*
            Arr_Dictionary[i].word_target = sc.next();
            Arr_Dictionary[i].word_explain = sc.nextLine();
             */
        }
    }

    /**
     * original method.
     */
    public void showAllWord() {
        System.out.println(super.toString());
        int arr_size = super.i_wordNum;
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
        //System.out.println("Your Word Doesnt Exist!");
    }
}
