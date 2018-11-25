package ccti.rishi.arrays;

/**
 * Question is to compress the string by adding the number after each char representing
 * number of times it is repeated in the sequence. Example: aabbb -> a2b3. Also if compressed string
 * length is greater than actual return actual. Example: abc -> a1b1c1 (return abc).
 * 
 * Idea is to:
 * 1. Iterate over the string char by char
 * 2. Check if current is same as next
 * 3. If not same, append the char to result string with count.
 * 
 * Using StringBuilder here because String concat operation is costly. For a word of length 5 ("Hello")
 * if we use String concat operation, the time complexity is O(n2)
 * @author rishi
 *
 */
public class StringCompression {

	private static String compressString(String str) {
		if(str == null || str.length() == 0) {
			return str;
		}
		
		int count = 0;
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				result.append(str.charAt(i)).append(count+1);
				count = 0;
				
				if(result.length() > str.length()) {
					return str;
				}
			}else {
				count++;				
			}
		}
		
		return result.toString();
	}
	
	
	public static void main(String[] args) {
//		String str = "aabcccccaaa";
		String str = "abc";
		
		System.out.println("Result " + compressString(str));
	}
}
