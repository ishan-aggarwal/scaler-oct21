//Q6. Main Diagonal Sum
//Problem Description
//
//You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
//
//Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.
//
//
//
//Problem Constraints
//
//1 <= N <= 103
//
//-1000 <= A[i][j] <= 1000
//
//
//
//Input Format
//
//First and only argument is a 2D integer matrix A.
//
//
//
//Output Format
//
//Return an integer denoting the sum of main diagonal elements.
//
//
//
//Example Input
//
//Input 1:
//
// A = [[1, -2, -3],
//      [-4, 5, -6],
//      [-7, -8, 9]]
//Input 2:
//
// A = [[3, 2],
//      [2, 3]]
//
//
//Example Output
//
//Output 1:
//
// 15 
//Output 2:
//
// 6 
//
//
//Example Explanation
//
//Explanation 1:
//
// A[1][1] + A[2][2] + A[3][3] = 1 + 5 + 9 = 15
//Explanation 2:
//
// A[1][1] + A[2][2] = 3 + 3 = 6

package day13.homework;

import java.util.ArrayList;
import java.util.List;

public class MainDiagonalSum {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int solve(final List<ArrayList<Integer>> A) {

		int diagonalSum = 0;

		int rows = A.size();
		int cols = A.get(0).size();

		int i = 0, j = 0;

		while (i < rows && j < cols) {
			diagonalSum += A.get(i).get(j);
			i++;
			j++;
		}

		return diagonalSum;
	}
}
