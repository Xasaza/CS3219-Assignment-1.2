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
	public static void readAndStoreInput(	ArrayList<ArrayList<String>> tokenizedTitles, 
											ArrayList<String> ignoreWords) {
		
		Scanner scanner = new Scanner(System.in);
		readTitlesInput(tokenizedTitles, scanner);
		readIgnoreWordsInput(ignoreWords, scanner);
	}
	
	private static void readTitlesInput(ArrayList<ArrayList<String>> tokenizedTitles,
										Scanner scanner) {
		
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
	}
	
	private static void readIgnoreWordsInput(ArrayList<String> ignoreWords, Scanner scanner) {
		
		// Prompt for words to ignore
		System.out.println(MSG_INPUT_IGNORE_WORDS);
		
		// Read, parse and update
		ArrayList<String> processedIgnoreWords = (readLineAndParse(scanner));
		ignoreWords.addAll(processedIgnoreWords);
	}
	
	// Reads in a line through the input scanner, parse the words with regex "\\s+",
	// and returns an ArrayList of the individual word strings.
	private static ArrayList<String> readLineAndParse(Scanner scanner) {
		String line = scanner.nextLine();
		String[] parsedLine = line.split("\\s+"); 
		return new ArrayList<String>(Arrays.asList(parsedLine));
	}
	
	
	
	
}
