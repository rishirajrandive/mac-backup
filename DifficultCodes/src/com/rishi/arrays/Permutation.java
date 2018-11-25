package com.rishi.arrays;

/**
 * Prints the lexicographical sequence or all the permutations possible for a sequence.
 * The logic is little complicated to understand, however for sequence with 3 elements its
 * pretty easy.
 * 
 * 										A|B|C
 * 					
 * 				A|B|C				   B|A|C					C|B|A
 * 														
 * 		A|B|C		    A|C|B	B|A|C		 B|C|A		C|B|A			C|A|B
 * @author rishi
 *
 */
public class Permutation {

	private void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		//System.out.println("Swapping "+a.charAt(i) + " and "+ a.charAt(j));
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String str = "1234";
		int n = str.length();
		Permutation permutation = new Permutation();
		permutation.permute(str, 0, n - 1);
	}
}
