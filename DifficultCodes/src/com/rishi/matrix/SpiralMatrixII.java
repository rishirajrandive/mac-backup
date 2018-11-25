package com.rishi.matrix;

/**
 * Here we are given the value of n and we need to fill nxn matrix in spiral form.
 * @author rishi
 *
 */
public class SpiralMatrixII {

	public static int[][] generateMatrix(int n) {
		if(n<0){
			return null;
		}
		
		int[][] result = new int[n][n];
		int circle = n/2;
		int num = 1;
		
		for(int i=0; i<circle; i++){
			// Move right
			for(int j=i; j<n-1-i; j++){
				result[i][j] = num++;
			}
			
			// Move down with same column
			for(int j=i; j<n-1-i; j++){
				result[j][n-1-i] = num++;
			}
			
			// Move left with same row
			for(int j=i; j<n-1-i; j++){
				result[n-1-i][n-1-j] = num++;
			}
			
			// Move up with same column
			for(int j=i; j<n-1-i; j++){
				result[n-1-j][i] = num++;
			}
		}
		if(n%2 == 1)
			result[circle][circle] = num++;
		return result;
    }
	
	public static void main(String[] args) {
		int[][] result = generateMatrix(3);
		for(int i=0; i<result.length; i++){
			for(int j=0; j<result[0].length; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
