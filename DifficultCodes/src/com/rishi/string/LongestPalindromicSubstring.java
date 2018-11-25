package com.rishi.string;

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
        	return s; //or return ""
        }
        
        StringBuilder str = new StringBuilder();
        String result = "";
        for(int i=0; i<s.length(); i++){
        	str.append(s.charAt(i));
        	for(int j=i+1; j<s.length(); j++){
        		str.append(s.charAt(j));
        		if(str.toString().equalsIgnoreCase(str.reverse().toString()) && str.length() > result.length()){
        			result = str.toString();
        		}
        		str.reverse();
        	}
        	str = new StringBuilder();
        }
        return result.equalsIgnoreCase("") ? s.substring(0, 1) : result;
    }
	
	public String longestPalindromeBetter(String s){
		int maxLen = 1;
		int start = 0;
		int len = s.length();
		
		int low, high;
		
		for(int i=1; i<len; i++){
			low = i-1;
			high = i;
			
			while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
				if(high - low + 1 > maxLen){
					start = low;
					maxLen = high - low + 1;
				}
				--low;
				++high;
			}
			
			low = i-1;
			high = i+1;
			
			while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
				if(high - low + 1 > maxLen){
					start = low;
					maxLen = high - low + 1;
				}
				--low;
				++high;
			}
		}
		StringBuilder str = new StringBuilder();

		return s.substring(start, start+maxLen);
	}
	
	
	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
		String input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		
		System.out.println(System.currentTimeMillis());
		System.out.println("Result "+ obj.longestPalindrome(input));
		System.out.println(System.currentTimeMillis());
		
		System.out.println(System.currentTimeMillis());
		System.out.println("Result "+ obj.longestPalindromeBetter(input));
		System.out.println(System.currentTimeMillis());
	}
}
