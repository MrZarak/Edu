
public class Main {
    public static final String START_TEXT = "";
    public static final String END_TEXT = "";

    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("Ознайомлення з рядками та використання основних методів їх обробки в мові програмування Java.");
        buffer.append(" Здобуття навичок у використанні рядків в мові програмування Java");
        //split по регулярочці для розбиття на речення по символам '!', '.', '?'
        for (String s : buffer.toString().split("[.?!]\\s*")) {
            System.out.println(s.replace(findLongWord(s),""));
        }
    }

    public static String findLongWord(String in) {
        String[] words = in.split(" ");//розбиваємо на маленькі-маленькі слова
        String max = "";// тут тримаємо ссилку на найдовшу строку
        for (String word : words) {
            if(word.startsWith(START_TEXT) && word.endsWith(END_TEXT)){
                if(max.length() < word.length()) {
                    max = word;
                }
            }
        }
        return max;
    }
}
