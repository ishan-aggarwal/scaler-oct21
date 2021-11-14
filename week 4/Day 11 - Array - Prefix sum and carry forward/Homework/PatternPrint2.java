//Q1. Pattern Printing -2
//
//Problem Description
//
//Print a Pattern According to The Given Value of A.
//
//Example: For A = 3 pattern looks like:
//
//    1
//  2 1
//3 2 1
//
//
//Problem Constraints
//
//1 <= A <= 1000
//
//
//Input Format
//
//First and only argument is an integer denoting A.
//
//
//
//Output Format
//
//Return a two-dimensional array where each row in the returned array represents a row in the pattern.
//
//
//
//Example Input
//
//Input 1:
//
// A = 3
//Input 2:
//
// A = 4
//
//
//Example Output
//
//Output :1
//
// [ 
//   [0, 0, 1]
//   [0, 2, 1]
//   [3, 2, 1]
// ]
//Output 2:
//
// [ 
//   [0, 0, 0, 1]
//   [0, 0, 2, 1]
//   [0, 3, 2, 1]
//   [4, 3, 2, 1]
// ]
//
//
//Example Explanation
//
//Explanation 2:
//
// 
// For A = 4 pattern looks like:  
//                                   1
//                                 2 1
//                               3 2 1
//                             4 3 2 1
// So we will return it as two-dimensional array. 
// Row 1 contains 3 spaces and 1 integer so spaces will be considered as 0 in the output.

package day11.homework;

import java.util.ArrayList;

public class PatternPrint2 {
	public static ArrayList<ArrayList<Integer>> solve(int A) {

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			ArrayList<Integer> eachRow = new ArrayList<>();
			for (int j = 0; j < A; j++) {
				if (i + j < A - 1) {
					eachRow.add(0);
					// System.out.print(" ");
				} else {
					// System.out.print(A-j);

					eachRow.add(A - j);
				}
			}
			matrix.add(eachRow);
			// System.out.println();
		}
		return matrix;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ans = solve(3);

		for (ArrayList<Integer> list : ans) {
			System.out.println(list);
		}
	}
}
