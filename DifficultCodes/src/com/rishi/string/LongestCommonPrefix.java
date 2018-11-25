package com.rishi.string;

/**
 * Need to find the longest common prefix among array of string.
 * Method:
 * 1. Start looping over chars of first element in array
 * 2. Then inner loop will match character at same location in all other strings array.
 * 3. This will continue till we are getting match or the outer loop index is greater than length of string in 
 * 		consideration.
 * @author rishi
 *
 */
public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        
        for(int i=0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j=1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c){
                    return strs[j].substring(0, i);
                }
            }
        }
        return strs[0];
    }
	
	public static void main(String[] args) {
		String[] strs = {"prefix", "prepare"};
		System.out.println("Result "+ longestCommonPrefix(strs));
	}
}
