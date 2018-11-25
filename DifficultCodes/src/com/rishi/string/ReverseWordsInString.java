package com.rishi.string;

/**
 * Reverse the words in the string. Idea here is to split the string using regex not space character.
 * Because - There can be more than one space between the words in a string. This could be possible follow up
 * question in interview. How many spaces could be there?
 * So regex "\\s" will consider all such white spaces and split the string based on that.
 * Once the string is split we have the array.
 * Loop over the array and append the strings with space between them.
 * 
 * Without using regex would be split based on space and then trim each word.
 * @author rishi
 *
 */
public class ReverseWordsInString {

	public static String reverseWords(String s) {
		if(s == null || s.length() == 0){
        	return s;
        }
        
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
//        int j = 0;
//        for(int i=0; i<words.length; i++){
//        	if(words[i].length() > 0){
//        		words[j] =  words[i];
//        		j++;
//        	}
//        }
//        
//        for(int i=j; i >= 0; i--){
//        	result.append(words[i]);
//        	result.append(" ");
//        }
        
        for(int i=words.length-1; i >= 0; i--){
	    	result.append(words[i]);
	    	result.append(" ");
	    }
        
        return result.toString().trim();
    }
	
	public static void main(String[] args) {
		System.out.println("Result: "+ reverseWords("     sky  the    is blue"));
	}
}
