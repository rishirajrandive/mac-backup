package com.rishi.sort;

import java.util.Arrays;

/**
 * Find first positive missing integer in the series. That means the numbers must be consecutive starting with 1.
 * Example: 1, 2, 0 - Missing number is 3
 * Methods:
 * 1. Use in build java sort and check for numbers in O(n) + O(nLog(n)) because of sorting
 * 2. Sort it and then check it for nums
 * 		2.1. Sorting would be done by checking if the number is at position num-1 in the array, if not swap.
 * @author rishi
 *
 */
public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
        	return -1;
        
        for(int i=0; i<nums.length; i++){
        	if(nums[i] <= nums.length && nums[i] > 0 && nums[nums[i]-1] != nums[i]){
        		int temp = nums[nums[i]-1];
        		nums[nums[i]-1] = nums[i];
        		nums[i] = temp;
        		i--;
        	}
        }
        int n=1;
        for(int i=0; i<nums.length; i++){
        	if(nums[i] == n)
        		n++;
        }
        
        return n;
    }
	
	public static void main(String[] args) {
		int[] n = {3, 4, -1, 1};
		//int[] n = {1, 2, 0};
		System.out.println("Result "+ firstMissingPositive(n));
	}
}
