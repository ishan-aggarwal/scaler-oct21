//Q3. Minor Diagonal Sum
// 
//
//https://www.scaler.com/academy/mentee-dashboard/class/13377/homework/problems/11466?navref=cl_tt_nv
//	
//Problem Description
//
//You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
//
//Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).
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
//Return an integer denoting the sum of minor diagonal elements.
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
// -5 
//Output 2:
//
// 4 
//
//
//Example Explanation
//
//Explanation 1:
//
// A[1][3] + A[2][2] + A[3][1] = (-3) + 5 + (-7) = -5
//Explanation 2:
//
// A[1][2] + A[2][1] = 2 + 2 = 4

package day13.homework;

import java.util.ArrayList;
import java.util.List;

public class MatrixMinorDiagonalSum {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int solve(final List<ArrayList<Integer>> A) {

		int minorDiagonalSum = 0;
		int rows = A.size();
		int cols = A.get(0).size();

		int i = 0, j = cols - 1;

		while (i < rows && j >= 0) {
			minorDiagonalSum += A.get(i).get(j);
			i++;
			j--;
		}

		return minorDiagonalSum;
	}
}
