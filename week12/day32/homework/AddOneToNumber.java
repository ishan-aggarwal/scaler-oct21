package day32.homework;

//Q1. Add One To Number

//Problem Description
//
//Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
//
//The digits are stored such that the most significant digit is at the head of the list.
//
//NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, following are some good questions to ask :
//
//Q : Can the input have 0's before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
//A : For the purpose of this question, YES
//Q : Can the output have 0's before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
//A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
//
//
//Problem Constraints
//
//1 <= size of the array <= 1000000
//
//
//
//Input Format
//
//First argument is an array of digits.
//
//
//
//Output Format
//
//Return the array of digits after adding one.
//
//
//
//Example Input
//
//Input 1:
//
//[1, 2, 3]
//
//
//Example Output
//
//Output 1:
//
//[1, 2, 4]
//
//
//Example Explanation
//
//Explanation 1:
//
//Given vector is [1, 2, 3].
//The returned vector should be [1, 2, 4] as 123 + 1 = 124.

public class AddOneToNumber {
	public static int[] plusOne(int[] A) {

		int n = A.length;

		// take the carry as 1 initially as we need to add plus one to the number
		int carry = 1;

		// start the loop from right to left... as right represents the unit place
		for (int i = n - 1; i >= 0; i--) {

			int sum = A[i] + carry;
			A[i] = sum % 10;
			carry = sum / 10;

			// not if carry is zero after adding 1 to the digit no need to proceed further
			// as other digits would remain same
			if (carry == 0) {
				break;
			}
		}

		if (carry > 0) {
			int[] res = new int[n + 1];

			// put the last value of carry at the res 0th index
			res[0] = carry;

			// copy the rest of the array in result as it is
			for (int i = 1; i < res.length; i++) {
				res[i] = A[i - 1];
			}
			return res;

		} else {

			// if carry is zero we need to remove the leading zeros from the original number
			// so we will first count the total number of such zeros
			int count = 0;
			while (A[count] == 0) {
				count++;
			}
			// the resultant array will have (n-count) elements
			int[] res = new int[n - count];

			// copy the original array elements to the resultant array
			for (int i = count; i < n; i++) {
				res[i - count] = A[i];
			}
			return res;
		}
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 3 };

		int[] res = plusOne(A);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}
}