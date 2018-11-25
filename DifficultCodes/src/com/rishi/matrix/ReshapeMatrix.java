package com.rishi.matrix;

/**
 * Need to reshape the matrix based on the new given rows and columns. 
 * Can also be done by creating another list and again copying back to result matrix.
 * Here idea is to:
 * 1. Check if the reshaping is possible or not, if not return the original array
 * 2. Next, take a counter starting from 0, and iterate over the given array.
 * 3. Your new row will be count/c (given column) and column will be count
 * @author rishi
 *
 */
public class ReshapeMatrix {

	public static int[][] matrixReshape(int[][] nums, int r, int c) {
		int[][] res = new int[r][c];
		if (nums.length == 0 || r * c != nums.length * nums[0].length)
			return nums;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				res[count / c][count % c] = nums[i][j];
				count++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] nums = {{1, 2},
						{3, 4}};
		
		matrixReshape(nums, 1, 4);
	}
}
