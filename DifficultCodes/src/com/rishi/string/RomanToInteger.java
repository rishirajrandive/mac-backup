package com.rishi.string;

import java.util.HashMap;

/**
 * Idea is simple, have a map with all the 13 possibilities where we need direct value from the map.
 * Then loop over the string with i=0 till length;
 * 1. Check if the current index till the last is present in map, if yes add it to num and increment i.
 * 2. Check if current index and index+1 are in map, if yes add value to num and increment i.
 * 3. Else, just take the value from map for char at current index and add it to num. 
 * @author rishi
 *
 */
public class RomanToInteger {

private static HashMap<String, Integer> map = new HashMap<>();
    
    static{
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }
    public static int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int num = 0;
        for(int i=0; i<s.length(); i++){
        	if(map.containsKey(s.substring(i))){
        		num += map.get(s.substring(i));
        		i++;
        	}else if(i+2 < s.length() && map.containsKey(s.substring(i, i+2))){
        		num += map.get(s.substring(i, i+2));
        		i++;
        	}else{
                num += map.get(s.charAt(i)+"");
            }
        }
        return num;
    }
    
    public static void main(String[] args) {
    	String str =    "      M    C   V   M";
    	str = str.trim();
    	int[] a = new int[2];
    	//System.out.println(str.substring(0, 2));
    	System.out.println(str);
		System.out.println("Result: "+ romanToInt("MCMXCX"));
	}
}
