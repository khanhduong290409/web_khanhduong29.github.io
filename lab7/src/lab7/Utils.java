package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> loadWords(String fileName) throws FileNotFoundException {
        List<String> wordList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(fileName));

        while (scanner.hasNext()) {
            String word = scanner.next();
            wordList.add(word);
        }
        return wordList;
    }
}
