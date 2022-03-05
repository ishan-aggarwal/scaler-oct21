package leetcode.march;

import java.util.Arrays;

// https://leetcode.com/problems/counting-bits/

// 338. Counting Bits
// Easy

// Good approach
class CountingBitsUptoNNumbers_Day1 {

	// It is kind of a recurrence relation
	// where the result for ith index are calculated from older results
	// It makes use of a result array to store the pre-calculated results
	public static int[] countBits(int n) {
		int[] result = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			result[i] = result[i >> 1] + (i & 1); // answer for num = num/2 + 1 if number is odd
		}
		return result;
	}

	public static void main(String[] args) {
		int[] result = countBits(5);
		System.out.println(Arrays.toString(result));
	}
}