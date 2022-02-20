package day47.homework;

//Q2. Matrix Search

//Problem Description
//
//Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integar B in matrix A.
//
//This matrix A has the following properties:
//
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than or equal to the last integer of the previous row.
//Return 1 if B is present in A, else return 0.
//
//NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
//
//
//
//Problem Constraints
//
//1 <= N, M <= 1000
//1 <= A[i][j], B <= 106
//
//
//
//Input Format
//
//The first argument given is the integer matrix A.
//The second argument given is the integer B.
//
//
//
//Output Format
//
//Return 1 if B is present in A, else return 0.
//
//
//
//Example Input
//
//Input 1:
//
//A = [ 
//      [1,   3,  5,  7]
//      [10, 11, 16, 20]
//      [23, 30, 34, 50]  
//    ]
//B = 3
//Input 2:
//
//A = [   
//      [5, 17, 100, 111]
//      [119, 120, 127, 131]    
//    ]
//B = 3
//
//
//Example Output
//
//Output 1:
//
//1
//Output 2:
//
//0
//
//
//Example Explanation
//
//Explanation 1:
//
// 3 is present in the matrix at A[0][1] position so return 1.
//Explanation 2:
//
// 3 is not present in the matrix so return 0.

public class MatrixSearch {

	public static int searchMatrix(int[][] A, int B) {

		int rowIndex = findRowIndex(A, B);
//		System.out.println(rowIndex);
		if (rowIndex == -1) {
			return 0;
		}

		int colIndex = findColIndex(A, B, rowIndex);
//		System.out.println(colIndex);
		if (colIndex == -1) {
			return 0;
		}

		if (A[rowIndex][colIndex] == B) {
			return 1;
		}
		return 0;
	}

	private static int findRowIndex(int[][] a, int b) {
		int rowIndex = -1;
		if (a == null || a.length == 0) {
			return rowIndex;
		}

		int cols = a[0].length;
		int s = 0, e = cols - 1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (a[mid][0] <= b && a[mid][cols - 1] >= b) {
				return mid;
			} else if (a[mid][cols - 1] < b) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return rowIndex;
	}

	private static int findColIndex(int[][] a, int b, int rowIndex) {
		int colIndex = -1;
		int cols = a[0].length;
		int s = 0, e = cols - 1;
		while (s <= e) {
			int mid = s + (e - s) / 2;
			if (a[rowIndex][mid] == b) {
				return mid;
			} else if (a[rowIndex][mid] < b) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return colIndex;
	}

	public static void main(String[] args) {
		int[][] A = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int B = 1;

		System.out.println(searchMatrix(A, B));
	}
}
