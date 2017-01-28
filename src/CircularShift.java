import java.util.ArrayList;
import java.util.Collections;

public class CircularShift {
	
	public static ArrayList<ArrayList<String>> circularShift(ArrayList<ArrayList<String>> tokenizedTitles) {

		ArrayList<ArrayList<String>> shifted = new ArrayList<ArrayList<String>>();
		for(int counter = 0; counter < tokenizedTitles.size(); counter++){
			for(int cycle = 0; cycle < tokenizedTitles.get(counter).size(); cycle++){
				ArrayList<String> result = new ArrayList<String>();
				result.addAll(shift(tokenizedTitles.get(counter), 1));
				shifted.add(result);
			}
		}
		return shifted;
	}
	
	public static ArrayList<String> shift(ArrayList<String> input, int num){
		Collections.rotate(input, num);
		return input;
	}
}
