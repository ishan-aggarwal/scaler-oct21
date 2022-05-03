package week28.day74.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/n-queens/

//Q1. NQueens
//Problem Description
//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
//Given an integer A, return all distinct solutions to the n-queens puzzle.
//
//Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
//
//
//Problem Constraints
//1 <= A <= 10
//
//
//
//Input Format
//First argument is an integer n denoting the size of chessboard
//
//
//
//Output Format
//Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
//
//
//
//Example Input
//Input 1:
//
//A = 4
//Input 2:
//
//A = 1
//
//
//Example Output
//Output 1:
//
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Output 1:
//
//[
// [Q]
//]
//
//
//Example Explanation
//Explanation 1:
//
//There exist only two distinct solutions to the 4-queens puzzle:
//Explanation 1:
//
//There exist only one distinct solutions to the 1-queens puzzle:

public class NQueensProblem2 {

	// col against true false
	Map<Integer, Boolean> colMap = new HashMap<>();

	// stores (col - row) against boolean true false
	Map<Integer, Boolean> diagonalMap = new HashMap<>();

	// stores (col + row) against boolean true false
	Map<Integer, Boolean> antiDiagonalMap = new HashMap<>();

	public ArrayList<ArrayList<String>> solveNQueens(int A) {
		ArrayList<ArrayList<String>> allPossibleCombinations = new ArrayList<>();

		// Create n*n board and fill it with dots "."
		char[][] board = new char[A][A];

		for (char[] row : board) {
			Arrays.fill(row, '.');
		}

		// Call recursive function for 0th row
		solveNQueens(board, A, 0, allPossibleCombinations);

//		int rowSize = allPossibleCombinations.size();
//		int columnSize = allPossibleCombinations.get(0).size();
//
//		String[][] ans = new String[rowSize][columnSize];
//
//		for (int i = 0; i < rowSize; i++) {
//			for (int j = 0; j < columnSize; j++) {
//				ans[i][j] = allPossibleCombinations.get(i).get(j);
//			}
//		}

		return allPossibleCombinations;
//		return ans;
	}

	private void solveNQueens(char[][] board, int n, int row, ArrayList<ArrayList<String>> allPossibleCombinations) {
		/*
		 * If all the queens have been placed in current path, put the formatted result
		 * into result list and backtrack.
		 */
		if (row == n) {
			allPossibleCombinations.add(prepareResults(board));
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
				solveNQueens(board, n, row + 1, allPossibleCombinations);

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

	private ArrayList<String> prepareResults(char[][] board) {
		ArrayList<String> resultRows = new ArrayList<>();

		for (char[] row : board) {
			resultRows.add(new String(row));
		}
		return resultRows;
	}

	// driver program to test
	public static void main(String args[]) {
		NQueensProblem2 sol = new NQueensProblem2();
		System.out.println(sol.solveNQueens(4));
	}
}
