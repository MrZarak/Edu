public class Sentence {

    final Word[] words;

    public Sentence(Word[] words) {
        this.words = words;
    }

    @Override
    public String toString() {
        if (words.length == 0)
            return "";
        StringBuffer buffer = new StringBuffer();
        for (Word word : words) {
            buffer.append(word).append(" ");
        }
        return buffer.substring(0, buffer.length() - 1);
    }
    // Генерує об'єкт классу на основі спільного інтерфейсу CharSequence для String, StringBuffer, StringBuilder
    public static Sentence toSentence(CharSequence builder) {
        String[] s = builder.toString().split(" ");
        Word[] words = new Word[s.length];
        for (int i = 0; i < words.length; i++) {
            String word = s[i];
            Letter[] letters = new Letter[word.length()];
            for (int j = 0; j < letters.length; j++) {
                letters[j] = new Letter(word.charAt(j));
            }
            words[i] = new Word(letters);
        }
        return new Sentence(words);
    }
}
