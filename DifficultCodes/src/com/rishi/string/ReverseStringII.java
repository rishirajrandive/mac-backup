package com.rishi.string;

public class ReverseStringII {

	public String reverseStr(String s, int k) {
        int len = s.length();
        int i=0;
        StringBuilder result = new StringBuilder();
        for(i=0; i<len; i+=2*k){
        	if(len-i >= 2*k){
        		String str = s.substring(i, i+2*k);
        		StringBuilder rev = new StringBuilder(str.substring(0, k));
        		result.append(rev.reverse().toString() + str.substring(k, str.length()));
        	}else if(len-i < 2*k && len-i >= k){
        		String str = s.substring(i, len);
        		StringBuilder rev = new StringBuilder(str.substring(0, k));
        		result.append(rev.reverse().toString() + str.substring(k, str.length()));
        	}else {
        		StringBuilder rev = new StringBuilder(s.substring(i, len));
        		result.append(rev.reverse().toString());
        	}
        }
        
        return result.toString();
    }
	
	public String reverseStrOptimized(String s, int k){
		char[] chars = s.toCharArray();
		boolean doRev = true;
		int len = chars.length;
		int i = 0;
		while(i < len){
			if(doRev){
				reverse(chars, i, i+k-1 < len ? i+k-1 : len-1);
				doRev = false;
			}else {
				doRev = true;
			}
			i += k;
		}
		return new String(chars);
	}
	
	public void reverse(char[] chars, int start, int end){
		while(start < end){
			char tmp = chars[start];
		    chars[start] = chars[end];
		    chars[end] = tmp;
		    start++;
		    end--;
		}
		return;
	}
	
	public static void main(String[] args) {
		ReverseStringII obj = new ReverseStringII();
		System.out.println("Result "+ obj.reverseStrOptimized("abcd", 2));
	}
	
}
