package video18;

import java.util.Scanner;

public class ICChecker {
	
	public static void main(String[] args) {
		// To check first two digit followed by dash
		// then followed six digit
		// 00-000000
		Scanner userInput = new Scanner(System.in);
		String input = "";
		while(true) {
			System.out.println("Input IC Number or q to quit:");
			input = userInput.nextLine();
			if(!input.toLowerCase().equals("q")) {
				if(input.matches("^\\d{2}-?\\d{6}$")) {
					System.out.println(input + " is valid IC");
				} else {
					System.out.println(input + " is invalid IC");
				}
			} else {
				System.out.println("Application Terminated.");
				userInput.close();
				System.exit(0);
			}
		}
	}
	
}
