package com.rishi.string;

/**
 * Simple but I still fucked up...
 * Remember to come up with questions.
 * @author rishi
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
        if(s.length() == 0){
            return 0;
        }
        
        int end;
        for(end = s.length()-1; end >= 0; end--){
            if(s.charAt(end) != ' ') break;
        }
        
        if(end < 0) return 0;
        
        int start;
        for(start = end-1; start >= 0; start--){
            if(s.charAt(start) == ' ') break;
        }
        
        return end - start;
    }
}
