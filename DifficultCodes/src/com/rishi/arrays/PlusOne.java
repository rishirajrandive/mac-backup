package com.rishi.arrays;

/**
 * LeetCode explanation is not that good, so here we need to add 1 to the array, treating it as
 * a number. So if the array is [4, 3, 2], treat it like 432 number and add 1. The result array
 * should be [4, 3, 3]
 * Idea is to:
 * 1. Iterate through the array starting from last index and check if its less than 9
 * 2. If it is add 1 to it and return the array, else put 0 in that index.
 * 3. In case the array has [9], then we create new array with [1, 0] and return
 *   
 * @author rishi
 *
 */
public class PlusOne {
	
	public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
        
            digits[i] = 0;
        }
    
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
    
        return newNumber;
    }
	
	public static void main(String[] args) {
		int[] digits = {4, 3, 9};
		
		int[] result = plusOne(digits);
		System.out.println(Math.abs(Math.abs(-1) - Math.abs(-4)));
		for(int var : result){
			System.out.print(var + " ");
		}
	}
}
