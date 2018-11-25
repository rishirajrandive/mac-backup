package com.rishi.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Question is about finding files in the directory with duplicate contents.
 * Idea is to:
 * 1. Create a map with key as content and value as list of directories or file paths.
 * 2. Then just check for which key we have list size more than 2, add these to the result.
 * 3. Return the result.
 * @author rishi
 *
 */
public class FindDuplicateFS {

	public List<List<String>> findDuplicate(String[] paths) {
		List<List<String>> result = new ArrayList<>();
		
        if(paths == null || paths.length == 0){
        	return result; 
        }
        
        Map<String, List<String>> files = new HashMap<>();
        
        for(int i=0; i<paths.length; i++){
        	String[] items = paths[i].split("\\s");
        	String dir = items[0];
        	for(int j=1; j<items.length; j++){
        		String[] fileDetails = items[j].split("\\(");
        		String key = fileDetails[1].substring(0,fileDetails[1].length()-1);
        		files.putIfAbsent(key, new ArrayList<>());
        		files.get(key).add(dir + "/" + fileDetails[0]);
        	}
        }
        
        for(String key : files.keySet()){
        	if(files.get(key).size() >= 2){
                result.add(files.get(key));
            }
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		String[] input = {"root/a 1.txt(abcd) 2.txt(efgh)", 
							"root/c 3.txt(abcd)", 
							"root/c/d 4.txt(efgh)", 
							"root 4.txt(efgh)"};
		
		FindDuplicateFS obj = new FindDuplicateFS();
		System.out.println(obj.findDuplicate(input));
		
		String str = "";
		Map<Character, Integer> letterCount = new HashMap<>();
        
        for(Character ch : str.toCharArray()){
            letterCount.putIfAbsent(ch, 0);
            letterCount.put(ch, letterCount.get(ch)+1);
        }
	}
}
