package ccti.rishi.arrays;

import java.util.HashMap;

/**
 * Question is to find if the given string is permutation of a Palindrome. That means important thing to 
 * find out is if the given string is palindrome or not.
 * 
 *  Idea is:
 *  1. Each palindrome will always have even number of characters or at most only one character is odd.
 *  Why? For example, tacocat is a palindrome, all the characters are even except o which is the only one odd 
 *  hence it is in the middle. Else taccat is also palindrome with all the characters even count. 
 *  2. Hence here instead of finding all the combinations of all the characters and then checking each for 
 *  palindrome, its easy to count the characters and decide based on that.
 *  3. Step 1. Create map for all the characters and their counts
 *  4. Step 2. Check each count value and verify if all are even or only one odd is present.
 * @author rishi
 *
 */
public class PalindromePermutation {

	private static boolean isPalindromPermutation(String str) {
		if(str == null) {
			return false;
		}
		str = str.trim();
		
		HashMap<Integer, Integer> map = new HashMap<>();		
		for(Character ch : str.toCharArray()) {
			if(ch == ' ') {
				continue;
			}
			if(map.containsKey(Character.getNumericValue(ch))){
				map.put(Character.getNumericValue(ch), map.get(Character.getNumericValue(ch)) + 1);
			}else {
				map.put(Character.getNumericValue(ch), 1);
			}
		}
		
		boolean isOdd = false;
		for(Integer count : map.values()) {
			if(count % 2 == 1){
				if(isOdd) {
					return false;
				}
				isOdd = true;
			}
		}
		return true;
	}
	
	private static boolean isPalindromPermutationBetter(String str) {
		if(str == null) {
			return false;
		}
		
		// Create the map
		int[] map = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
		for(char ch : str.toCharArray()) {
			int x = getCharNum(ch);
			if(x != -1){
				map[x]++;
			}
		}
		
		boolean isOddCount = false;
		for(int count : map) {
			if(count % 2 == 1) {
				if(isOddCount) {
					return false;
				}
				isOddCount = true;
			}
		}
		return true;
	}
	
	private static int getCharNum(char ch) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		if(Character.getNumericValue(ch) >= a && Character.getNumericValue(ch) <= z) {
			return Character.getNumericValue(ch) - a;
		}
		
		return -1;
	}
	
	
	
	// Using bit
	private static boolean isPalindromePermutationBit(String str) {
		int bitVector = createBitVector(str);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	// For the integer value of the char get the bitVector
	// Example, if the word is cac, so bitVector for c is 4, a is 5, and for last c it is 1. How?
	// Check toggle method, but basically idea is bit values is add to bitVector if not already present
	// else it is reduced from the bitVector
	private static int createBitVector(String str) {
		int bitVector = 0;
		for(char c : str.toCharArray()) {
			int x = getCharNum(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}
	
	// Mask is left shift of 1 with the given value of char
	// Then if bitVector does not already has the value of char, the & operation is 0
	// Else it is not zero.
	// Depending on the value, we either
	// If condition - perform OR operation with mask
	// else condition - perform & with negation of mask (basically remove the previously added bit value of char)
	private static int toggle(int bitVector, int index) {
		if(index < 0)
			return bitVector;
		
		int mask = 1 << index;
		if((bitVector & mask) == 0) {
			bitVector |= mask;
		}else {
			bitVector &= ~mask;
		}
		
		return bitVector;
	}
	
	private static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Char number "+ Character.getNumericValue('a'));
		
		System.out.println("Left shift "+ (1 << 10));
		System.out.println("Result "+ isPalindromPermutation("Tact Coa"));
		System.out.println("Result "+ isPalindromPermutationBetter("Tact Coa"));
		System.out.println("Result "+ isPalindromePermutationBit("Tact Coa"));
	}
}
