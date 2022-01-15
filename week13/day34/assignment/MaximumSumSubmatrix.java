package day34.assignment;

//Q3. Maximum Sum Square SubMatrix

//Problem Description
//
//Given a 2D integer matrix A of size N x N find a B x B submatrix where B<= N and B>= 1, such that sum of all the elements in submatrix is maximum.
//
//
//
//Problem Constraints
//
//1 <= N <= 103.
//
//1 <= B <= N
//
//-102 <= A[i][j] <= 102.
//
//
//
//Input Format
//
//First arguement is an 2D integer matrix A.
//
//Second argument is an integer B.
//
//
//
//Output Format
//
//Return a single integer denoting the maximum sum of submatrix of size B x B.
//
//
//
//Example Input
//
//Input 1:
//
// A = [
//        [1, 1, 1, 1, 1]
//        [2, 2, 2, 2, 2]
//        [3, 8, 6, 7, 3]
//        [4, 4, 4, 4, 4]
//        [5, 5, 5, 5, 5]
//     ]
// B = 3
//Input 2:
//
// A = [
//        [2, 2]
//        [2, 2]
//    ]
// B = 2
//
//
//Example Output
//
//Output 1:
//
// 48
//Output 2:
//
// 8
//
//
//Example Explanation
//
//Explanation 1:
//
//    Maximum sum 3 x 3 matrix is
//    8 6 7
//    4 4 4
//    5 5 5
//    Sum = 48
//Explanation 2:
//
// Maximum sum 2 x 2 matrix is
//  2 2
//  2 2
//  Sum = 8

public class MaximumSumSubmatrix {
	public static int solve(int[][] A, int B) {

		int rows = A.length;
		int cols = A[0].length;
		int[] colSum = null;
		int maxSum = Integer.MIN_VALUE;

		for (int sRow = 0; sRow <= rows - B; sRow++) {
			int eRow = sRow + B - 1;
			colSum = new int[cols];
			for (int j = 0; j < cols; j++) {
				for (int i = sRow; i <= eRow; i++) {
					colSum[j] += A[i][j];
				}
			}

			int currentSum = 0;
			for (int i = 0; i < B; i++) {
				currentSum += colSum[i];
			}
			maxSum = Math.max(currentSum, maxSum);

			for (int i = B; i < colSum.length; i++) {
				currentSum += colSum[i];
				currentSum -= colSum[i - B];
				maxSum = Math.max(maxSum, currentSum);
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 8, 6, 7, 3 }, { 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 } };
		int B = 3;

		System.out.println(solve(A, B));

	}
}
