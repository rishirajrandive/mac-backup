package com.rishi.arrays;

/**
 * This is basically a Dutch flag problem. Where we will be given 3 different kind of colors
 * and we need to sort them or group them together in a sorted way.
 * Idea is to:
 * 1. Have 3 pointers: low=0, mid=0, and high=length-1;
 * 2. Do the following till mid <= high
 * 		a. If the value at mid in nums is, 0, swap values at low and mid and increment both
 * 		b. If the value at mid in nums is 1, just increment mid.
 * 		c. If the value at high in nums is 2, swap values at mid and high, and decrement high.
 * 3. When the loop is complete we will have a sorted and grouped array.
 * @author rishi
 *
 */
public class SortColors {

	public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int temp = 0;
        
        while(mid <= high) {
            switch(nums[mid]) {
                case 0:
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
            }
        }
    }
	
	public static void main(String[] args) {
		int[] nums = {1,01,2,0,0,1,1,2};
		SortColors obj = new SortColors();
		obj.sortColors(nums);
		
		System.out.print("Result: ");
		for(int i : nums) {
			System.out.print(i + ",");
		}
	}
}
