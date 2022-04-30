package week28.day74.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/n-queens-ii/

public class NQueensProblem3 {

	// col against true false
	Map<Integer, Boolean> colMap = new HashMap<>();

	// stores (col - row) against boolean true false
	Map<Integer, Boolean> diagonalMap = new HashMap<>();

	// stores (col + row) against boolean true false
	Map<Integer, Boolean> antiDiagonalMap = new HashMap<>();

	int answer = 0;

	public int totalNQueens(int n) {

		// Create n*n board and fill it with dots "."
		char[][] board = new char[n][n];

		for (char[] row : board) {
			Arrays.fill(row, '.');
		}

		// Call recursive function for 0th row
		solveNQueens(board, n, 0);

		return answer;
	}

	private void solveNQueens(char[][] board, int n, int row) {
		/*
		 * If all the queens have been placed in current path, put the formatted result
		 * into result list and backtrack.
		 */
		if (row == n) {
			answer++;
			return;
		}

		/* Try to place the queen in each column of the current row */
		for (int col = 0; col < n; col++) {

			// Check current queen is safe at current column in the row
			if (isSafe(row, col)) {

				// Place the queen at current column
				board[row][col] = 'Q';
				// add entry to maps
				insertInMaps(row, col);

				// Try to place the next queen in the row
				solveNQueens(board, n, row + 1);

				/*
				 * Remove the queen after the current combination has been tried
				 */
				board[row][col] = '.';
				// remove entry from maps
				removeFromMaps(row, col);
			}
		}
	}

	private void removeFromMaps(int row, int col) {
		colMap.remove(col);
		diagonalMap.remove(col - row);
		antiDiagonalMap.remove(col + row);
	}

	private void insertInMaps(int row, int col) {
		colMap.put(col, true);
		diagonalMap.put(col - row, true);
		antiDiagonalMap.put(col + row, true);
	}

	private boolean isSafe(int row, int col) {
		// returns true if no queen is present in this current col
		// and diagonal and anti-diagonal

		// check for col
		if (colMap.containsKey(col) && colMap.get(col) == true) {
			return false;
		}

		// check for diagonal
		if (diagonalMap.containsKey(col - row) && diagonalMap.get(col - row) == true) {
			return false;
		}

		// check for anti diagonal
		if (antiDiagonalMap.containsKey(col + row) && antiDiagonalMap.get(col + row) == true) {
			return false;
		}

		return true;
	}

	// driver program to test
	public static void main(String args[]) {
		NQueensProblem3 sol = new NQueensProblem3();
		System.out.println(sol.totalNQueens(4));
	}
}
