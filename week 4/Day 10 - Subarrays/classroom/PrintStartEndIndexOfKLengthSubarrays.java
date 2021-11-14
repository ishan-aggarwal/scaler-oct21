/*
 * Print start and end index of all sub arrays of length k
 * 
 * so it can be done in O(N) time with simple maths calculations
 * 
 * --> How to iterate over all sub arrays of given length
 */

package day10.classroom;

import java.util.Arrays;
import java.util.List;

public class PrintStartEndIndexOfKLengthSubarrays {

	public static void solve(List<Integer> list, int k) {

		int start, end;
		for (int i = 0; i <= list.size() - k; i++) {
			start = i;
			end = k + i - 1;
			System.out.println(start + ", " + end);
		}
	}

	public static void main(String[] args) {

		Integer A[] = { 3, 7, 1, 6, 8, -2, 9 };
		List<Integer> list = Arrays.asList(A);
		solve(list, 3);
	}

}
