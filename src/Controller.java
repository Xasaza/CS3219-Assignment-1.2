import java.util.ArrayList;

public class Controller {
	private ArrayList<ArrayList<String>> tokenizedTitles;
	public static ArrayList<String> ignoreWords;
	public static ArrayList<String> outputTitles;
	
	public void initKWIC() {
		
		// Initialise data structures
		tokenizedTitles = new ArrayList<ArrayList<String>>();
		ignoreWords = new ArrayList<String>();
		outputTitles = new ArrayList<String>();
		
		// Execute program flow
		InputHandler.readAndStoreInput(tokenizedTitles, ignoreWords);
		Logic.executeKWIC(tokenizedTitles, ignoreWords, outputTitles);
		OutputHandler.printOutput(outputTitles);
	}
	
}
