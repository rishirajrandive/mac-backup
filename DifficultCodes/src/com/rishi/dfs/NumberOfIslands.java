package com.rishi.dfs;

import java.util.Stack;

/**
 * DFS is used for searching, the code is self explanatory and idea is also simple.
 * @author rishi
 *
 */
public class NumberOfIslands {

	private boolean visited[][];
    private Stack<Vertex> stack;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        visited = new boolean[grid.length][grid[0].length];
        stack = new Stack<>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        Vertex v = new Vertex(i, j);
        stack.push(v);
        
        while(!stack.isEmpty()){
            Vertex temp = stack.pop();
            int c = temp.j;
            int r = temp.i;
            
            visited[r][c] = true;
            
            if(r+1 < grid.length && !visited[r+1][c] && grid[r+1][c] == '1'){
                stack.push(new Vertex(r+1, c));
                visited[r+1][c] = true;
            }
            if(r-1 >= 0 && !visited[r-1][c] && grid[r-1][c] == '1'){
                stack.push(new Vertex(r-1, c));
                visited[r-1][c] = true;
            }
            if(c+1 < grid[0].length && !visited[r][c+1] && grid[r][c+1] == '1'){
                stack.push(new Vertex(r, c+1));
                visited[r][c+1] = true;
            }
            if(c-1 >= 0 && !visited[r][c-1] && grid[r][c-1] == '1'){
                stack.push(new Vertex(r, c-1));
                visited[r][c-1] = true;
            }
        }
    }
    
    class Vertex{
        int i;
        int j;
        
        public Vertex(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    
    public static void main(String[] args) {
		char grid[][] = {{'1', '1', '1', '1', '0'},
						 {'1', '1', '0', '0', '0'},
						 {'1', '1', '0', '1', '0'},
						 {'0', '0', '0', '1', '0'}};
    	
//    	char[][] grid = {};
		
		NumberOfIslands obj = new NumberOfIslands();
		System.out.println(obj.numIslands(grid));
	}
}
