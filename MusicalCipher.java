import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MusicalCipher {
	
	public static String getCodedString(String str, int restTime, int spaceRestInc, int ampDef, int spaceAmpInc) {
		String codedStr = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') { restTime += spaceRestInc; ampDef += spaceAmpInc; }
			codedStr += 
				"play " + (int)str.charAt(i) + 
				", amp: " + ampDef +
				" ## '" + 
				cleanChar(str.charAt(i)) + 
				"'\nsleep " + restTime + " \n";

		if (str.charAt(i) == ' ') { restTime -= spaceRestInc; ampDef -= spaceAmpInc; }
			

		}

		return codedStr;
	}
	
	public static String cleanChar(char ch) {
		if (ch == '\n') {
			return "\\n";
		} 
		return "" + ch;
	}

	public static void main(String[] args) throws IOException {
		String input = "Hi Ellery & James! \n\nHow are you? How's Bend? What are you doing? Annoying Aunt Elisabeth, I hope. Take Care! \n\nBest, \nLiam";

		String codedString = getCodedString(input, 1, 1, 1, 1);

		System.out.println(codedString);
		File outputFile = new File("./output.txt");
		FileWriter outputWriter = new FileWriter(outputFile);
		outputWriter.write(codedString);
		outputWriter.close();
	}
}
