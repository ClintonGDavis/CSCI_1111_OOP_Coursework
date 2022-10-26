public class WordOccurrence implements Comparable<WordOccurrence> {
    String word = null;
    Integer count = 0;

    public WordOccurrence(String word, int count){
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(WordOccurrence E) {
        return E.count.compareTo(count);
    }

    @Override
    public String toString() {
        return word + " = " + count;
    }
}