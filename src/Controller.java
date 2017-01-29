import java.util.ArrayList;

public class Controller {
	public static ArrayList<String> outputTitles;
	
	public void initKWIC() {
		outputTitles = new ArrayList<String>();
		
		// Execute program flow
		ArrayList<ArrayList<String>> tokenizedTitles = InputHandler.readAndStoreTitles();
		ArrayList<String> ignoreWords = InputHandler.readAndStoreIgnoreWords();
		ArrayList<String> outputTitles = Logic.executeKWIC(tokenizedTitles, ignoreWords);
		OutputHandler.printOutput(outputTitles);
	}
	
}
