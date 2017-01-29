import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class InputHandler {
	
	private final static String MSG_INPUT_TITLE_NUMBER = "Please key in the number of movie titles, followed by Return key.";
	private final static String MSG_INPUT_TITLE = "Please key in the movie titles, ending each with Return key.";
	private final static String MSG_INPUT_IGNORE_WORDS = "Please key in the words to ignore, separate each word with a single spacing, followed by Return key.";
	
	/**
	 *  Sets the input tokenizedTitles list with multiple entries of string arrays
	 *  each representing an input movie title 
	 * @param tokenizedTitles 	Reference to an ArrayList of string arrays that will be used to store
	 * 							the tokenised input titles
	 * @param ignoreWords		Reference to an ArrayList of input words to ignore
	 */
	public static ArrayList<ArrayList<String>> readAndStoreTitles() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<ArrayList<String>> tokenizedTitles = readTitlesInput(scanner);
		return tokenizedTitles;
	}
	
	public static ArrayList<String> readAndStoreIgnoreWords() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> ignoreWords = readIgnoreWordsInput(scanner);
		return ignoreWords;
	}
	
	private static ArrayList<ArrayList<String>> readTitlesInput(Scanner scanner) {
		ArrayList<ArrayList<String>> tokenizedTitles = new ArrayList<ArrayList<String>>();
		// Prompt for number of titles
		System.out.println(MSG_INPUT_TITLE_NUMBER);
		
		int counter = 0;
		int numLines = scanner.nextInt();
		
		// Prompt for titles
		System.out.println(MSG_INPUT_TITLE);
		
		// Skip newline so that scanning starts properly 
		scanner.nextLine();
		
		// Read, parse and store
		while (counter < numLines) {
			tokenizedTitles.add(readLineAndParse(scanner));
			counter++;
		}
		
		return tokenizedTitles;
	}
	
	private static ArrayList<String> readIgnoreWordsInput(Scanner scanner) {
		ArrayList<String> ignoreWords = new ArrayList<String>();
		// Prompt for words to ignore
		System.out.println(MSG_INPUT_IGNORE_WORDS);
		
		// Read, parse and update
		ArrayList<String> processedIgnoreWords = (readLineAndParse(scanner));
		ignoreWords.addAll(processedIgnoreWords);
		return ignoreWords;
	}
	
	// Reads in a line through the input scanner, parse the words with regex "\\s+",
	// and returns an ArrayList of the individual word strings.
	private static ArrayList<String> readLineAndParse(Scanner scanner) {
		String line = scanner.nextLine();
		String[] parsedLine = line.split("\\s+"); 
		return new ArrayList<String>(Arrays.asList(parsedLine));
	}
	
}
