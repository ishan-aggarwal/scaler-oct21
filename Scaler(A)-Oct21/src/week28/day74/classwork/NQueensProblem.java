package week28.day74.classwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Q3. N Queens Problem (Standard Question) - Google/ MS/ FB/ Paypal/ Paytm/ Flipkart
//	  Check if an arrangement of N queens is possible on the N*N board.
//	  Arrange the queens in the board, so that no queen targets any other queen

// https://leetcode.com/problems/n-queens/
// https://leetcode.com/problems/n-queens-ii/

public class NQueensProblem {

	// keep one queen per row:
	// for every ith row
	// find a safe col(slot) for the queen
	// if the safe col exists
	// place the queen
	// else
	// backtrack

	// col against true false
	Map<Integer, Boolean> colMap = new HashMap<>();

	// stores (col - row) against boolean true false
	Map<Integer, Boolean> diagonalMap = new HashMap<>();

	// stores (col + row) against boolean true false
	Map<Integer, Boolean> antiDiagonalMap = new HashMap<>();

	boolean solveNQ() {
		int mat[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (solveNQUtil(mat, mat.length, 0) == false) {
			System.out.println("Solution does not exist");
			return false;
		}

		printSolution(mat);
		return true;
	}

	// here the parameter row changes
	// refers to the running row
	private boolean solveNQUtil(int[][] mat, int n, int row) {
		if (row == n) {
			return true;
		}

		for (int col = 0; col < n; col++) {
			if (isSafe(row, col)) {
				mat[row][col] = 1;
				// also insert the entries in maps
				insertInMaps(row, col);

				if (solveNQUtil(mat, n, row + 1)) {
					return true;
				}
				// reverse the previous decision
				mat[row][col] = 0;
				// also remove the entry from maps
				removeFromMaps(row, col);

			}
		}

		return false;
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

	private void printSolution(int[][] board) {
		for (int[] eachRow : board) {
			System.out.println(Arrays.toString(eachRow));
		}
	}

	// driver program to test
	public static void main(String args[]) {
		NQueensProblem nQueensProblem = new NQueensProblem();
		System.out.println(nQueensProblem.solveNQ());
	}
}