package com.rishi.arrays;

import java.util.HashMap;

/**
 * Finding indices of numbers which sum to target.
 * Example: nums = [3, 2, 4], target = 6;
 * Result array res = [1, 2] i.e. numbers 2 and 4 add to 6. The input has unique solution.
 * 
 * Steps:
 * 1. Create a hash table with key as difference between target and number in nums of array and value as it's indices.
 * 2. Simultaneously also check if the, the number in nums is present in hash table or not, if yes, then return
 * the index in hash table and current index.
 * 
 *  For this example, we would store in hash table values (3, 0) and (4, 1). In 3 iteration the number in nums is 
 *  4 which is present in hash table, index in hash table and current are our final values. 
 * @author rishi
 *
 */
public class TwoSum {

	public static int[] twoSum(int[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		
		for(int i=0; i<nums.length; i++){
			if(map.containsKey(nums[i])){
				result[0] = map.get(nums[i]);
				result[1] = i;
				break;
			}else{
				map.put(target-nums[i], i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int nums[] = {3, 2, 2, 4};
		int res[] = twoSum(nums, 6);
		
		for(int i=0; i<res.length; i++){
			System.out.print(res[i] + " ");
		}
	}
}
