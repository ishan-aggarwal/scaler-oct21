package day35.assignment;

//Q2. A, B and Modulo

//Problem Description
//
//Given two integers A and B, find the greatest possible positive M, such that A % M = B % M.
//
//
//
//Problem Constraints
//
//1 <= A, B <= 109
//A != B
//
//
//
//Input Format
//
//The first argument given is the integer, A.
//The second argument given is the integer, B.
//
//
//
//Output Format
//
//Return an integer denoting greatest possible positive M.
//
//
//
//Example Input
//
//Input 1:
//
//A = 1
//B = 2
//Input 2:
//
//A = 5
//B = 10
//
//
//Example Output
//
//Output 1:
//
//1
//Output 2:
//
//5
//
//
//Example Explanation
//
//Explanation 1:
//
//1 is the largest value of M such that A % M == B % M.
//Explanation 2:
//
//For M = 5, A % M = 0 and B % M = 0.
//
//No value greater than M = 5, satisfies the condition.

public class ABModulo {
	public static int solve(int A, int B) {
		return A > B ? (A - B) : (B - A);
	}

	public static void main(String[] args) {
		System.out.println(solve(15, 35));
	}
}
