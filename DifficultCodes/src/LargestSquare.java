import java.util.Arrays;
import java.util.Stack;

// Find largest square with boundary 1
public class LargestSquare {
	
	public void find(int[][] matrix){
		Ones[] rowOnes = new Ones[matrix.length];
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
    	for(int i=0; i<matrix.length; i++){
    		for(int j=0; j<matrix[0].length; j++){
    			if(matrix[i][j] == 1){
    				Ones one = new Ones(i, j, 0);
    				j = getStartOfOnes(matrix, i, j, one);
    				rowOnes[i] = one;
    			}
    		}
    	}
    	int max = 0;
    	for(int j=0; j<matrix[0].length; j++){
    		for(int i=0; i<matrix.length; i++){
    			if(matrix[i][j] == 1 && i == rowOnes[i].row && j == rowOnes[i].col){
    				int r = rowOnes[i].row;
    				int c = rowOnes[i].col;
    				System.out.println("Coordinates "+ r + ", " + c);
    				int l = rowOnes[i].length;
    				int newRow = Math.min((r+l), maxRow) - 1;
    				int newCol = Math.min((c+l), maxCol) - 1;
    				int intMax = 0;
    				for(int count=0; count<rowOnes[i].length; count++){
    					//Top to bottom, bottom to right, bottom right to top right
    					if((r+count) < maxRow && matrix[r+count][c] == 1 && (c+count) < maxCol && matrix[newRow][c+count] == 1 && 
    							(newRow-count) >= 0 && matrix[newRow-count][newCol] == 1){
    						intMax++;
    					}
    				}
    				if(max < intMax){
    					max = intMax;
    				}
    				intMax = 0;
    			}
    		}
    	}
    	System.out.println("Maximum possible is "+ max);
    	
    }
	
	public int getStartOfOnes(int[][] matrix, int row, int col, Ones one){
		int counter = 1;
		int i = 0;
		for(i=col+1; i<matrix[0].length; i++){
			if(matrix[row][i] == 1){
				counter++;
			}else if(one.length < counter){
				one.length = counter;
				if(one.col != (i-counter)){
					one.col = i-counter;
				}
				counter = 0;
			}
		}
		if(one.length < counter){
			one.length = counter;
			if(one.col != (i-counter)){
				one.col = i-counter;
			}
		}
		return matrix[0].length;
	}
	
	public static void main(String[] args) {
		LargestSquare obj = new LargestSquare();
		
		int[][] matrix = {{0, 1, 1, 1, 1},
		                  {1, 0, 1, 0, 1},
						  {1, 0, 1, 1, 1},
						  {1, 0, 1, 1, 1},
						  {1, 1, 0, 0, 1}};
		
		//obj.find(matrix);
		System.out.println("Using second method "+ obj.correctLargestSquare(matrix));
	}
	
	
	public int correctLargestSquare(int[][] m){
		if(m == null|| m.length == 0 || m[0].length == 0){
			
			return -1;
		}
		int[][] leftToRight = new int[m.length][m[0].length];//iterate along columns
		int[][] topToBott = new int[m.length][m[0].length];//iterate along rows
		for(int r = 0; r < m.length; r++){
			if(m[r][0] == 1){
				leftToRight[r][0] = 1;
			}
			
		}
		for(int c = 0; c < m[0].length; c++){
			if(m[0][c] == 1){
				
				topToBott[0][c] = 1;
			}
		}
		for(int c = 1; c < m[0].length; c++){
			for(int r = 0; r < m.length; r++){
				
				if(m[r][c] == 1){
					
					leftToRight[r][c] = leftToRight[r][c - 1] + 1;
				}
			}
			
		}
		for(int r = 1; r < m.length; r++){
			
			for(int c = 0; c < m[0].length; c++){
				
				if(m[r][c] == 1){
					topToBott[r][c] = topToBott[r - 1][c] + 1;
				}
			}
		}
		int max = 1;
		for (int i = m.length-1; i>=0; i--)
	    {
	        for (int j = m[0].length-1; j>=0; j--)
	        {
	            // Find smaller of values in hor[][] and ver[][]
	            // A Square can only be made by taking smaller
	            // value
	            int small = Math.min(leftToRight[i][j], topToBott[i][j]);
	 
	            // At this point, we are sure that there is a right
	            // vertical line and bottom horizontal line of length
	            // at least 'small'.
	 
	            // We found a bigger square if following conditions
	            // are met:
	            // 1)If side of square is greater than max.
	            // 2)There is a left vertical line of length >= 'small'
	            // 3)There is a top horizontal line of length >= 'small'
	            System.out.println(small);
	            while (small > max)
	            {
	                if (topToBott[i][j-small+1] >= small &&
	                    leftToRight[i-small+1][j] >= small)
	                {
	                    max = small;
	                }
	                small--;
	            }
	        }
	    }
		return max;
	}
}

class Ones{
    public int row;
    public int col;
    public int length;
    
    public Ones(int r, int c, int len){
        row = r;
        col = c;
        length = len;
    }
}
