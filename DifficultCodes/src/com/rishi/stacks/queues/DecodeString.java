package com.rishi.stacks.queues;

import java.util.Stack;

/**
 * Idea is to:
 * 1. Have two stacks one for strings and one for numbers, keep populating the stacks
 * 2. 
 * @author rishi
 *
 */
public class DecodeString {

	public String decodeString(String s) {
		if(s == null || s.length() == 0){
			return s;
		}
		
		Stack<Integer> numStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		
		StringBuilder result = new StringBuilder();
		char[] ch = s.toCharArray();
		for(int i=0; i<ch.length; i++){
			if(isNum(ch[i])){
				StringBuilder num = new StringBuilder();
				num.append(ch[i]);
				while(i+1 < ch.length && isNum(ch[i]) && ch[i+1] != '[' && ch[i+1] != ']'){
					num.append(ch[i+1]);
					i++;
				}
				numStack.push(Integer.parseInt(num.toString()));
			}else if(ch[i] == '['){
				resStack.push(result.toString());
				result.setLength(0);
			}else if(ch[i] == ']'){
				StringBuilder temp = new StringBuilder(resStack.pop());
				Integer times = numStack.pop();
				
				for(int j=0; j<times; j++){
					temp.append(result);
				}
				result.setLength(0);
				result.append(temp);
			}else {
				result.append(ch[i]);
			}
		}
		
		return result.toString();
	}
	
	public boolean isNum(char ch){
		return ch >= '0' && ch <= '9';
	}
	
	public static void main(String[] args) {
		DecodeString obj = new DecodeString();
		
//		System.out.println("Result "+ obj.decodeString("10[a]2[bc]"));
//		System.out.println("Result "+ obj.decodeString("2[abc]3[cd]ef"));
//		System.out.println("Result "+ obj.decodeString("3[a2[c]]"));
//		System.out.println("Result "+ obj.decodeString("2[2[b]]"));
//		System.out.println("Result "+ obj.decodeString("sd2[f2[e]g]i"));
		
		int val = 3;
		char ch = 3 + '0';
		System.out.println(ch);
	}
}
