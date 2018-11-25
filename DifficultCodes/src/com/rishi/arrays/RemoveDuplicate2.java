package com.rishi.arrays;

/**
 * Example: For input [1, 1, 1, 1, 2, 2, 2, 3, 3, 4] the function should return only elements repeated at max
 * 2 times. The result would be [1, 1, 2, 2, 3, 3, 4]. This is for sorted array
 * 
 * Steps:
 * 1. For array length greater than 3, initialize curr = 2 and prev = 1
 * 2. Check element at curr and prev if they are same also elements at prev and prev-1
 * 3. If same increment just curr
 * 4. Increment prev, copy element at curr to prev and finally increment curr
 * 5. Repeat this till we reach end of the array
 * 6. Return prev+1
 * 
 * @author rishi
 *
 */
public class RemoveDuplicate2 {

	public static int removeDuplicates(int[] nums) {
        if(nums.length < 3){
        	return nums.length;
        }
        
        int curr = 2;
        int prev = 1;
        
        while(curr < nums.length){
        	if(nums[curr] == nums[prev] && nums[prev] == nums[prev-1]){
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
		int nums[] = {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
		int n = removeDuplicates(nums);
		
		System.out.println("New Length "+ n);
		for(int i=0; i<n; i++){
			System.out.print(nums[i] + " ");
		}
	}
}
