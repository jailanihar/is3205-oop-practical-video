package video18;

public class RegexQuantifiers {
	
	public static void main(String[] args) {
		String abcd = "aabbbbbccccdddddbbbaaccccaaaddddd";
		System.out.println(abcd);
		// zero or more times
		System.out.println(abcd.replaceAll("aab*", "#"));
		System.out.println(abcd.replaceAll("aab*c*", "#"));
		System.out.println(abcd.replaceAll("aa[bc]*", "#"));
		// one or more times
		System.out.println(abcd.replaceAll("aab+", "#"));
		System.out.println(abcd.replaceAll("aa[bc]+", "#"));
		// {n} exactly n times
		System.out.println(abcd.replaceAll("aab{2}", "#"));
		System.out.println(abcd.replaceAll("aab{5}", "#"));
		System.out.println(abcd.replaceAll("aab{7}", "#"));
		// {n,} at least n times
		System.out.println(abcd.replaceAll("aab{3,}", "#"));
		System.out.println(abcd.replaceAll("aab{7,}", "#"));
		// {n,m} at least n times but not more than m times
		System.out.println(abcd.replaceAll("aab{3,7}", "#"));
		System.out.println(abcd.replaceAll("aab{1,3}", "#"));
		// once or not at all
		System.out.println(abcd.replaceAll("aab?", "#"));
	}
	
}
