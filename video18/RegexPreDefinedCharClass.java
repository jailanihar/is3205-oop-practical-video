package video18;

public class RegexPreDefinedCharClass {
	
	public static void main(String[] args) {
		String oop = "IS3205 Object Oriented Programming";
		System.out.println(oop);
		// Replace any character to #
		System.out.println(oop.replaceAll(".", "#"));
		// Replace any digits 0 until 9 to #
		System.out.println(oop.replaceAll("\\d", "#"));
		// Replace any non-digits to #
		System.out.println(oop.replaceAll("\\D", "#"));
		// Replace any whitespace characters to #
		System.out.println(oop.replaceAll("\\s", "#"));
		// Replace any non-whitespace characters to #
		System.out.println(oop.replaceAll("\\S", "#"));
		// Replace any digits or any whitespace characters to #
		System.out.println(oop.replaceAll("[\\d\\s]", "#"));
		// Replace first character digits then second character whitespace to #
		System.out.println(oop.replaceAll("\\d\\s", "#"));
		// Replace any word characters to #
		System.out.println(oop.replaceAll("\\w", "#"));
		// Replace any non-word characters to #
		System.out.println(oop.replaceAll("\\W", "#"));
	}
	
}
