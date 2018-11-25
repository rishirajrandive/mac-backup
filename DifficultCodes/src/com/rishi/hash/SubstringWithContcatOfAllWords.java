package com.rishi.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Create two maps, 
 * 1. With words to find out and number of times the same words is in array
 * 2. For maintaining the found words
 * 
 * We start iterating over string length, and go till length - (m*n), where m is length of array and n is length of 
 * each word in array (same for all)
 * For each index of string, we check m times for the words
 * 1. Whenever the substring is not present in toFind break
 * 2. Else continue and check if already present in found if yes increment the count else add new
 * 3. When loop breaks, check if loop value is equal to m
 * 4. If yes add the index of string to result.
 *  
 * @author rishi
 *
 */
public class SubstringWithContcatOfAllWords {

	public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<String, Integer> toFind = new HashMap<>();
        HashMap<String, Integer> found = new HashMap<>();
        
        int m = words.length;
        int n = words[0].length();
        
        for(int i=0; i<words.length; i++){
            if(toFind.containsKey(words[i])){
                toFind.put(words[i], toFind.get(words[i])+1);
            }else {
                toFind.put(words[i], 1);
            }
        }
        
        for(int i=0; i<=s.length() - m*n; i++){
            found.clear();
            int j;
            for(j =0; j<m; j++){
                int k = i+j*n;
                String str = s.substring(k, k+n);
                if(!toFind.containsKey(str))
                    break;
                    
                if(!found.containsKey(str)){
                    found.put(str, 1);
                }else {
                    found.put(str, found.get(str)+1);
                }
                
                if(found.get(str) > toFind.get(str))
                    break;
            }
            if(j == m)
                result.add(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] strs = {"word","good","best","good"};
		
		findSubstring(s, strs);
	}
}
