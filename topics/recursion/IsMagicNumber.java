package day42.assignment;

//Q2. Is magic?
//Problem Description
//
//Given a number A, check if it is a magic number or not.
//
//A number is said to be a magic number, if the sum of its digits are calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.
//
//
//
//Problem Constraints
//
//1 <= A <= 109
//
//
//
//Input Format
//
//First and only argument is an integer A.
//
//
//
//Output Format
//
//Return an integer 1 if the given number is magic else return 0.
//
//
//
//Example Input
//
//Input 1:
//
// A = 83557
//Input 2:
//
// A = 1291
//
//
//Example Output
//
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//
//Explanation 1:
//
// Sum of digits of (83557) = 28
// Sum of digits of (28) = 10
// Sum of digits of (10) = 1. 
// Single digit is 1, so it's a magic number. Return 1.
//Explanation 2:
//
// Sum of digits of (1291) = 13
// Sum of digits of (13) = 4
// Single digit is not 1, so it's not a magic number. Return 0.

public class IsMagicNumber {
	public static int solve(int A) {
		int sum = getSum(A);
		while (sum >= 10) {
			sum = getSum(sum);
		}

		if (sum == 1) {
			return 1;
		} else {
			return 0;
		}
	}

	private static int getSum(int A) {
		if (A == 0) {
			return 0;
		}
		return getSum(A / 10) + (A % 10);
	}

	// here the technique is that sod should converge to 1...
	// all numbers which are divisible by 9 will converge to 0...
	// eg. 27%9 = 0 and 28%9 = 1
	public static int solve2(int A) {
		if (A % 9 == 1) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(solve(83557));
		System.out.println(solve2(83557));
	}
}
