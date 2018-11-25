package com.rishi.hash;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Need to find the longest sequence of consecutive numbers.
 * Approach #1:
 * 1. Sort the array first
 * 2. Start checking if current element in array + 1 = next element, if yes increment count
 * 3. Elements could be same, so check for that as well, and skip (do nothing)
 * 4. If not equal or consecutive, chain is broken, update the max
 * 
 * Approach #2
 * 1. Create a hashset with all the numbers
 * 2. Iterate over the nums and create left, right and count
 * 3. Continue till set contains left and increment count
 * 4. Same for right
 * 5. Update max
 * @author rishi
 *
 */
public class LongestConsecutiveSeq {

	public static int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);

		int count = 0;
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i+1 < nums.length && nums[i] + 1 == nums[i + 1]) {
				count++;
			} else if(i+1 < nums.length && nums[i] == nums[i + 1]){
				continue;
			}else {
				max = Math.max(max, count + 1);
				count = 0;
			}
		}
		return max;
	}
	
	public static int betterApproach(int[] nums){
		HashSet<Integer> set = new HashSet<>();
		int max = 0;
		for(int n : nums){
			set.add(n);
		}
		
		for(int n : nums){
			int left = n - 1;
			int right = n + 1;
			int count = 1;
			
			while(set.contains(left)){
				count++;
				set.remove(left);
				left--;
			}
			
			while(set.contains(right)){
				count++;
				set.remove(right);
				right++;
			}
			
			max = Math.max(max, count);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {8, 1, 2, 3, 10, 11, 12, 13, 14, 19, 20};
//		int[] nums = {0};
//		int[] nums = {1, 2};
//		int[] nums = {100, 1, 200, 3, 2, 4};
//		int[] nums = {1,2,0,1};
		System.out.println("Result "+ betterApproach(nums));
	}
}
