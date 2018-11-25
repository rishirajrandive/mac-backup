import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ClosestGate {
	public void closestGate(char[][] matrix){
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == 'G'){
					//Do dfs
					bfs(matrix, i, j);
					
				}
			}
		}
	}
	
	public void dfs(char[][] givenMatrix, int rowIndex, int colIndex){
		Stack<MazeVertex> stack = new Stack<>();
		MazeVertex vertex = new MazeVertex(rowIndex, colIndex, 0);
		stack.push(vertex);
		int maxRow = givenMatrix.length;
		int maxCol = givenMatrix[0].length;
		boolean[][] visited = new boolean[maxRow][maxCol];
		
		while(!stack.isEmpty()){
			MazeVertex node = stack.pop();
			int row = node.row;
			int col = node.col;
			visited[row][col] = true;
			
			if(row > 0 && visited[row-1][col] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row-1, col, node);
				if(topNode != null){
					stack.push(topNode);
				}
			}
			
			if((row+1) < maxRow && visited[row+1][col] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row+1, col, node);
				if(topNode != null){
					stack.push(topNode);
				}
			}
			
			if(col > 0 && visited[row][col-1] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row, col-1, node);
				if(topNode != null){
					stack.push(topNode);
				}
			}
			
			if((col+1) < maxCol && visited[row][col+1] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row, col+1, node);
				if(topNode != null){
					stack.push(topNode);
				}
			}
		}
	}
	
	public void bfs(char[][] givenMatrix, int rowIndex, int colIndex){
		Queue<MazeVertex> queue = new LinkedList<>();
		MazeVertex vertex = new MazeVertex(rowIndex, colIndex, 0);
		queue.add(vertex);
		int maxRow = givenMatrix.length;
		int maxCol = givenMatrix[0].length;
		 boolean[][] visited = new boolean[maxRow][maxCol];
		
		while(!queue.isEmpty()){
			MazeVertex node = queue.remove();
			int row = node.row;
			int col = node.col;
			visited[row][col] = true;
			
			if((row+1) < maxRow && visited[row+1][col] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row+1, col, node);
				if(topNode != null){
					queue.add(topNode);
				}
			}
			if(row > 0 && visited[row-1][col] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row-1, col, node);
				if(topNode != null){
					queue.add(topNode);
				}
			}
			if(col > 0 && visited[row][col-1] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row, col-1, node);
				if(topNode != null){
					queue.add(topNode);
				}
			}
			if((col+1) < maxCol && visited[row][col+1] == false){
				MazeVertex topNode = getExistingDepth(givenMatrix, row, col+1, node);
				if(topNode != null){
					queue.add(topNode);
				}
			}
			
		}
		
	}
	
	public MazeVertex getExistingDepth(char[][] matrix, int row, int col, MazeVertex node){
		if(matrix[row][col] == 'G' || matrix[row][col] == 'W'){
			return null;
		}
		
		if(matrix[row][col] == '_'){
			matrix[row][col] = (char)('0' + node.depth + 1);
			return new MazeVertex(row, col, node.depth + 1);
		}
		
		int updateDepth = Math.min(matrix[row][col] - '0', node.depth + 1);
		matrix[row][col] = (char) ('0' + updateDepth);
		
		return new MazeVertex(row, col, updateDepth);
	}
	
	 public static void main(String[] args) {
	        ClosestGate s = new ClosestGate();

	        char[][] maze = {
	                            {'_', 'W', 'G', '_', '_'},
	                            {'_', '_', '_', 'W', '_'},
	                            {'_', 'W', '_', 'W', 'W'},
	                            {'G', 'W', '_', '_', '_'}
	                        };

	        s.closestGate(maze);

	        for(int i = 0; i < maze.length; ++i) {
	            for(int j = 0; j < maze[0].length; ++j) {
	                System.out.printf("%s ", maze[i][j]);
	            }
	            System.out.printf("\n");
	        }

	    }
}

class MazeVertex{
	public boolean wasVisited;
	public int row;
	public int col;
	public int depth;
	
	public MazeVertex(int r, int c, int d) {
		row = r;
		col = c;
		depth = d;
	}
}
