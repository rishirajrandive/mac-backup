package com.rishi.string;

/**
 * Find the needle in haystack and return the first index if found.
 * I think it's clear how to do it
 * Only important point is substring - goes from start to end-1
 * @author rishi
 *
 */
public class ImplementStrStr {

	public static int strStr(String haystack, String needle){
		int len1 = haystack.length();
        int len2 = needle.length();
        
        for(int i=0; i+len2-1 < len1; i++){
            if(haystack.substring(i, i+len2).equals(needle))
                return i;
        }
        return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(strStr("catdogcatrt", "dg"));
	}
}
