package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyWordCountApp {
    public static final String fileName = "data/fit.txt";
    private Map<String, Integer> map = new HashMap<>();

    public void loadData() {
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNext()) {
                String word = input.next().toLowerCase(); // Convert to lowercase to make it case-insensitive
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int countUnique() {
        return map.size();
    }

    public void printWordCounts() {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void printWordCountsAlphabet() {
        Set<String> keys = map.keySet();
        keys.stream().sorted().forEach(key -> System.out.println(key + " - " + map.get(key)));
    }
}
