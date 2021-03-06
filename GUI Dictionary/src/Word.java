public class Word {
    public String word_target;
    public String word_explain;
    public String pronounce;

    /**
     * cons_des.
     */
    public Word() {
    }

    public Word(String target, String explain, String pronounce) {
        word_target = target;
        word_explain = explain;
        this.pronounce = pronounce;
    }

    /**
     * method.
     */
    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }
}
