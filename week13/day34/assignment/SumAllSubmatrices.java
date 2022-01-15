package day34.assignment;

//Q1. Sum of all Submatrices

//Problem Description
//
//Given a 2D Matrix A of dimensions N*N, we need to return sum of all possible submatrices.
//
//
//
//Problem Constraints
//
//1 <= N <=30
//
//0 <= A[i][j] <= 10
//
//
//
//Input Format
//
//Single argument representing a 2-D array A of size N x N.
//
//
//
//Output Format
//
//Return an integer denoting the sum of all possible submatrices in the given matrix.
//
//
//
//Example Input
//
//A = [ [1, 1]
//      [1, 1] ]
//
//
//Example Output
//
//16
//
//
//Example Explanation
//
//Number of submatrices with 1 elements = 4, so sum of all such submatrices = 4 * 1 = 4
//Number of submatrices with 2 elements = 4, so sum of all such submatrices = 4 * 2 = 8
//Number of submatrices with 3 elements = 0
//Number of submatrices with 4 elements = 1, so sum of such submatrix = 4
//Total Sum = 4+8+4 = 16

public class SumAllSubmatrices {
	public static int solve(int[][] A) {

		// initialize sum
		int sum = 0;

		// find n as length of matrix
		int n = A.length;

		// use two for loops to iterate over all the elements
		// we will use contribution technique here to find the sum of all sub matrix of
		// a matrix in O(N^2)

		// if we dont use this.. worst case could be O(N^6)
		// and better with prefix sum computed then O(N^4)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				// find the total entries for top left index just like we do in 1D array for sum
				// of all sub arrays
				int tl = (i + 1) * (j + 1);

				// find the total entries for bottom right
				int br = (n - i) * (n - j);

				// finally add it to the sum
				sum += (A[i][j] * tl * br);
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(solve(A));
	}
}
