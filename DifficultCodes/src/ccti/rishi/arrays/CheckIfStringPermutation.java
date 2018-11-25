package ccti.rishi.arrays;

import java.util.HashSet;

/**
 * Question is to find if one string is permutation of other string. 
 * Should clarify from the interviewer:
 * 1. Is the permutation case sensitive or insensitive.
 * 2. White space is allowed or not
 * Examples: [42, 24], [God, dog], [123, 321], [23, 34], [43  , 34]
 * 
 * Ideas is to:
 * 1. If length of two strings is different, they are clearly not permutation of each other.
 * 2. Have HashSet which will have all the chars from the first string.
 * 3. Iterate over the next string and check if each char is in the set, if not return false, else finally return true
 * 
 * Extenstion:
 * 1. In case initially it's case sensitive then it's simple, later if he changes it to case insensitive.
 * 2. Initialy whitespace is allowed, later no whitespace allowed.
 * @author rishi
 *
 */
public class CheckIfStringPermutation {

	private boolean isPermutation(String src, String str) {
		
		// In case no whitespace is allowed.
//		src = src.trim();
//		str = str.trim();
		
		// Comment this check if we just want to check if all the chars in src can form str.
		if(src.length() != str.length()) {
			return false;
		}
		
		// In case it is case sensitive
//		src = src.toLowerCase();
//		str = str.toLowerCase();
		
		HashSet<Character> set = new HashSet<>();
		for(int i=0; i < src.length(); i++) {
			set.add(src.charAt(i));
		}
		
		for(int i=0; i < str.length(); i++) {
			if(!set.contains(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		CheckIfStringPermutation obj = new CheckIfStringPermutation();
		
		System.out.println("Result "+ obj.isPermutation("godd  ", "dog"));
	}
}
