//Q5. Find nth Magic Number
//
//Problem Description
//
//Given an integer A, find and return the Ath magic number.
//
//A magic number is defined as a number which can be expressed as a power of 5 or sum of unique powers of 5.
//
//First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), �.
//
//
//
//Problem Constraints
//
//1 <= A <= 5000
//
//
//
//Input Format
//
//The only argument given is integer A.
//
//
//
//Output Format
//
//Return the Ath magic number.
//
//
//
//Example Input
//
//Example Input 1:
//
// A = 3
//Example Input 2:
//
// A = 10
//
//
//Example Output
//
//Example Output 1:
//
// 30
//Example Output 2:
//
// 650
//
//
//Example Explanation
//
//Explanation 1:
//
// A in increasing order is [5, 25, 30, 125, 130, ...]
// 3rd element in this is 30
//Explanation 2:
//
// In the sequence shown in explanation 1, 10th element will be 650.

package day16.assignments;

public class NthMagicNumber {
	public static int solve(int A) {

		int pow = 1;
		int ans = 0;

		while (A != 0) {

			pow = pow * 5;

			if ((A & 1) == 1) {
				ans = ans + pow;
			}

			A >>= 1;
		}

		return ans;

	}

	public static void main(String[] args) {
		System.out.println(solve(10));
	}
}
