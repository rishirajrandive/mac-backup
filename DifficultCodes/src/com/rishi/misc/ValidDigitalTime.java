package com.rishi.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Program is to return the maximum possible digital time in 24-hours format.
 * Example: Input is 1, 8, 3, 2. Output should be 23:18
 * If time is not possible return NOT POSSIBLE.
 * @author rishi
 *
 */
public class ValidDigitalTime {

	public static String solution(int A, int B, int C, int D) {
		// write your code in Java SE 8
		List<Integer> arr = new ArrayList<>();
		arr.add(A);
		arr.add(B);
		arr.add(C);
		arr.add(D);

		int firstDigit = findDigit(arr, 2);
		int secondDigit = findDigit(arr, 4);
		int thirdDigit = findDigit(arr, 5);
		int fourthDigit = findDigit(arr, 9);

		if (firstDigit != -1 && secondDigit != -1 && thirdDigit != -1 && fourthDigit != -1) {
			return firstDigit+"" + secondDigit + ":" + thirdDigit + fourthDigit;
		}
		return "NOT POSSIBLE";

	}
	
	public static int findDigit(List<Integer> arr, int limit){
		int digit = -1;
		int index = -1;
		
		for (int i = 0; i < arr.size(); i++) {
			if (digit <= arr.get(i) && arr.get(i) <= limit) {
				digit = arr.get(i);
				index = i;
			}
		}
		if(index != -1){
			arr.remove(index);
		}
		return digit;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(9, 1, 9, 7));
	}
}
