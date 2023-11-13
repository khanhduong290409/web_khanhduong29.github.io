package lab8;
	
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.StringTokenizer;

	public class TextFileUtils {
	    public static void readText(String fileName) throws IOException {
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            StringTokenizer tokens = new StringTokenizer(line, " ");

	            while (tokens.hasMoreTokens()) {
	                System.out.println(tokens.nextToken());
	            }
	        }
	        reader.close();
	    }

	    public static void main(String[] args) {
	        try {
	            readText("data/fit.txt");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



