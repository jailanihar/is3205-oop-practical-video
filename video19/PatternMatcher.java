package video19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {
		File file = new File("data.xml");
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			StringBuilder fileContent = new StringBuilder();
			while(readFile.hasNextLine()) {
				fileContent.append(readFile.nextLine());
			}
			System.out.println(fileContent);
			
			Pattern xmlFormat =
					Pattern.compile("^<aList>.*</aList>$");
			Matcher xmlMatcher = xmlFormat.matcher(fileContent);
			
			if(xmlMatcher.matches()) {
				System.out.println("File structure is compatible.");
				
				Pattern abcData =
						Pattern.compile(
								"<a>" +
								"<b>(.+?)</b>" +
								"<c>(.+?)</c>" +
								"</a>"
								);
				Matcher abcMatcher = abcData.matcher(fileContent);
				
				while(abcMatcher.find()) {
					System.out.println(abcMatcher.group(1));
					System.out.println(abcMatcher.group(2));
//					System.out.println(abcMatcher.start());
//					System.out.println(abcMatcher.end());
				}
				
			} else {
				System.out.println("File structure is not compatible.");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(readFile != null) {
				readFile.close();
			}
		}
	}
	
}
