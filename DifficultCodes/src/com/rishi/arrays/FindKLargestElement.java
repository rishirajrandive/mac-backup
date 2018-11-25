package com.rishi.arrays;

import java.util.Arrays;
import java.util.Collections;

public class FindKLargestElement {
	
	private static void findKLargest(Integer[] arr, int k) {
		if(arr == null || arr.length == 0) {
			System.out.println("No values in arr");
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0; i<k; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		Integer[] arr = {1, 23, 12, 9, 30, 2, 50};
		
		findKLargest(arr, 3);
	}
}
