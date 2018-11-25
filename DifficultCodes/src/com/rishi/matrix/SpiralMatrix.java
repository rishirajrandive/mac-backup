package com.rishi.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Print the matrix in spiral format. 
 * [[ 1, 2, 3 ],
 *	[ 4, 5, 6 ],
 *	[ 7, 8, 9 ]]
 *
 * Above matrix should give output [1,2,3,6,9,8,7,4,5].
 * 
 * Code is simple, just go throug the comments
 * @author rishi
 *
 */
public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		
        if(matrix == null || matrix.length == 0){
        	return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        
        while(m>0 && n>0){
        	//if one row and column is present no spiral
        	if(m == 1){
        		for(int i=0; i<n; i++){
        			result.add(matrix[x][y++]);
        		}
        		break;
        	}
        	
        	if(n == 1){
        		for(int j=0; j<m; j++){
        			result.add(matrix[x++][y]);
        		}
        		break;
        	}
        	
        	// Now if spiral is possible
        	
        	// top to right move
        	for(int i=0; i<n-1; i++){
        		result.add(matrix[x][y++]);
        	}
        	
        	// right to bottom move
        	for(int i=0; i<m-1; i++){
        		result.add(matrix[x++][y]);
        	}
        	
        	// bottom to left move
        	for(int i=0; i<n-1; i++){
        		result.add(matrix[x][y--]);
        	}
        	
        	// left to top move
        	for(int i=0; i<m-1; i++){
        		result.add(matrix[x--][y]);
        	}
        	
        	x++;
        	y++;
        	m -= 2;
        	n -= 2;
        }
        return result;
    }
	
	public static void main(String[] args) {
		SpiralMatrix obj = new SpiralMatrix();
//		int[][] matrix = {{ 1, 2, 3 },
//						  { 4, 5, 6 },
//						  { 7, 8, 9 }};
		int matrix[][] = {{1,2,3,4},
				  		  {14,15,16,5},
				  		  {13,20,17,6},
				  		  {12,19,18,7},
				  		  {11,10,9,8}};
		List<Integer> result = obj.spiralOrder(matrix);
		for(int i=0; i<result.size(); i++){
			System.out.print(result.get(i) + " ");
		}
	}
}
