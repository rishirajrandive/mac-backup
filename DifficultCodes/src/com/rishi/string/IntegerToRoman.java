package com.rishi.string;

import java.util.LinkedHashMap;

/**
 * Remember that in Roman 900, 400, 90, 40, 9 and 4 are denoted differently to avoid four times repeated symbol.
 * So all that added in the static.
 * Start iterating with value = 1000 till 1, recurrsive call made
 * @author rishi
 *
 */
public class IntegerToRoman {

	private static LinkedHashMap<Integer, String> romanSymbols = new LinkedHashMap<>();
	static{
		romanSymbols.put(1000, "M");
		romanSymbols.put(900, "CM");
		romanSymbols.put(500, "D");
		romanSymbols.put(400, "CD");
		romanSymbols.put(100, "C");
		romanSymbols.put(90, "XC");
		romanSymbols.put(50, "L");
		romanSymbols.put(40, "XL");
		romanSymbols.put(10, "X");
		romanSymbols.put(9, "IX");
		romanSymbols.put(5, "V");
		romanSymbols.put(4, "IV");
		romanSymbols.put(1, "I");
	}
	
	private static String convertIntToRoman(int num){
		for(Integer n : romanSymbols.keySet()){
			if(num >= n){
				return romanSymbols.get(n) + convertIntToRoman(num - n);
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println("Result "+ convertIntToRoman(1001));
	}
}

