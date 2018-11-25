package com.rishi.arrays;

/**
 * For an sorted array, remove all the duplicates and only return the length with all unique values, 
 * arrange the values in nums such that the length will give only unique values.
 * 
 * Example: For input [1, 2, 2, 2, 3, 3, 4] the output should be [1, 2, 3, 4]
 * Steps:
 * 1. Initialize curr = 0 and prev = 0;
 * 2. Loop over nums length
 * 3. Check if nums[curr] = nums[prev], if yes, then increment curr
 * 4. Else increment prev, replace element at prev with element at curr, and increment curr
 * 5. Return prev+1;
 * 
 * @author rishi
 *
 */
public class RemoveDuplicate {

	public static int removeDuplicates(int[] nums) {
        int curr = 0;
        int prev = 0;
        
        while(curr < nums.length){
        	if(nums[curr] == nums[prev]){
        		curr++;
        	}else {
        		prev++;
        		nums[prev] = nums[curr];
        		curr++;
        	}
        }
        return prev+1;
    }
	
	public static void main(String[] args) {
		int nums[] = {1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3};
		int n = removeDuplicates(nums);
		
		System.out.println("New Length "+ n);
		for(int i=0; i<n; i++){
			System.out.print(nums[i] + " ");
		}
	}
}
