public class Word {
    final Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        StringBuilder builder =new StringBuilder();
        for (Letter letter : letters) {
            builder.append(letter);
        }
        return builder.toString();
    }
}
