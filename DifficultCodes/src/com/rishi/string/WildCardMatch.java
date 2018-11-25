package com.rishi.string;

/**
 * Two wild cards "?" - matches any single character
 * "*" - matches any sequence of characters.
 * Note: In case there are two or more * consecutively, it is same as saying only one *.
 * 
 * A classic dynamic problem question. As we are saving the result of sub problems in the 2D matrix.
 * Idea is to:
 * 1. Process the pattern and only take single * consecutively.
 * 2. Create a 2D boolean matrix with row = str.length()+1 and col = patter.length()+1
 * 3. Mark matrix[0][0] = true
 * 4. In case first index of pattern has *, matrix[0][1] = true
 * 5. Loop over the matrix starting from 1 till length of matrix and check and make matrix[i][j] = 
 * 		a. If pattern[j-1] == str[i-1] || pattern[j-1] == "?"
 * 			then matrix[i][j] = matrix[i-1][j-1] (has the value when the current pattern and str char were removed)
 * 		b. If pattern[j-1] == *
 * 			then matrix[i][j] = matrix[i][j-1] || matrix[i-1][j]
 * 		c. Else matrix[i][j] = false ( this is already given so no need
 * 6. Return value at matrix[str.length][pattern.length]
 * 
 *  
 * @author rishi
 *
 */
public class WildCardMatch {

	public static boolean isMatch(String text, String p){
		char[] str = text.toCharArray();
		char[] pattern = p.toCharArray();
		
		boolean isFirst = true;
		int writeIndex = 0;
		for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }
		
		boolean[][] T = new boolean[str.length+1][writeIndex+1];
		
		if(writeIndex > 0 && pattern[0] == '*'){
			T[0][1] = true;
		}
		
		T[0][0] = true;
		
		for(int i=1; i<T.length; i++){
			for(int j=1; j<T[0].length; j++){
				if(pattern[j-1] == str[i-1] || pattern[j-1] == '?'){
					T[i][j] = T[i-1][j-1];
				}else if(pattern[j-1] == '*'){
					T[i][j] = T[i][j-1] || T[i-1][j];
				}
			}
		}
		
		return T[str.length][writeIndex];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c**a*b"));
		System.out.println(isMatch("ab", "?*"));
	}
}
