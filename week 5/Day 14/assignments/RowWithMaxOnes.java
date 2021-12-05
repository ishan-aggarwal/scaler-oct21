//Q4. Row with maximum number of ones
//Problem Description
//
//Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
//
//NOTE:
//
//If two rows have the maximum number of 1 then return the row which has a lower index.
//Rows are numbered from top to bottom and columns are numbered from left to right.
//Assume 0-based indexing.
//Assume each row to be sorted by values.
//Expected time complexity is O(rows).
//
//
//Problem Constraints
//
//1 <= N <= 1000
//
//0 <= A[i] <= 1
//
//
//
//Input Format
//
//The only argument given is the integer matrix A.
//
//
//
//Output Format
//
//Return the row with the maximum number of 1.
//
//
//
//Example Input
//
//Input 1:
//
// A = [   [0, 1, 1]
//         [0, 0, 1]
//         [0, 1, 1]   ]
//Input 2:
//
// A = [   [0, 0, 0, 0]
//         [0, 1, 1, 1]    ]
//
//
//Example Output
//
//Output 1:
//
// 0
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
// Row 0 has maximum number of 1s.
//Explanation 2:
//
// Row 1 has maximum number of 1s.

package day14.assignments;

import java.util.ArrayList;

public class RowWithMaxOnes {
	public static int solve(ArrayList<ArrayList<Integer>> A) {

		int rows = A.size();
		int cols = A.get(0).size();

		int i = 0, j = cols - 1;
		int ans = -1;
		while (i < rows && j >= 0) {

			if (A.get(i).get(j) == 1) {
				j--;
				ans = (i + 1);
			} else {
				i++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();

		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(0);
		row1.add(1);
		row1.add(1);

		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(0);
		row2.add(0);
		row2.add(1);

		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(0);
		row3.add(1);
		row3.add(1);

		A.add(row1);
		A.add(row2);
		A.add(row3);

		System.out.println(solve(A));

	}
}
