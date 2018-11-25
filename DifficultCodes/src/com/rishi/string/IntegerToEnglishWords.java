package com.rishi.string;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerToEnglishWords {
	private Map<Integer, String> tens;
	private Map<Integer, String> teensAndUnits;
	
	public String numberToWords(int num) {
		tens = new HashMap<>();
		tens.put(1, "Ten");
		tens.put(2, "Twenty");
		tens.put(3, "Thirty");
		tens.put(4, "Forty");
		tens.put(5, "Fifty");
		tens.put(6, "Sixty");
		tens.put(7, "Seventy");
		tens.put(8, "Eighty");
		tens.put(9, "Ninety");
		
		teensAndUnits = new HashMap<>();
		teensAndUnits.put(1, "One");
		teensAndUnits.put(2, "Two");
		teensAndUnits.put(3, "Three");
		teensAndUnits.put(4, "Four");
		teensAndUnits.put(5, "Five");
		teensAndUnits.put(6, "Six");
		teensAndUnits.put(7, "Seven");
		teensAndUnits.put(8, "Eight");
		teensAndUnits.put(9, "Nine");
		teensAndUnits.put(10, "Ten");
		teensAndUnits.put(11, "Eleven");
		teensAndUnits.put(12, "Twelve");
		teensAndUnits.put(13, "Thirteen");
		teensAndUnits.put(14, "Fourtenn");
		teensAndUnits.put(15, "Fifteen");
		teensAndUnits.put(16, "Sixteen");
		teensAndUnits.put(17, "Seventeen");
		teensAndUnits.put(18, "Eighteen");
		teensAndUnits.put(19, "Nineteen");
		
		String thousands[] = {"", "Thousand", "Million", "Billion"};
		
		if(num == 0){
			return "Zero";
		}
		if(num < 10){
			return teensAndUnits.get(num);
		}
	
		String result = "";
		int i=0;
		
		while (num > 0) {
	        if (num % 1000 != 0)
	    	    result = updateResult(num % 1000) + thousands[i] + " " + result;
	    	num /= 1000;
	    	i++;
	    }		
		
		return result.trim();
	}
	
	private String updateResult(int num) {
	    if (num == 0)
	        return "";
	    else if (num < 20)
	        return teensAndUnits.get(num) + " ";
	    else if (num < 100)
	        return tens.get(num/10) + " " + updateResult(num % 10);
	    else
	        return teensAndUnits.get(num / 100) + " Hundred " + updateResult(num % 100);
	}

	
	public static void main(String[] args) {
//		IntegerToEnglishWords obj = new IntegerToEnglishWords();
//		
//		System.out.println("Result: "+ obj.numberToWords(111));
		String reg1 = "";
		String reg = "[A-Za-z0-9_\\-]{8,40}$";
		String EMAIL_REGEX = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern EMAIL_PATTERN = Pattern.compile(reg);
		
		Matcher emailMatcher = EMAIL_PATTERN.matcher("rish312sd");
        if(emailMatcher.matches()){
            System.out.println("Match");
        }
	}
}
