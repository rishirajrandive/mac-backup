package com.rishi.string;

/**
 * We assign codes to alphabets from A to Z where the code starts from 1 till 26. 
 * We need to find out how many ways a given number string can be decoded in the alphabets.
 * For example:
 * Input string - 12
 * Output - 2 (because it could be AB or L)
 * 
 * Idea is to:
 * 1. Use DP and save the results.
 * 2. Create an array with length + 1.
 * 3. Value at 0 would be 1, because if length is 1, there is only way to represent it.
 * 4. Then put value at index 1 based on the value present at string's 0 index.
 * 5. Now loop over the string starting index 2, and check for i-1 and i-2 substrings
 * 6. If they give the valid alphabet add their values from array index i-1 and i-2 to i index
 * 7. Continue and finally the result would be at index s.length()
 * @author rishi
 *
 */
public class DecodeWays {
	public static int numDecodings(String s) {
		if(s == null || s.length() == 0){
			return 0;
		}
		
		int len = s.length();
		int[] dp = new int[len+1];
		dp[0] = 1;
		dp[1] = s.charAt(1) == '0' ? 0 : 1;
		
		for(int i=2; i<= len; i++){
			int first = Integer.parseInt(s.substring(i-1, i));
			int second = Integer.parseInt(s.substring(i-2, i));
			if(first > 0 && first < 10){
				dp[i] += dp[i-1];
			}
			
			if(second > 9 && second < 27){
				dp[i] += dp[i-2];
			}
		}
		
		return dp[len];
	}
	
	public static void main(String[] args) {
		String s = "1223";
		System.out.println("Result "+ numDecodings(s));
	}
}
