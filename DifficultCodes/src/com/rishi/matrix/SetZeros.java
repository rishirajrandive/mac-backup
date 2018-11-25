package com.rishi.matrix;

/**
 * In a mxn matrix in case any element is 0, make all it's columns and rows as 0. 
 *
 * Solution would be to first check if 0th column and row has any 0, if it has mark the boolean as true.
 * Then start from index 1 and check the matrix for 0, if yes then make the elements it [i][0] = 0 and [0][j] = 0
 * Then loop over matrix again to see if [i][0] == 0 || [0][j] == 0, if yes then make [i][j] = 0
 * Finally check the row or col boolean set earlier are true if yes then again loop over rows and columns to set them 0 
 * @author rishi
 *
 */
public class SetZeros {
		
	public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(m == 0 || n == 0){
            return;
        }
        
        if(m == 1 && n == 1){
            return;
        }
        
        boolean row = false;
        boolean col = false;
        for(int i=0; i<n; i++){
        	if(matrix[0][i] == 0){
        		row = true;
        	}
        }
        
        for(int j=0; j<m; j++){
        	if(matrix[j][0] == 0){
        		col = true;
        	}
        }
        
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        		if(matrix[i][j] == 0){
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        
        for(int i=1; i<m; i++){
        	for(int j=1; j<n; j++){
        		if(matrix[0][j] == 0 || matrix[i][0] == 0){
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if(row){
        	 for(int i=0; i<n; i++){
        		 matrix[0][i] = 0;
             }
        }
        
        if(col){
        	for(int j=0; j<m; j++){
            	matrix[j][0] = 0;
        	}
        }
        print(matrix);
    }
	
	
	
	public static void main(String[] args) {
		int matrix[][] = {{0,0,0,5},
						  {4,3,1,4},
						  {0,1,1,4},
						  {1,2,1,3},
						  {0,0,1,1}};
//		int matrix[][] = {{1, 1, 2, 0},
//				          {4, 5, 6 ,7},
//				          {0, 8, 9, 4}};
		SetZeros onj = new SetZeros();
		
		onj.setZeroes(matrix);
		
	}
	
	public void print(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
