package week28.day74.assignment;

import java.util.ArrayList;
import java.util.Arrays;

//Q2. Sudoku
// https://leetcode.com/problems/sudoku-solver/

//Problem Description
//Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
//
//
//
//A sudoku puzzle,
//
//
//
//and its solution numbers marked in red.
//
//
//
//Problem Constraints
//N = 9
//
//
//Input Format
//First argument is an array of array of characters representing the Sudoku puzzle.
//
//
//Output Format
//Modify the given input to the required answer.
//
//
//Example Input
//Input 1:
//
//A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]
//
//
//Example Output
//Output 1:
//
//[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]
//
//
//Example Explanation
//Explanation 1:
//
//Look at the diagrams given in the question.

public class SudokuSolver {
	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		// start from top, left corner
		solve(a, 0, 0);
	}

	public boolean solve(ArrayList<ArrayList<Character>> a, int col, int row) {
		if (row == 9)
			return true;

		// means try for inserting the right value in case the cell is blank
		if (a.get(row).get(col) == '.') {
			// numbers to try from 1 to 9
			for (int num = 1; num <= 9; num++) {
				char get = (char) (num + '0');

				// check if arrangement is valid
				if (isValid(a, row, col, get)) {

					// set char at the cell position
					a.get(row).set(col, get);

					// if all columns are done for the current row
					// move to the next row
					if (col == 8) {
						boolean ans = solve(a, 0, row + 1);
						if (ans)
							return true;
					} else {

						// move to the next col
						boolean ans = solve(a, col + 1, row);
						if (ans)
							return true;
					}

					// unset char to previous value at the cell position
					a.get(row).set(col, '.');
				}
			}
		} else {
			if (col == 8) {
				boolean ans = solve(a, 0, row + 1);
				if (ans)
					return true;
			} else {
				boolean ans = solve(a, col + 1, row);
				if (ans)
					return true;
			}
		}
		return false;
	}

	public boolean isValid(ArrayList<ArrayList<Character>> arr, int row, int col, char k) {

		// check if current row already contains k
		if (arr.get(row).contains(k))
			return false;

		// check if current col already contains k
		for (int i = 0; i < 9; i++) {
			if (arr.get(i).get(col) == k)
				return false;
		}

		// check if 3*3 matrix already contains k
		int i = (row / 3) * 3;
		int j = (col / 3) * 3;
		for (int p = 0; p < 3; p++) {
			for (int t = 0; t < 3; t++) {
				if (arr.get(p + i).get(t + j) == k)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SudokuSolver sol = new SudokuSolver();
		ArrayList<ArrayList<Character>> a = new ArrayList<>();
		a.add(new ArrayList<>(Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.')));
		a.add(new ArrayList<>(Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.')));
		a.add(new ArrayList<>(Arrays.asList('.', '9', '8', '.', '.', '.', '.', '6', '.')));
		a.add(new ArrayList<>(Arrays.asList('8', '.', '.', '.', '6', '.', '.', '.', '3')));
		a.add(new ArrayList<>(Arrays.asList('4', '.', '.', '8', '.', '3', '.', '.', '1')));
		a.add(new ArrayList<>(Arrays.asList('7', '.', '.', '.', '2', '.', '.', '.', '6')));
		a.add(new ArrayList<>(Arrays.asList('.', '6', '.', '.', '.', '.', '2', '8', '.')));
		a.add(new ArrayList<>(Arrays.asList('.', '.', '.', '4', '1', '9', '.', '.', '5')));
		a.add(new ArrayList<>(Arrays.asList('.', '.', '.', '.', '8', '.', '.', '7', '9')));

		sol.solveSudoku(a);
		System.out.println(a);
	}
}
