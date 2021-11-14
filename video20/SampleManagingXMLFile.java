package video20;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SampleManagingXMLFile {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Input xml file + location:");
		String input = userInput.nextLine();
		File file = new File(input);
		StringBuilder fileContent = new StringBuilder();
		
		boolean isFileAvailable = false;
		
		Pattern filePattern =
				Pattern.compile("^<aList>.*</aList>$");
		while(!isFileAvailable) {
			if(file.exists() && file.isFile()) {
				Scanner readFile = null;
				try {
					readFile = new Scanner(file);
					fileContent = new StringBuilder();
					while(readFile.hasNextLine()) {
						fileContent.append(readFile.nextLine());
					}
					
					Matcher fileMatcher = filePattern.matcher(fileContent);
					
					if(fileMatcher.matches()) {
						isFileAvailable = true;
						System.out.println("Formatting is valid");
						System.out.println(fileContent);
					} else {
						System.out.println("Formatting is invalid");
						System.out.println("Re-input xml file + location:");
						input = userInput.nextLine();
						file = new File(input);
					}
					
				} catch (FileNotFoundException e) {
					System.out.println("File is not available.");
					System.out.println("Re-input xml file + location:");
					input = userInput.nextLine();
					file = new File(input);
				} finally {
					if(readFile != null) {
						readFile.close();
					}
				}
				
			} else {
				System.out.println("File is not available.");
				System.out.println(file.getAbsolutePath());
				if(!file.isDirectory()) {
					System.out.println("Do you want to create a new file?");
					System.out.println("Yes/No");
					input = userInput.nextLine();
					if(input.trim().equalsIgnoreCase("yes")) {
						PrintWriter writeFile = null;
						try {
							writeFile = new PrintWriter(file);
							writeFile.println("<aList></aList>");
							isFileAvailable = true;
							fileContent = new StringBuilder("<aList></aList>");
						} catch (FileNotFoundException e) {
							System.out.println("Directory location invalid.");
							System.out.println("Re-input xml file + location:");
							input = userInput.nextLine();
							file = new File(input);
						} finally {
							if(writeFile != null) {
								writeFile.close();
							}
						}
					} else {
						System.out.println("Re-input xml file + location:");
						input = userInput.nextLine();
						file = new File(input);
					}
				} else {
					System.out.println("It is not a file.");
					System.out.println("Re-input xml file + location:");
					input = userInput.nextLine();
					file = new File(input);
				}
			}
		}
		
		Pattern dataPattern = Pattern.compile("<a><b>(.+?)</b><c>(.+?)</c></a>");
		while(true) {
			System.out.println("Type new data for b: (q to quit)");
			String bData = userInput.nextLine();
			if(bData.trim().equalsIgnoreCase("q")) {
				System.out.println("Application Terminated.");
				userInput.close();
				System.exit(0);
			}
			System.out.println("Type new data for c: (q to quit)");
			String cData = userInput.nextLine();
			if(cData.trim().equalsIgnoreCase("q")) {
				System.out.println("Application Terminated.");
				userInput.close();
				System.exit(0);
			}
			Matcher dataMatcher = dataPattern.matcher(fileContent);
			boolean isDataExists = false;
			int dataStart = 0;
			int dataEnd = 0;
			while(dataMatcher.find()) {
				if(dataMatcher.group(1).equalsIgnoreCase(bData)) {
					if(dataMatcher.group(2).equalsIgnoreCase(cData)) {
						dataStart = dataMatcher.start();
						dataEnd = dataMatcher.end();
						isDataExists = true;
						break;
					}
				}
			}
			
			if(isDataExists) {
				System.out.println("Data already exists.");
				System.out.println("Do you want to modify?");
				System.out.println("Yes/No");
				input = userInput.nextLine();
				if(input.trim().equalsIgnoreCase("yes")) {
					System.out.println("Type new data for b: (q to quit)");
					String editBData = userInput.nextLine();
					if(editBData.trim().equalsIgnoreCase("q")) {
						System.out.println("Application Terminated.");
						userInput.close();
						System.exit(0);
					}
					System.out.println("Type new data for c: (q to quit)");
					String editCData = userInput.nextLine();
					if(editCData.trim().equalsIgnoreCase("q")) {
						System.out.println("Application Terminated.");
						userInput.close();
						System.exit(0);
					}
					
					StringBuilder editData = new StringBuilder();
					editData.append("<a>");
					editData.append("<b>");
					editData.append(editBData);
					editData.append("</b>");
					editData.append("<c>");
					editData.append(editCData);
					editData.append("</c>");
					editData.append("</a>");
					
					fileContent.replace(dataStart, dataEnd, editData.toString());
					
					PrintWriter writeFile = null;
					try {
						writeFile =
								new PrintWriter(new FileWriter(file, false));
						writeFile.println(fileContent);
					} catch (IOException e) {
						System.out.println("Failed to write file.");
					} finally {
						if(writeFile != null) {
							writeFile.close();
						}
					}
					
				} else {
					System.out.println("Do you want to delete?");
					System.out.println("Yes/No");
					input = userInput.nextLine();
					if(input.trim().equalsIgnoreCase("yes")) {
						fileContent.replace(dataStart, dataEnd, "");
						
						PrintWriter writeFile = null;
						try {
							writeFile =
									new PrintWriter(new FileWriter(file, false));
							writeFile.println(fileContent);
						} catch (IOException e) {
							System.out.println("Failed to write file.");
						} finally {
							if(writeFile != null) {
								writeFile.close();
							}
						}
					}
				}
			} else {
				StringBuilder newData = new StringBuilder();
				newData.append("<a>");
				newData.append("<b>");
				newData.append(bData);
				newData.append("</b>");
				newData.append("<c>");
				newData.append(cData);
				newData.append("</c>");
				newData.append("</a>");
				fileContent.insert(fileContent.lastIndexOf("</aList>"), newData);
				
				PrintWriter writeFile = null;
				try {
					writeFile =
							new PrintWriter(new FileWriter(file, false));
					writeFile.println(fileContent);
				} catch (IOException e) {
					System.out.println("Failed to write file.");
				} finally {
					if(writeFile != null) {
						writeFile.close();
					}
				}
			}
		}
		
	}
	
}
