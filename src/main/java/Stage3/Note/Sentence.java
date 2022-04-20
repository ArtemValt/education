package Stage3.Note;

import java.util.Date;

public class Sentence {
    private String sentence;
    private String date;
    private int importance;

    public Sentence(String sentence, String date, int importance) {
        this.sentence = sentence;
        this.date = date;
        this.importance = importance;
    }

    public String getSentence() {
        return sentence;
    }

    public String getDate() {
        return date;
    }

    public int getImportance() {
        return importance;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                ", date='" + date + '\'' +
                ", importance=" + importance +
                '}';
    }
}
