package com.rishi.greedy;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int digits = num.length() - k;
        char[] chars = new char[num.length()];
        int top = 0;
        
        for(int i=0; i<num.length(); i++) {
        	char c = num.charAt(i);
        	while(top > 0 && chars[top-1] > c && k > 0) {
        		top -= 1;
        		k -= 1;
        	}
        	chars[top++] = c;
        }
        
        int idx = 0;
        
        while(idx < digits && chars[idx] == '0') {
        	idx++;
        }
        
        return (idx == digits) ? "0" : new String(chars, idx, digits - idx);
    }
	
	public static void main(String[] args) {
		RemoveKDigits obj = new RemoveKDigits();
		System.out.println("Result: "+ obj.removeKdigits("1432219", 3));
		System.out.println("Result: "+ obj.removeKdigits("11200", 1));
		System.out.println("Result: "+ obj.removeKdigits("10", 2));
	}
}
