package com.rishi.stacks.queues;

import java.util.HashSet;
import java.util.Stack;

/**
 * We need to give the output is smallest lexical order. For example:
 * Input - bcabc
 * Output - abc (this is straight forward)
 * Input - cbacdcbc
 * Output - acdb (because we need to maintain the order and return the smallest lexical order)
 * We can't return abcd in above because after 'a' we have 'c' and 'd'
 * 
 * Removing duplicates is easy, which could be achieved by just using HashSet, this will only keep unique
 * values and order them lexically. However, here we need to remove duplicates as well as return smallest lexical
 * order while maintaining the original order
 * 
 * Idea is to:
 * 1. Have 26 element array for char count and visited
 * 2. First get the count of chars in the string at their relevant location in the array
 * 3. For each letter in string, 
 * 		a. Decrement the count in array
 * 		b. If visited exit the iteration and continue with next
 * 		c. Check if stack's top element is lexically greater than current char and it's count is also > 0
 * 		d. If #c is true, mark the stack top element as not visited and pop it. Continue doing this till #c is true
 * 		e. After while, push the current char in stack and mark it visited.
 * 4. Once all the letters are done, iterate through stack and return the string
 * @author rishi
 *
 */
public class RemoveDuplicateLetter {

	public String removeDuplicateNoLexical(String s){
		if(s == null || s.length() == 0){
        	return s;
        }
        String result = "";
        
        HashSet<Character> map = new HashSet<>();
        for(int i=0; i<s.length(); i++){
        	map.add(s.charAt(i));
        }

        for(Object ch : map.toArray()){
        	result += (Character) ch;
        }
        return result;
	}
	
	
	public String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] charCount = new int[26];
		boolean[] visited = new boolean[26];
		char[] charArr = s.toCharArray();

		for (char ch : charArr) {
			charCount[ch - 'a']++;
		}

		for (char ch : charArr) {
			charCount[ch - 'a']--;
			if (visited[ch - 'a']) {
				continue;
			}

			while (!stack.isEmpty() && stack.peek() > ch && charCount[stack.peek() - 'a'] > 0) {
				visited[stack.peek() - 'a'] = false;
				stack.pop();
			}

			stack.push(ch);
			visited[ch - 'a'] = true;
		}

		StringBuilder sb = new StringBuilder();
		for (Character ch : stack) {
			sb.append(ch);
		}

		return sb.toString();
	}
}
