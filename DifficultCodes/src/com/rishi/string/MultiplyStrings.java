package com.rishi.string;

/**
 * We cannot conver the strings to integer directly here.
 * First method could be used for inputs product of which is less than the integer or long limit.
 * However, for the question the length of the strings could be almost equal to 110. 
 * So multiplyBig makes sure that all the cases are covered.
 * 
 * Idea is to:
 * 1. Use the same multiplication principle but store the values in the array
 * 2. Each array element represents a digit in the final result and right to left is the final output.
 * 3. By having pos1 and pos2 we take care of carry in the product result sum.
 * 4. Just follow the multiplyBig for one example, it will be clear.
 * @author rishi
 *
 */
public class MultiplyStrings {

	public String multiply(String num1, String num2) {
		int mul1 = 1;
		int mul2 = 1;
		int result = 0;
		
        for(int i=num1.length()-1; i >= 0; i--) {
        	mul2 = 1; 
        	for(int j=num2.length()-1; j >= 0; j--) {
        		result = result + ((num1.charAt(i) - '0') * mul1 * (num2.charAt(j) - '0') * mul2);
        		mul2 *= 10;
        	}
        	mul1 *= 10;
        }
        return result+"";
    }
	
	public String multiplyBig(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int[] result = new int[m + n];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int pos1 = i + j;
				int pos2 = pos1 + 1;
				int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

				int sum = result[pos2] + product;
				result[pos1] += sum / 10;
				result[pos2] = sum % 10;
			}
		}

		StringBuilder resultStr = new StringBuilder();
		for (int val : result) {
			if (!(resultStr.length() == 0 && val == 0)) {
				resultStr.append(val);
			}
		}

		return resultStr.length() == 0 ? "0" : resultStr.toString();
	}
	
	public static void main(String[] args) {
		MultiplyStrings obj = new MultiplyStrings();
//		System.out.println("Result "+ obj.multiplyBig("123456789", "987654321"));
		System.out.println("Result "+ obj.multiplyBig("582", "192"));
	}
}
