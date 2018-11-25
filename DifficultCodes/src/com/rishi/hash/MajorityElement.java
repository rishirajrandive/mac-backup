package com.rishi.hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Need to return the element which is repeated more than n/2 times
 * Assumes that there is always one such number never 0 or more than 1
 * 
 * Iterate over the elements and add it to map if not in map, else update the value
 * 
 * Once done iterate over the keys of map and return the value of map which is greater than threshold return it
 * @author rishi
 *
 */
public class MajorityElement {

	public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        int len = nums.length;
        int threshold = len/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }else {
                map.put(n, 1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key) > threshold){
                return key;
            }
        }
        return -1;
    }
	
	/**
	 * Assuming array is not empty
	 * @param nums
	 * @return
	 */
	public static int dirtySol(int[] nums){
		if(nums.length == 1){
			return 0;
		}
		Arrays.sort(nums);
		return nums[nums.length /2];
		
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,3,4};
		System.out.println("Result "+ majorityElement(nums));
		System.out.println("Result "+ dirtySol(nums));
	}
}
