package com.rishi.arrays;

/**
 * Both the approach are accepted. However the first one is O(n2) and second is O(n).
 * First is easy to understand, second has some weird logic of subtracting the left.
 * @author rishi
 *
 */
public class MinSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int len = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-1; i++){
        	sum = nums[i];
        	len = 0;
        	for(int j=i+1; j<nums.length; j++){
        		if(sum >= s){
        			result = Math.min(result, len+1);
        			break;
        		}
        		
        		sum += nums[j];
        		len++;
        	}
        	if(sum >= s){
    			result = Math.min(result, len+1);
    		}
        }
        if(sum >= s){
			result = Math.min(result, len+1);
		}
        return result == Integer.MAX_VALUE ? 0 : result;
    }
	
	public int minSubArrayBetter(int s, int[] nums){
		 int n = nums.length;
		    int ans = Integer.MAX_VALUE;
		    int left = 0;
		    int sum = 0;
		    for (int i = 0; i < n; i++) {
		        sum += nums[i];
		        while (sum >= s) {
		            ans = Math.min(ans, i + 1 - left);
		            sum -= nums[left++];
		        }
		    }
		    return (ans != Integer.MAX_VALUE) ? ans : 0;
	}
	
	public static void main(String[] args) {
		MinSizeSubarraySum obj = new MinSizeSubarraySum();
//		int s = 7;
//		int nums[] = {2,3,1,2,4,3};
//		int s = 11;
//		int nums[] = {1, 2, 3, 4, 5};
		int s = 3;
		int nums[] = {1, 1};
		
		System.out.println("Result "+ obj.minSubArrayLen(s, nums));
	}
}
