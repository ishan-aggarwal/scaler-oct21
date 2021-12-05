//Q2. Search in a row wise and column wise sorted matrix
//
//Problem Description
//
//Given a matrix of integers A of size N x M and an integer B.
//In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
//If A[i][j] = B then return (i * 1009 + j)
//If B is not present return -1.
//
//Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
//Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
//
//
//Problem Constraints
//
//1 <= N, M <= 1000
//-100000 <= A[i] <= 100000
//-100000 <= B <= 100000
//
//
//Input Format
//
//The first argument given is the integer matrix A.
//The second argument given is the integer B.
//
//
//Output Format
//
//Return the position of B and if it is not present in A return -1 instead.
//
//
//Example Input
//
//A = [ [1, 2, 3]
//          [4, 5, 6]
//          [7, 8, 9] ]
//B = 2
//
//
//Example Output
//
//1011
//
//
//Example Explanation
//
//A[1][2]= 2
//1*1009 + 2 =1011



package day14.assignments;

import java.util.ArrayList;

public class SearchMatrixRowAndColWiseSorted {
	public static int solve(ArrayList<ArrayList<Integer>> A, int B) {

		int rows = A.size();
		int cols = A.get(0).size();

		int i = rows - 1, j = 0;

		int minValue = Integer.MAX_VALUE;

		while (i >= 0 && j < cols) {

			// element is matched at current row and col
			// to minimize the results lets decrease the values
			if (A.get(i).get(j) == B) {
				minValue = Math.min(minValue, (i + 1) * 1009 + (j + 1));
				i--;
			} else if (A.get(i).get(j) < B) { // element is less than B
				// means it has to be on the right column, as all elements of this column will
				// also be less
				j++;
			} else { // element is greater than B
				// means all elements of this row would be greater so lets decrease the row
				i--;
			}
		}

		return minValue;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();

		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(2);
		row1.add(8);
		row1.add(8);

		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(2);
		row2.add(8);
		row2.add(8);

		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(2);
		row3.add(8);
		row3.add(8);

		A.add(row1);
		A.add(row2);
		A.add(row3);

		System.out.println(solve(A, 8));

	}
}
