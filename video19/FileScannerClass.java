package video19;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScannerClass {

	public static void main(String[] args) {
		File file = new File("data.xml");
		Scanner readFile = null;
		try {
			readFile = new Scanner(file);
			
			while(readFile.hasNextLine()) {
				System.out.println(readFile.nextLine());
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
