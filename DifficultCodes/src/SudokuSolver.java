
public class SudokuSolver {

	public boolean solveSudoku(char[][] grid){
		int row = 0;
		int col = 0;
		int[] l = {0, 0};
		if(!findBlank(grid, l)){
			return true;
		}
		
		row = l[0];
		col = l[1];
		for(int num=1; num<=9; num++){
			if(isSafe(grid, row, col, num)){
				grid[row][col] = (char)(num + '0');
				
				if(solveSudoku(grid)){
					return true;
				}
				grid[row][col] = '.';
			}
		}
		
		return false;
	}
	
	public boolean findBlank(char[][] grid, int[] l){
		int row = l[0];
		int col = l[1];
		for(row=0; row<grid.length; row++){
			for(col=0; col<grid[0].length; col++){
				if(grid[row][col] == '.'){
					l[0] = row;
					l[1] = col;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isSafe(char[][] grid, int row, int col, int num){
		return !usedInRow(grid, row, num) && !usedInCol(grid, col, num) && 
				!usedInBlock(grid, row-row%3, col-col%3, num);
	}
	
	public boolean usedInRow(char[][] grid, int row, int num){
		for(int col=0; col<grid.length; col++){
			if(grid[row][col] == (char)(num + '0')){
				return true;
			}
		}
		return false;
	}
	
	public boolean usedInCol(char[][] grid, int col, int num){
		for(int row=0; row<grid.length; row++){
			if(grid[row][col] == (char)(num + '0')){
				return true;
			}
		}
		return false;
	}
	
	public boolean usedInBlock(char[][] grid, int blockStartRow, int blockStartCol, int num){
		for(int row=0; row<3; row++){
			for(int col=0; col<3; col++){
				if(grid[row+blockStartRow][blockStartCol] == (char)(num + '0')){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] grid = { {'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		SudokuSolver obj = new SudokuSolver();
		System.out.println("Solved ?" + obj.solveSudoku(grid));
		
		System.out.println("Given sudoku looks like:");
		System.out.println("");
		for(int i=0; i<9; i++){
			System.out.print("    {");
			for(int j=0; j<9; j++){
				System.out.print("'" + grid[i][j] + "',");
			}
			System.out.print("}");
			System.out.println("");
		}
	}
}
