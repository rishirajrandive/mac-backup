package ccti.rishi.arrays;

import java.util.HashSet;
import java.util.Set;

public class CheckIfOneEditAway {

	private static boolean oneEditAway(String first, String second) {
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		// Get shorter and longer string
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		
		int index1 = 0;
		int index2 = 0;
		
		boolean foundDifference = false;
		while(index2 < s2.length() && index1 < s1.length()) {
			if(s1.charAt(index1) != s2.charAt(index2)) {
				// Ensure that this is the first difference found
				if(foundDifference) {
					return false;
				}
				foundDifference = true;
				
				if(s1.length() == s2.length()) { // On replace, move shorter pointer
					index1++;
				}
			}else {
				index1++; // If matching, move shorter pointer
			}
			index2++; // Always move pointer for longer strings
		}
		
		return true;
	}
	
	
	private static boolean oneEditAwayUsingSet(String first, String second) {
		if(Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		HashSet<Character> set1 = new HashSet<>();
		
		for(char ch : first.toCharArray()) {
			set1.add(ch);
		}
		
		int remaining = second.length();
		for(char ch : second.toCharArray()) {
			if(set1.contains(ch)) {
				set1.remove(ch);
				remaining--;
			}
		}
		
		if(set1.isEmpty() && remaining == 1) {
			return true;
		}else if(set1.size() ==  1 && remaining == 0) {
			return true;
		}else if(set1.size() == remaining){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("No difference "+ oneEditAway("pale", "pale"));
		System.out.println("Replace "+ oneEditAway("pale", "bale"));
		System.out.println("Insert "+ oneEditAway("pal", "pale"));
		System.out.println("Remove "+ oneEditAway("pale", "pae"));
		System.out.println("Invalid "+ oneEditAway("pale", "bae"));
		
		
		System.out.println("No difference "+ oneEditAwayUsingSet("pale", "Pale"));
		System.out.println("Replace "+ oneEditAwayUsingSet("pale", "bale"));
		System.out.println("Insert "+ oneEditAwayUsingSet("pal", "pale"));
		System.out.println("Remove "+ oneEditAwayUsingSet("pale", "pae"));
		System.out.println("Invalid "+ oneEditAwayUsingSet("pale", "bae"));
	}
}
