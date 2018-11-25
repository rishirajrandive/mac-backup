package com.rishi.arrays;

import java.util.Arrays;

public class ValidTriangleNumber {

	public int triangleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        
        int cnt = 0;
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-2; i++){
        	int k = i+2;
        	for(int j=i+1; j<nums.length-1 && nums[i] != 0; j++){
        		while(k < nums.length && nums[i] + nums[j] > nums[k]){
        			k++;
        		}
        		cnt += k - j - 1;
        	}
        }
        return cnt;
    }
	
	public static void main(String[] args) {
		ValidTriangleNumber obj = new ValidTriangleNumber();
//		int[] nums = {2, 2, 7, 3, 5, 10, 4};
//		int[] nums = {2, 2, 3, 4};
		int[] nums = {14,67,0,81,92,53,64,6,12,51,51,51,28,50,80,42,96,76,5,71,84,18,75,37,42,41,76,87,19,37,64,73,9,87,27,67,40,43,21,15,86,26,76,4,8,67,28,7,53,47,91,71,58,22,0,31,20,45,98,62,23,12,6,37,78,6,37,67,71,98,82,31,96,14,95,27,21,50,4,25,33,24,23,68,59,65,72,80,35,36,30,15,7,76,84,0,79,54,5,95};
		System.out.println("Result " + obj.triangleNumber(nums));
	}
}
