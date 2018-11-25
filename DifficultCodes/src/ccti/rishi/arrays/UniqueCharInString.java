package ccti.rishi.arrays;

/**
 * Question: Find if string has Unique chars or not. If yes, return true else false.
 * Idea is to:
 * 1. First clarify if the String is ASCII or Unicode. 
 * 		ASCII has 128 code points, 0 through 127. Extended ASCII has 255 chars.
 * 		Unicode is superset of ASCII where 0 to 127 represent same set of chars as ASCII
 * 2. First approach, create a binary array of size 128 and set true whenever you find that char
 * 		1. Return false as soon as you get second char for same index
 * 3. Second approach, use bit manipulation  
 * @author rishi
 *
 */
public class UniqueCharInString {

	private boolean isUniqueChars(String str) {
		if(str.length() > 128) {
			return false;
		}
		
		boolean[] set = new boolean[128];
		for(int i=0; i<str.length(); i++){
			int val = str.charAt(i);
			if(set[val]) {
				return false;
			}
			set[val] = true;
		}
		
		return true;
	}
	
	private boolean isUniqueCharsUsingBit(String str) {
		int check = 0;
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if((check & (1 << val)) > 0) {
				return false;
			}
			check |= (1 << val);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String str = "117";
		
		System.out.println(str.charAt(2) - 'a');
		int val = str.charAt(2) - 'a';
		System.out.println(1 << 4);
		int check = 0;
		System.out.println(check | (1 << val));
		
		UniqueCharInString obj = new UniqueCharInString();
		System.out.println(obj.isUniqueChars(str));
		System.out.println(obj.isUniqueCharsUsingBit(str));
	}
}
