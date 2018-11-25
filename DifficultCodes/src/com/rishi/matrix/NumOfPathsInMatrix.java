package com.rishi.matrix;

public class NumOfPathsInMatrix {

	private int numberOfPaths(int[][] a)
    {
		int rows = a.length;
		int cols = a[0].length;
        int count[][] = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];
  
        for (int i = 0; i < rows; i++)
            count[i][0] = 1;
  
        for (int j = 0; j < cols; j++)
            count[0][j] = 1;
  
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
            	count[i][j] = count[i-1][j] + count[i][j-1];
            }
        }
        return count[rows-1][cols-1];
    }
	
	private int recNumOfPaths(int[][] a, int i,  int j) {
		int m = a.length;
		int n = a[0].length;
		if(i==m-1 && j==n-1)
            return a[i][j];
        else if (i==m-1)
            return a[i][j+1];
        else if (j==n-1)
            return a[i+1][j];
        else if(a[i][j]==1)
            return recNumOfPaths(a,i+1,j) + recNumOfPaths(a,i,j+1);
        else
            return 0;
		
		
	}
	
//	private int rec(int[][] a, int i, int j) {
//		
//	}
	
	public static void main(String[] args) {
		int[][] a = {{1, 1, 1, 1},
					 {1, 1, 1, 1},
					 {1, 1, 1, 1}};
//		int[][] a = {{1, 1},
//					 {0, 1}};
		
		NumOfPathsInMatrix obj = new NumOfPathsInMatrix();
		System.out.println(obj.numberOfPaths(a));
//		System.out.println(obj.recNumOfPaths(a, 0, 0));
	}
}
