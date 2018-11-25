import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestIncreasingPath {
	int M, N;
//	
//    public int longestIncreasingPath(int[][] matrix) {
//        int nVerts = matrix.length;
//        Vertex[] vertex = new Vertex[nVerts*nVerts];
//        
//        for(int i=0; i<matrix.length; i++){
//        	for(int j=0; j<matrix.length; j++){
//        		vertex[i] = new Vertex(matrix[i][j], false);
//        	}
//        }
//        
//        int count = 1;
//        Stack<Integer> theStack = new Stack<>();
//        int index = 0;
//        while(index < vertex.length){
//            int v = getNextVertex(index, vertex, nVerts, matrix);
//            
//            if(v == -1){
//                count--;
//            }else {
//                vertex[v].wasVisited = true;
//            }
//            index++;
//        }
//        
//        return count;
//    }
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0){
        	return 0;
        }
        M = matrix.length; N = matrix[0].length;
        int max = 0;
        int[][] dp = new int[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                max = Math.max(max, dfs(i, j, matrix, dp));
            }
        }
        return max;
    }
    
    private int getNextVertex(int v, Vertex[] vertex, int length, int[][] matrix){
        for(int i=0; i<length; i++){
            //search right and left
            if(matrix[v][i] > vertex[v].val && !vertex[i].wasVisited){
                return i;
            }
        }
        
        for(int i=0; i<length; i++){
            //search top and bottom
            if(matrix[i][v] > vertex[v].val && !vertex[i].wasVisited){
                return i;
            }
        }
        return -1;
    }
    
    private int dfs(int i, int j, int[][] matrix, int[][] dp){
        if(dp[i][j]!=0) return dp[i][j];
        int len = 1;
        if(i-1>=0 && matrix[i-1][j]>matrix[i][j]){
            len = Math.max(len, dfs(i-1, j, matrix, dp)+1);
        }
        if(i+1<M && matrix[i+1][j]>matrix[i][j]){
            len = Math.max(len, dfs(i+1, j, matrix, dp)+1);
        }
        if(j-1>=0 && matrix[i][j-1]>matrix[i][j]){
            len = Math.max(len, dfs(i, j-1, matrix, dp)+1);
        }
        if(j+1<N && matrix[i][j+1]>matrix[i][j]){
            len = Math.max(len, dfs(i, j+1, matrix, dp)+1);
        }
        dp[i][j] = len;
        return len;
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    	
    	for(int j=0; j<matrix.length; j++){ // set adjacency
    		System.out.println("");
			for(int k=0; k<matrix.length; k++){ // matrix to 0
				System.out.print(matrix[j][k] + " ");
			}
    	}
    	
    	LongestIncreasingPath obj = new LongestIncreasingPath();
    	System.out.println("Longest increasing path "+ obj.longestIncreasingPath(matrix));
	}
}

class Vertex{
	int val;
	boolean wasVisited;
	
	public Vertex(int value, boolean flag){
		val = value;
		wasVisited = flag;
	}
}
