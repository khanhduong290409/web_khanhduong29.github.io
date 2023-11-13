package lab8;



	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.*;

	public class TextAnalyzer {
	    private Map<String, ArrayList<Integer>> map = new HashMap<>();

	    public void load(String fileName) {
	        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            int lineNumber = 1;

	            while ((line = reader.readLine()) != null) {
	                String[] words = line.split("\\s+");

	                for (String word : words) {
	                    add(word, lineNumber);
	                }

	                lineNumber++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public void add(String word, int position) {
	        map.computeIfAbsent(word, k -> new ArrayList<>()).add(position);
	    }

	    public void displayWords() {
	        Set<String> words = map.keySet();
	        words.stream().sorted().forEach(word -> {
	            List<Integer> positions = map.get(word);
	            System.out.println(word + ": " + positions);
	        });
	    }

	    public void displayText() {
	        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }
	    }

	    public String mostFrequentWord() {
	        int maxOccurrences = 0;
	        String mostFrequentWord = null;

	        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
	            int occurrences = entry.getValue().size();
	            if (occurrences > maxOccurrences) {
	                maxOccurrences = occurrences;
	                mostFrequentWord = entry.getKey();
	            }
	        }

	        return mostFrequentWord;
	    }
	}
