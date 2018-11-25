package com.rishi.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Two words anagram if they have same characters but create different word. Its like a game of creating as many
 * words possible with give characters.
 * So basically sorted versions of two words are same then they are anagram
 * 
 * Idea is to:
 * Sort the given string in array, check if map has it if not add it to map with list
 * 
 * NOTE: Follow question would be what if the words have space in between so better to take care of those
 * by replaceAll("\\s", "")
 * @author rishi
 *
 */
public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();

		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String str : strs) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String ns = new String(arr);

			if (map.containsKey(ns)) {
				map.get(ns).add(str);
			} else {
				ArrayList<String> al = new ArrayList<String>();
				al.add(str);
				map.put(ns, al);
			}
		}

		result.addAll(map.values());

		return result;
	}
	
	public static void main(String[] args) {
		String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = groupAnagrams(strs);
		
		System.out.println(res.toString());
	}
}
