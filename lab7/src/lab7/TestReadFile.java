package lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("data/fit.txt"));

            while (input.hasNext()) {
                String word = input.next();
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
