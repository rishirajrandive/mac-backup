package com.rishi.arrays;

/**
 * Finds out the next lexicographically greater permutation of numbers
 * 1. First find out the number from right where the lexicographic series breaks, i.e. the number such that
 * nums[i] > nums[i-1]. Ex: 1, 2, 3, 5, 4 - In this case the series breaks at nums[i] = 5 and nums[i-1] = 3
 * 2. Find number from right such that it is greater than nums[i-1]. So in our example it would be nums[j] = 4
 * 3. Swap these numbers, series becomes = 1, 2, 4, 5, 3
 * 3. Reverse the numbers from nums[i], finally it becomes = 1, 2, 4, 3, 5
 * @author rishi
 */

public class NextPermutation {

	public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i+1] <= nums[i]){
            i--;
        }
        
        if(i >= 0){
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]){
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int start = i+1;
        int end = nums.length - 1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
	
	public static void main(String[] args) {
		int nums[] = {1, 1};
		NextPermutation obj = new NextPermutation();
		obj.nextPermutation(nums);
	}
}
