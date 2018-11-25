package com.rishi.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Capture all the O surrounded by X
 * Example: Input is:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 
 * Output is:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * Notice the O in last row is not changed because it is not surrounded (checking only four sides not diagonal).
 * 
 * Idea here is to start check at borders, and do bfs around them to mark all the O as some diff char here #
 * This is done for sides
 * Finally we will have X, O (which are not connected to borders or surrounded by X) and #
 * Iterate over the matrix and change the # to O, and O to X
 *  
 * @author rishi
 *
 */
public class SurroundingRegions {

	private static Queue<Integer> queue = new LinkedList<>();
	
	public static void solve(char[][] board) {
        if(board.length == 0 && board[0].length == 0){
        	return;
        }
        
        int rows = board.length;
        int cols = board[0].length;

        // Top row 
        for(int j=0; j<cols; j++){
        	if(board[0][j] == 'O'){
        		bfs(board, 0, j);
        	}
        }
        
     // Bottom row 
        for(int j=0; j<cols; j++){
        	if(board[rows-1][j] == 'O'){
        		bfs(board, rows-1, j);
        	}
        }
        
        // Left column 
        for(int i=0; i<rows; i++){
        	if(board[i][0] == 'O'){
        		bfs(board, i, 0);
        	}
        }
        
        // Right column 
        for(int i=0; i<rows; i++){
        	if(board[i][cols-1] == 'O'){
        		bfs(board, i, cols-1);
        	}
        }
        
        // Interchanging the if conditions may cause issue,
        // So always check for 'O' first and then for #
        for(int i=0; i<rows; i++){
        	for(int j=0; j<cols; j++){
        		if(board[i][j] == 'O'){
        			board[i][j] = 'X';
        		}
        		
        		if(board[i][j] == '#'){
        			board[i][j] = 'O';
        		}
        	}
        }
        System.out.println("Done");
    }
	
	public static void fill(char[][] board, int i, int j){
        int rows = board.length;
		int cols = board[0].length;
		
		if(i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O'){
		    return;
		}
		
		int index = i*cols + j;
		queue.offer(index);
		board[i][j] = '#';
    }
	
	public static void bfs(char[][] board, int i, int j){
		int cols = board[0].length;
		
		fill(board, i, j);
		
		while(!queue.isEmpty()){
			int top = queue.poll();
			int r = top/cols;
			int c = top%cols;
			
		    fill(board, r-1, c);
		    fill(board, r+1, c);
		    fill(board, r, c-1);
		    fill(board, r, c+1);
		}
	}
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'},
						  {'X', 'O', 'O', 'X'},
						  {'X', 'X', 'O', 'X'},
						  {'X', 'O', 'X', 'X'}};
		
		solve(board);
	}

}
