package lab7;

import java.util.Objects;

public class WordCount {
    private String word;
    private int count;

    public WordCount(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word + " - " + count;
    }

    // Ghi đè equals và hashCode để sử dụng trong so sánh và cho các collection
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WordCount wordCount = (WordCount) obj;
        return count == wordCount.count && Objects.equals(word, wordCount.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }
}
