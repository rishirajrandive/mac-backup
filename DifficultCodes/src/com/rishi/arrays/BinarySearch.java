package com.rishi.arrays;

public class BinarySearch {

	private static boolean binarySearch(int[] arr, int x) {
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(arr[mid] == x) {
				return true;
			}
			if(arr[mid] < x) {
				left = mid + 1;
			}
			if(arr[mid] > x) {
				right = mid - 1;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 6, 7, 10, 21, 31};
		
		System.out.println("Result "+ binarySearch(arr, 1));
	}
}
