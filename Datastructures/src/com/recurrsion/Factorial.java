package com.recurrsion;

public class Factorial {

	public long factorial(int n){
		if(n == 0){
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}
	
	public long trailingZeroes(int n) {
		if (n < 0){
			return -1;
		}
		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
	 
		return count;
	}
	
	public static void main(String[] args) {
		Factorial obj = new Factorial();
//		long factorialVal = obj.factorial(12345678);
//		
//		System.out.println("Factorial is "+ factorialVal);
		System.out.println("Trailing zeros is "+ obj.trailingZeroes(12345678));
	}
	
}
