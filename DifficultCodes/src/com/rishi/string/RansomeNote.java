package com.rishi.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Question is to find if the characters in magazine can be used to create ransom note if
 * if used only once. 
 * Ideas is to:
 * First approach:
 * 1. Create map with count of characters in ransom note
 * 2. Decrease the count based on the times the character appears in magazine
 * 3. If all keys in map have value 0, return true, else false.
 * 
 * Second approach:
 * 1. Better than first, create array of size 26 (a to z) and increment value for alphabets found in
 * magazine.
 * 2. Then iterate over the ransom note and decrement the values for alphabets found in ransom note
 * if that character is not in magazine the count will be less than 0.
 * 3. If less than return false, else true.
 * @author rishi
 *
 */
public class RansomeNote {

	public boolean canConstruct(String ransomNote, String magazine){
		int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
	}
	
	public boolean canConstruct1(String ransomNote,  String magazine){
		if(ransomNote == null || magazine == null){
            return false;
        }
        
        if(ransomNote.equals(magazine)){
            return true;
        }
        
        Map<Character, Integer> letterCount = new HashMap<>();
        
        for(Character ch : ransomNote.toCharArray()){
            letterCount.putIfAbsent(ch, 0);
            letterCount.put(ch, letterCount.get(ch)+1);
        }
        
        for(Character ch : magazine.toCharArray()){
            if(letterCount.containsKey(ch) && letterCount.get(ch) != 0){
                letterCount.put(ch, letterCount.get(ch)-1);
            }
        }
        
        for(Character ch : letterCount.keySet()){
            if(letterCount.get(ch) != 0){
                return false;
            }
        }
        return true;
	}
}
