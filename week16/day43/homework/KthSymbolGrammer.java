package day43.homework;

//Q1. Kth Symbol

//Problem Description
//
//On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//
//Given row A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.) (1 indexed).
//
//
//
//Problem Constraints
//
//1 <= A <= 20
//
//1 <= B <= 2A - 1
//
//
//
//Input Format
//
//First argument is an integer A.
//
//Second argument is an integer B.
//
//
//
//Output Format
//
//Return an integer denoting the Bth indexed symbol in row A.
//
//
//
//Example Input
//
//Input 1:
//
// A = 2
// B = 1
//Input 2:
//
// A = 2
// B = 2
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
// Row 1: 0
// Row 2: 01
//Explanation 2:
//
// Row 1: 0
// Row 2: 01

public class KthSymbolGrammer {
	public static int solve(int A, int B) {
		if (A == 1 && B == 1) {
			return 0;
		}
		if (B <= ((1 << (A - 1)) / 2)) {
			int value = solve(A - 1, B);
			return value;
		} else {
			int value = solve(A - 1, B - ((1 << (A - 1)) / 2));
			return value == 0 ? 1 : 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(solve(2, 2));
	}
}
