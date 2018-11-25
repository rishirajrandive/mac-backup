package com.rishi.arrays;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqK {

	public int maxArrayLengthSize(int[] nums, int k) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int length = nums.length;
		int sum = 0;
		int maxSubLength = 0;
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			if(sum <= k) {
				maxSubLength = Math.max(maxSubLength, i+1);
			}else if(map.containsKey(sum - k)) {
				maxSubLength = Math.max(maxSubLength, i - map.get(sum - k));
			}
			
			if(!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxSubLength;
	}
	
	public int maxArrayLengthSize1(int[] nums, int k) {
		// To store current sum and
        // max sum of subarrays
        int curr_sum = nums[0], start = 0, max_sum = 0;
 
        // To find max_sum less than sum
        for (int i = 1; i < nums.length; i++) {
 
            // If curr_sum becomes greater than
            // sum subtract starting elemetns of array
            while (curr_sum > k && start < i) {
                curr_sum -= nums[start];
                start++;
            }
 
            // Update max_sum if it becomes
            // greater than curr_sum
            max_sum = Math.max(max_sum, curr_sum);
 
            // Add elements to curr_sum
            curr_sum += nums[i];
        }
 
  
        // Adding an extra check for last subarray
        if (curr_sum <= k)
            max_sum =  Math.max(max_sum, curr_sum);
 
        return max_sum;
	}
	
	public static void main(String[] args) {
		MaxSizeSubarraySumEqK obj = new MaxSizeSubarraySumEqK();
//		int nums[] = {3, 1, 2, 1};
//		int k = 4;
		int nums[] = {1, 1, 1};
		int k = 4;
		System.out.println("Result :" + obj.maxArrayLengthSize1(nums, k));
	}
}
