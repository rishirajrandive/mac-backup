package com.rishi.stacks.queues;

import java.util.Stack;

/**
 * Simple to find valid parenthesis, () {} [] only allowed
 * @author rishi
 *
 */
public class ValidParanthesis {

	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (c == '}') {
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
			} else if (c == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty() ? true : false;
	}
	
	public static void main(String[] args) {
		
	}
}
