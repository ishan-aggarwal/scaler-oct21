//Q5. Row to Column Zero
//Problem Description
//
//You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.
//
//
//
//Problem Constraints
//
//1 <= A.size() <= 103
//
//1 <= A[i].size() <= 103
//
//0 <= A[i][j] <= 103
//
//
//
//Input Format
//
//First argument is a vector of vector of integers.(2D matrix).
//
//
//
//Output Format
//
//Return a vector of vector after doing required operations.
//
//
//
//Example Input
//
//Input 1:
//
//[1,2,3,4]
//[5,6,7,0]
//[9,2,0,4]
//
//
//Example Output
//
//Output 1:
//
//[1,2,0,0]
//[0,0,0,0]
//[0,0,0,0]
//
//
//Example Explanation
//
//Explanation 1:
//
//A[2][4] = A[3][3] = 0, so make 2nd row, 3rd row, 3rd column and 4th column zero.

package day13.homework;

public class MatrixRowToColumnZero_VImportant {
	public int[][] solve(int[][] A) {

		int rows = A.length;
		int cols = A[0].length;

		boolean firstCol = false;

		for (int i = 0; i < rows; i++) {

			if (A[i][0] == 0) {
				firstCol = true;
			}

			for (int j = 1; j < cols; j++) {
				if (A[i][j] == 0) {
					A[i][0] = 0;
					A[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				if (A[i][0] == 0 || A[0][j] == 0) {
					A[i][j] = 0;
				}
			}
		}

		if (A[0][0] == 0) {
			for (int j = 0; j < cols; j++) {
				A[0][j] = 0;
			}
		}

		if (firstCol) {
			for (int i = 0; i < rows; i++) {
				A[i][0] = 0;
			}
		}

		return A;

	}
}
