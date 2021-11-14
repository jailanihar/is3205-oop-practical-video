package video18;

public class RegexCharacterClass {
	
	public static void main(String[] args) {
		String oop = "IS3205 Object Oriented Programming";
		System.out.println(oop);
		// Replace letter a to #
		System.out.println(oop.replaceAll("a", "#"));
		// Replace pattern mm to #
		System.out.println(oop.replaceAll("mm", "#"));
		// Replace pattern Programming to #
		System.out.println(oop.replaceAll("Programming", "#"));
		// Replace O or o to #
		System.out.println(oop.replaceAll("[Oo]", "#"));
		// Replace a, i or o to #
		System.out.println(oop.replaceAll("[aio]", "#"));
		// Replace a to z to #
		System.out.println(oop.replaceAll("[abcdefghijklmnopqrstuvwxyz]", "#"));
		System.out.println(oop.replaceAll("[a-z]", "#"));
		// Replace a to z or A to Z to #
		System.out.println(oop.replaceAll("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]", "#"));
		System.out.println(oop.replaceAll("[a-zA-Z]", "#"));
		// Replace any digits to #
		System.out.println(oop.replaceAll("[0-9]", "#"));
		// Replace a to m or 0 to 4 to #
		System.out.println(oop.replaceAll("[a-m0-4]", "#"));
		// Replace Ob/ob/Or/or/Og/og to #
		System.out.println(oop.replaceAll("[oO][brg]", "#"));
		
		// Replace any character except a, i or o to #
		System.out.println(oop.replaceAll("[^aio]", "#"));
		// Replace any lower case letters except a, i or o
		System.out.println(oop.replaceAll("[b-hj-np-z]", "#"));
		System.out.println(oop.replaceAll("[a-z&&[^aio]]", "#"));
		
		// Replace any digits 3 until 7 or 9 to #
		System.out.println(oop.replaceAll("[3-79]", "#"));
	}
	
}
