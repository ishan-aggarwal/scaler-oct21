package day40.assignment;

//Q2. Single Number II

//Problem Description
//
//Given an array of integers, every element appears thrice except for one which occurs once.
//
//Find that element which does not appear thrice.
//
//NOTE: Your algorithm should have a linear runtime complexity.
//
//Could you implement it without using extra memory?
//
//
//
//
//Problem Constraints
//
//2 <= A <= 5*106
//
//0 <= A <= INTMAX
//
//
//
//Input Format
//
//First and only argument of input contains an integer array A.
//
//
//
//Output Format
//
//Return a single integer.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
//Input 2:
//
// A = [0, 0, 0, 1]
//
//
//Example Output
//
//Output 1:
//
// 4
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
// 4 occurs exactly once in Input 1.
// 1 occurs exactly once in Input 2.

public class SingleNumber2 {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int singleNumber(final int[] nums) {
		int answer = 0;
		for (int i = 0; i < 32; i++) {
			int mask = (1 << i);
			int countBits = 0;

			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & mask) != 0) {
					countBits++;
				}
			}
			if (countBits % 3 == 1) {
				answer |= mask;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 4, 3, 3, 2, 2, 3, 1, 1 };
		System.out.println(singleNumber(A));
	}
}
