package lab7;

import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCount {
    public static final String fileName = "data/fit.txt"; // Đường dẫn đến file cần đọc
    private List<String> words = new ArrayList<>();

    public MyWordCount() {
        try {
            this.words.addAll(Utils.loadWords(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Có thể cần xử lý ngoại lệ một cách cụ thể hơn
        }
    }

    public List<WordCount> getWordCounts() {
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<WordCount> wordCounts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            wordCounts.add(new WordCount(entry.getKey(), entry.getValue()));
        }

        return wordCounts;
    }

    public Set<String> getUniqueWords() {
        Set<String> uniqueWords = new HashSet<>(words);
        Set<String> uniqueWordsWithOneCount = new HashSet<>();

        for (String word : words) {
            if (Collections.frequency(words, word) == 1) {
                uniqueWordsWithOneCount.add(word);
            }
        }

        return uniqueWordsWithOneCount;
    }

    public Set<String> getDistinctWords() {
        return new HashSet<>(words);
    }

    public Set<WordCount> exportWordCounts() {
        List<WordCount> wordCounts = getWordCounts();
        TreeSet<WordCount> sortedWordCounts = new TreeSet<>(wordCounts);
        return sortedWordCounts;
    }

    public Set<WordCount> exportWordCountsOrderByOccurrence() {
        List<WordCount> wordCounts = getWordCounts();
        wordCounts.sort(Comparator.comparingInt(WordCount::getCount).reversed());
        return new LinkedHashSet<>(wordCounts);
    }

    public Set<WordCount> filterWords(String pattern) {
        Set<WordCount> filteredWordCounts = new HashSet<>();
        for (String word : words) {
            if (!word.startsWith(pattern)) {
                int count = Collections.frequency(words, word);
                filteredWordCounts.add(new WordCount(word, count));
            }
        }
        return filteredWordCounts;
    }
}
