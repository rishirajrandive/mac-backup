package com.rishi.string;

/**
 * Steps:
 * 1. Create 2D boolean array with size of rows = length of text +1 and 
 * size of column = length of pattern +1.
 * 2. Start matching, if pattern matches with '.' or value in text, then value at i and j 
 * will be value at i-1 and j-1 i.e. diagonal values.
 * 3. If it matches '*' we check the values at j-2 as we need to see if values preceding '*', j-1
 * are match, because j-1 can have zero or more occurences.
 * 4. However, if we hit '.' or match the text at j-2 and i-1, we take the OR between value in one row
 * above it and current i and j.
 * @author rishi
 *
 */
public class RegexPatternMatch {

	public static boolean isMatch(String str, String pattern){
		boolean [][] matchMatrix = new boolean[str.length()+1][pattern.length()+1];
			
		matchMatrix[0][0] = true;
		
		for(int i=1; i<matchMatrix[0].length; i++){
			if(pattern.charAt(i-1) == '*'){
				matchMatrix[0][i] = matchMatrix[0][i-2];
			}
		}
		
		for(int i=1; i<matchMatrix.length; i++){
			for(int j=1; j<matchMatrix[0].length; j++){
				if(pattern.charAt(j-1) == str.charAt(i-1) || pattern.charAt(j-1) == '.'){
					matchMatrix[i][j] = matchMatrix[i-1][j-1];
				}else if(pattern.charAt(j-1) == '*'){
					matchMatrix[i][j] = matchMatrix[i][j-2];
					if(pattern.charAt(j-2) == str.charAt(i-1) || pattern.charAt(j-2) == '.'){
						matchMatrix[i][j] = matchMatrix[i][j] | matchMatrix[i-1][j];
					}
				}else {
					matchMatrix[i][j] = false;
				}
			}
		}
		
		return matchMatrix[str.length()][pattern.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("aa", "a*"));
		//System.out.println(isMatch("aa", "a**b****C"));
	}
}
