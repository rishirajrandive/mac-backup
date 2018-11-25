package com.rishi.stacks.queues;

import java.util.Stack;

/**
 * We need to find the longest valid substring length. Example: ()()(()
 * Here the longest valid substring length is 4 ()()... note () is not considered because of break in between
 * 
 * Idea:
 * 1. When we ( push it to stack (push the index not the element)
 * 2. Else first check stack is empty, if yes update the last pointer to i
 * 3. If stack is not empty pop the element, after popping if stack is empty
 * 		a. If empty, len = max(i-last, len)
 * 		b. Else, len = max(i-stack.peek(), len)
 * @author rishi
 *
 */
public class LongestValidParanthesis {

	public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int last = -1;
        int maxLen = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        char[] paras = s.toCharArray();
        
        for(int i=0; i<paras.length; i++){
            if(paras[i] == '('){
                stack.push(i);
            }else {
                if(stack.isEmpty()){
                    last = i;
                }else {
                    stack.pop();
                    if(stack.isEmpty()){
                        maxLen = Math.max(i-last, maxLen);
                    }else {
                        maxLen = Math.max(i-stack.peek(), maxLen);
                    }
                }
            }
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		String[] str = "a/b/./../..////c/".split("/");
		System.out.println(longestValidParentheses("(("));
	}
}
