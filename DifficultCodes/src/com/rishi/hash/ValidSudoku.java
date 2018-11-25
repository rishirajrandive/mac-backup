package com.rishi.hash;

import java.util.HashSet;

/**
 * Important to note here is set.add() - returns false if the value is already present, else adds it and return true
 * @author rishi
 *
 */
public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {

		// For each row
		for (int i = 0; i < 9; i++) {
			HashSet<Character> test = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !test.add(board[i][j]))
					return false;
			}
		}

		// For each column
		for (int i = 0; i < 9; i++) {
			HashSet<Character> test = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.' && !test.add(board[j][i]))
					return false;
			}
		}

		// For each block of 3x3
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				HashSet<Character> test = new HashSet<>();
				for (int x = 0; x < 9; x++) {
					int row = i*3 + x/3;
					int col = j*3 + x%3;
					if (board[row][col] != '.' && !test.add(board[row][col]))
						return false;
				}
			}
		}
		return true;
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
		System.out.println("Is valid ?" + isValidSudoku(grid));
	}
}
