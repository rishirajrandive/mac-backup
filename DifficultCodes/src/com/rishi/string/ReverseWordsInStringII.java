package com.rishi.string;

/**
 * Reverse the individual words in the sentence and keep the sentence placement as it is.
 * 
 * Another small code could be, splitting the strings " " and then iterating over the array
 * to form the result
 * @author rishi
 *
 */
public class ReverseWordsInStringII {

	public static String reverseWords(String s) {
        if(s == null){
        	return s;
        }
        String[] str = s.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i=0; i<s.length(); i++){
        	if(s.charAt(i) == ' '){
        		temp.reverse();
        		result.append(temp + " ");
        		temp.setLength(0);
        	}else {
        		temp.append(s.charAt(i));
        	}
        }
        
        if(temp.length() != 0){
        	result.append(temp.reverse());
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		String str = "    foo    bar";
//		String str = "Let's take LeetCode contest";
		System.out.println("Result " + reverseWords(str));
	}
}
