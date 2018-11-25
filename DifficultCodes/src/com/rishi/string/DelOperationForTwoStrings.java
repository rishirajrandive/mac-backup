package com.rishi.string;

import java.util.Arrays;

/**
 * Given two strings need to determine the min number of chars to be deleted to make them same.
 * 
 * Ideas is to use DP without Longest Common Subsequence (LCS). With using LCS with DP we need to 
 * change the logic to track the number of matches. Whereas here we need to track the number of 
 * deletions required. DP can be implemented by using matrix or having two different arrays. The 
 * latter is used here. All the approaches are discussed here:
 * 
 * https://leetcode.com/articles/delete-operation-for-two-strings/
 * 
 * Here:
 * 1. Create two arrays one to store the history dp and other to store the temp values.
 * 2. Iterate over strings 1 and 2.
 * 		a. Create new temp every time string 1 iteration increments
 * 		b. If i or j is 0, save i+j in temp[j]
 * 		c. If char at i-1 is equal to j-1, add previous value from dp to temp
 * 		d. Else add 1 + min of dp and prev value from temp
 * 3. Value at s2.length in dp is our solution
 * @author rishi
 *
 */
public class DelOperationForTwoStrings {
	public int minDistance(String s1, String s2) {
		int[] dp = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int[] temp=new int[s2.length()+1];
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    temp[j] = i + j;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    temp[j] = dp[j - 1];
                else
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
            }
            dp=temp;
        }
        
        return dp[s2.length()];
    }
	
	public static void main(String[] args) {
		DelOperationForTwoStrings obj = new DelOperationForTwoStrings();
		System.out.println("Result " + obj.minDistance("mart", "karma"));
		int dp[] = {1};
		int temp[] = new int[1];
		System.out.println(Math.min(dp[0], temp[-1]));
	}
}
