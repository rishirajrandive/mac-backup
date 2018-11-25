package com.rishi.matrix;

/**
 * This is rotation of matrix. 90 degree clockwise. For anti-clockwise, similar approach just the value
 * copying would be reverse direction.
 * 
 * I think the comments will help me to remember it next time.
 * @author rishi
 *
 */
public class RotateImage {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int x = 0; x < n / 2; x++) {
			for (int y = x; y < n - 1 - x; y++) {
				// Take value of top-left into temp
				int temp = matrix[x][y];

				// copy value of bottom-left to top-left
				matrix[x][y] = matrix[n - 1 - y][x];

				// copy value of bottom-right to bottom-left
				matrix[n - 1 - y][x] = matrix[n - 1 - x][n - 1 - y];

				// copy value of top-right to bottom-left
				matrix[n - 1 - x][n - 1 - y] = matrix[y][n - 1 - x];

				// copy temp to top-right
				matrix[y][n - 1 - x] = temp;
			}
		}
	}
}
