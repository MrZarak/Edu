public class Word {
    final Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    @Override
    public String toString() {
        StringBuffer buffer =new StringBuffer();
        for (Letter letter : letters) {
            buffer.append(letter);
        }
        return buffer.toString();
    }
}
