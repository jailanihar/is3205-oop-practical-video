package video19;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriterClass {

	public static void main(String[] args) {
		File file = new File("data.xml");
		PrintWriter writeFile = null;
		try {
			// true, append/modify the file
			// false, override the file
			writeFile = new PrintWriter(new FileWriter(file, false));
			
			writeFile.println("<aList>");
			writeFile.println("<a>");
			writeFile.println("<b>123</b>");
			writeFile.println("<c>Jai</c>");
			writeFile.println("</a>");
			writeFile.println("<a>");
			writeFile.println("<b>111</b>");
			writeFile.println("<c>Haji</c>");
			writeFile.println("</a>");
			writeFile.println("</aList>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writeFile != null) {
				writeFile.close();
			}
		}
	}
	
}
