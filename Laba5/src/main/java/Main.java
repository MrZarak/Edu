import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static final String START_TEXT = "";
    public static final String END_TEXT = "";

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Ознайомлення з рядками та використання основних методів їх обробки в мові програмування Java.");
        buffer.append(" Здобуття навичок у використанні рядків в мові програмування Java");
        //split по регулярочці для розбиття на речення по символам '!', '.', '?'
        for (String s : buffer.toString().split("[.?!]\\s*")) {
            Sentence sentence = Sentence.toSentence(s);
            System.out.println(sentence.toString().replace(findLongWord(sentence).toString(),""));
        }
    }



    public static Word findLongWord(Sentence in) {
        Word[] words = in.words;//розбиваємо на маленькі-маленькі слова
        Word max = null;// тут тримаємо ссилку на найдовше слово
        for (Word word : words) {
            String wordString = word.toString();
            if (wordString.startsWith(START_TEXT) && wordString.endsWith(END_TEXT)) {
                if (max == null || max.toString().length() < wordString.length()) {
                    max = word;
                }
            }
        }
        return max;
    }
}
