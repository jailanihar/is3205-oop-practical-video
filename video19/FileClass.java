package video19;

import java.io.File;
import java.util.Date;

public class FileClass {

	public static void main(String[] args) {
		// Windows:
		// "C:\\Users\\PC-Name\\OOP.txt"
		// "D:\\OOP.txt"
		File file = new File("/Users/jailanihar/OOP.txt");
		System.out.println("Does the file exists? " + file.exists());
		System.out.println("Is it a directory(folder)? " + file.isDirectory());
		System.out.println("Is it a file? " + file.isFile());
		System.out.println("Absolute Path: " + file.getAbsolutePath());
		System.out.println("File name: " + file.getName());
		System.out.println("Last modified: " + new Date(file.lastModified()));
		
		// Before running the next statements,
		// make sure you are not reading any important files.
		File file2 = new File("/Users/jailanihar/OOP-2021.txt");
		file.renameTo(file2);
		file2.delete();
	}
	
}
