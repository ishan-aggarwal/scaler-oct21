//Q1. Repeat and Missing Number Array
//There are certain problems which are asked in the interview to also check how you take care of overflows in your problem.
//This is one of those problems.
//Please take extra care to make sure that you are type-casting your ints to long properly and at all places. Try to verify if your solution works if number of elements is as large as 105
//
//Food for thought :
//
//Even though it might not be required in this problem, in some cases, you might be required to order the operations cleverly so that the numbers do not overflow.
//For example, if you need to calculate n! / k! where n! is factorial(n), one approach is to calculate factorial(n), factorial(k) and then divide them.
//Another approach is to only multiple numbers from k + 1 ... n to calculate the result.
//Obviously approach 1 is more susceptible to overflows.
//You are given a read only array of n integers from 1 to n.
//
//Each integer appears exactly once except A which appears twice and B which is missing.
//
//Return A and B.
//
//Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//Note that in your output A should precede B.
//
//Example:
//
//Input:[3 1 2 5 3] 
//
//Output:[3, 4] 
//
//A = 3, B = 4

package day15.homework;

public class RepeatAndMissingNumberArray_VImportant {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int[] repeatedNumber(final int[] A) {

		int n = A.length;
		int lsbSetBit;
		int i;
		int num1 = 0;
		int num2 = 0;

		int xor = 0;
		for (i = 0; i < n; i++) {
			xor = xor ^ A[i];
		}

		for (i = 1; i <= n; i++) {
			xor = xor ^ i;
		}

		lsbSetBit = xor & ~(xor - 1);

		for (i = 0; i < n; i++) {
			if ((A[i] & lsbSetBit) != 0) {
				num1 = num1 ^ A[i];
			} else {
				num2 = num2 ^ A[i];
			}
		}

		for (i = 1; i <= n; i++) {
			if ((i & lsbSetBit) != 0) {
				num1 = num1 ^ i;
			} else {
				num2 = num2 ^ i;
			}
		}

		int count = 0;
		for (i = 0; i < n; i++) {
			if (A[i] == num1) {
				count++;
			}
		}

		int res[] = new int[2];
		if (count == 2) {
			res[0] = num1;
			res[1] = num2;
		} else {
			res[0] = num2;
			res[1] = num1;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 5, 3 };
		int[] res = repeatedNumber(A);
		System.out.println(res[0] + " " + res[1]);
	}
}
