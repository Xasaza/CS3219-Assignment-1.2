import java.util.ArrayList;

public class Logic {
	
	
	/**
	 * Takes in ArrayList of tokenized titles and ArrayList of words to ignore, 
	 * performs circular shift, process the titles and set it as value of outputTitles.
	 * 
	 * @param tokenizedTitles	
	 * @param ignoreWords
	 */
	public static ArrayList<String> executeKWIC(	ArrayList<ArrayList<String>> tokenizedTitles,
									ArrayList<String> ignoreWords) {
		ArrayList<String> outputTitles = new ArrayList<String>();
		// Get list of shifted titles
		ArrayList<ArrayList<String>> shiftedTitles = CircularShift.circularShift(tokenizedTitles);
		
		// Process titles
		
		Processor processor = new Processor(ignoreWords);
		ArrayList<String> processedTitles = processor.processTitles(shiftedTitles);
		
		// Set output
		outputTitles.addAll(processedTitles);
		
		return outputTitles;
	}
}
