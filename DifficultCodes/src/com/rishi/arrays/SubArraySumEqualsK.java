package com.rishi.arrays;

import java.util.HashMap;

/**
 * Question is to find the sub arrays in the given array which sum equal to k.
 * Idea is to:
 * 1. Create a map which keep the sum as key and the number of times the sum appears as value.
 * 2. Put initial value with sum 0 and value 1.
 * 3. Iterate over the array and find new sum
 * 4. Check if (sum - k) is present in map. (i.e. if sum is equal to k then (sum-k) is 0 which is always
 * 		present as we added it initially.
 * 5. If (sum-k) = 0 we increment the count
 * 6. Also, while iterating we put each sum in map with value either 0 (default) or incrementing current.
 * @author rishi
 *
 */
public class SubArraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2};
		int k = 2;
		SubArraySumEqualsK obj = new SubArraySumEqualsK();
		System.out.println("Result: "+ obj.subarraySum(nums, k));
		
		
		
		int[] A = {4, 5, 6, 7, 0, 1, 2};
		int target = 2;
		int result = -1;
		int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target){
	        	result = mid;
	        }
	        
	        if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    if(A[lo] == target) {
	    	result = lo;
	    }
	    
	    System.out.println("Found "+ result);
	}
}
