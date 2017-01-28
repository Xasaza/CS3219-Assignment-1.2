import java.util.ArrayList;
import java.util.Collections;

public class Processor {
	
	private ArrayList<String> ignoreWords;
	
	// Make constructor
	public Processor(ArrayList<String> ignoreWords) {
		this.ignoreWords = ignoreWords;
	}
	
	// Process the input shiftedTitles and returns the processed ArrayList
	public ArrayList<String> processTitles(	ArrayList<ArrayList<String>> shiftedTitles) {
		
		// Filter out titles that starts with ignoreWords
		ArrayList<ArrayList<String>> filteredTitles = filter(shiftedTitles, ignoreWords);
		// Convert to String List instead of a list of tokenized array
		ArrayList<String> result = toString(filteredTitles);
		// Sort Alphabetically
		sort(result);
		return result;
	}
	
	
	// Filter out titles that start with words found in ignoreWords
	private ArrayList<ArrayList<String>> filter(ArrayList<ArrayList<String>> shiftedTitles,
												ArrayList<String> ignoreWords ) {
		//System.out.println(ignoreWords);
		for(int counter = 0; counter < shiftedTitles.size(); counter++) {
			if(ignoreWords.stream().anyMatch(shiftedTitles.get(counter).get(0)::equalsIgnoreCase)){
				shiftedTitles.remove(counter);
			}
		}
		return shiftedTitles;
	}
	
	private ArrayList<String> toString(ArrayList<ArrayList<String>> filteredTitles){
		ArrayList<String> result = new ArrayList<String>();
		for(int counter = 0; counter < filteredTitles.size(); counter++){
			result.add(String.join(" ", filteredTitles.get(counter)));
		}
		return result;
	}
	
	private void sort(ArrayList<String> result){
		Collections.sort(result);
	}
}
