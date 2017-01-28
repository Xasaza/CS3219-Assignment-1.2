import java.util.ArrayList;

public class OutputHandler {
	
	private static final String MSG_OUTPUT = "Output:";
	
	// Prints out line by line each element in the outputTitles
	public static void printOutput(ArrayList<String> outputTitles) {
		
		System.out.println(MSG_OUTPUT);
		
		for (int i = 0; i < outputTitles.size(); i++) {
			System.out.println(outputTitles.get(i));
		}
	}
}
