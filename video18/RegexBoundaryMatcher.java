package video18;

public class RegexBoundaryMatcher {
	
	public static void main(String[] args) {
		String oop = "IS3205 Object Oriented Programming IS3205";
		System.out.println(oop);
		// Replace all instances of IS3205 to #
		System.out.println(oop.replaceAll("IS3205", "#"));
		// Replace IS3205 if it is at the beginning of the string to #
		System.out.println(oop.replaceAll("^IS3205", "#"));
		// Replace IS3205 if it is at the end of the string to #
		System.out.println(oop.replaceAll("IS3205$", "#"));
		// Replace any word boundary to #
		System.out.println(oop.replaceAll("\\b", "#"));
		// Replace any non-word boundary to #
		System.out.println(oop.replaceAll("\\B", "#"));
	}
	
}
