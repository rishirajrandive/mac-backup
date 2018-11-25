package com.rishi.string;

public class NumberOfSegmentsInString {

	public static int countSegments(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        s = s.trim();
        if(s.equals(""))
        	return 0;
        String[] segments = s.split("\\s+");
        return segments.length;
    }
	
	public static void main(String[] args) {
//		String str = "    foo    bar";
		String str = "            ";
		System.out.println("Result "+ countSegments(str));
	}
}
