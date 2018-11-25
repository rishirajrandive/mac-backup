package com.rishi.string;

/**
 * Converting String to integer without using java methods. Its simple however the corner cases added on leetcode 
 * makes it more difficult.
 * Idea is to:
 * 1. Trim or ignore all the spaces before you encounter any number
 * 2. After a valid sign (+ or -) we should get number else return 0
 * 3. Take all the continuous numbers and ignore the char after the valid numbers
 * 
 * Two methods here, first one dies for corner cases however other takes care of all.
 * @author rishi
 *
 */
public class StringToIntegerATOI {

	public static int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		int[] numbers = new int[str.length()];
		int result = 0;

		boolean isNegative = false;
		boolean isPositive = false;
		int i = 0, j = 0;

		for (i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (j == 0 && ch == '-' && !isPositive) {
				isNegative = true;
			} else if (ch - '0' >= 0 && ch - '0' <= 9) {
				numbers[j] = ch - '0';
				j++;
			}else if(j == 0 && ch == '+' && !isNegative){
				isPositive = true;
			}else if(j == 0 && ch == ' '){
				continue;
			}else {
				break;
			}
		}

		int len = j-1;
		for (i = 0; i < j; i++) {
			int val = numbers[i];
			for (int x = 0; x < len; x++) {
				val *= 10;
			}
			result += val;
			if (result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		 
			if (result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			len--;
		}

		if (isNegative && result != 0) {
			result *= -1;
		}

		return result;
	}
	
	public static int otherAtoi(String str){
		if (str == null || str.length() < 1)
			return 0;
	 
		// trim white spaces
		str = str.trim();
	 
		char flag = '+';
	 
		// check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		// use double to store result
		double result = 0;
	 
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
	 
		if (flag == '-')
			result = -result;
	 
		// handle max and min
		if (result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
	 
		if (result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
	 
		return (int) result;
	}
	public static void main(String[] args) {
		System.out.println(myAtoi("2147483648"));
	}
}
