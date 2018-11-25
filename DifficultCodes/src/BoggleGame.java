

public class BoggleGame {

  //Do DFS, add only words where it matches the chars
  // Whenever u complete the word, pop it
  
  public boolean checkWord(char[][] boggleBoard, String word){
	  int maxRow = boggleBoard.length;
	  int maxCol = boggleBoard[0].length;
	  boolean[][] visited = new boolean[maxRow][maxCol];
    for(int i=0; i<boggleBoard.length; i++){
      for(int j=0; j<boggleBoard[0].length; j++){
        correctDFS(boggleBoard, i, j, new StringBuffer(), visited);
      }
    }
    return false;
  }
  
  public boolean isValidWord(String word){
	  if(word.equalsIgnoreCase("TEES")){
		  return true;
	  }
	  return false;
  }
  
  public void correctDFS(char[][] board, int row, int col, StringBuffer word, boolean[][] visited){
	  visited[row][col] = true;
	  word = word.append(board[row][col]);
	  if(isValidWord(word.toString())){
		  System.out.println("Found");
	  }
	  
	  for (int r=row-1; r<=row+1 && r<board.length; r++){
	      for (int c=col-1; c<=col+1 && c<board[0].length; c++){
	        if (r>=0 && c>=0 && !visited[r][c]){
	        	correctDFS(board, r, c, word, visited);
	        }
	      }
	  }
	  //System.out.println(word);
	  word.setLength(word.length() - 1);
	  //System.out.println(word);
	  visited[row][col] = false;
  }
  
  
  public static void main(String[] args) {
	  BoggleGame obj = new BoggleGame();
      char[][] boggleBoard = {
              {'T', 'E'},
              {'E', 'S'}
          };

      System.out.println(obj.checkWord(boggleBoard, "TESTS"));

      for(int i = 0; i < boggleBoard.length; ++i) {
    	  for(int j = 0; j < boggleBoard[0].length; ++j) {
    		  System.out.printf("%s ", boggleBoard[i][j]);
    	  }
    	  System.out.printf("\n");
      }
  }
}

class Cube{
  public char value;
  public int row;
  public int col;
  
  public Cube(char val, int r, int c){
    value = val;
    row = r;
    col = c;
  }
}
