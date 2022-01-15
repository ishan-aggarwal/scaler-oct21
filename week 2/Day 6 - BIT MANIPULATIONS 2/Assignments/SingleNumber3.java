//Problem Description
//
//Given an array of numbers A , in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
//
//Note: Output array must be sorted.
//
//
//
//Problem Constraints
//2 <= |A| <= 100000
//1 <= A[i] <= 109
//
//
//
//Input Format
//First argument is an array of interger of size N.
//
//
//
//Output Format
//Return an array of two integers that appear only once.
//
//
//
//Example Input
//Input 1:
//
//A = [1, 2, 3, 1, 2, 4]
//Input 2:
//
//A = [1, 2]
//
//
//Example Output
//Output 1:
//
//[3, 4]
//Output 2:
//
//[1, 2]
//
//
//Example Explanation
//Explanation 1:
//
// 3 and 4 appear only once.
//Explanation 2:
//
// 1 and 2 appear only once.

package day6.assignments;

import java.util.ArrayList;
import java.util.Arrays;

public class SingleNumber3 {
	public static ArrayList<Integer> solve(ArrayList<Integer> A) {

		int n = A.size();
		ArrayList<Integer> list = new ArrayList<>();

		if (n < 2) {
			return null;
		}

		// since all numbers are repeated twice except two numbers
		// so final xor will hold the xor of those two numbers
		int xor = 0;
		for (int i = 0; i < n; i++) {
			xor = xor ^ A.get(i);
		}

		int i = 0, pos = 0;
		int ans1 = 0, ans2 = 0;

		// now since xor is non-zero, that means the set bit in xor result
		// should be set in either of the numbers (A or B) and not both
		// so identify the position of first such set bit
		while (xor != 0) {
			if ((xor & 1) == 1) {
				pos = i;
				break;
			}
			i++;
			xor = xor >> 1;
		}

		// finally divide the whole array into two sets of numbers
		// one in which the bit at pos is set and other in which bit at pos is not set
		for (i = 0; i < n; i++) {

			if ((A.get(i) & (1 << pos)) != 0) {
				ans1 = ans1 ^ A.get(i);
			} else {
				ans2 = ans2 ^ A.get(i);
			}
		}

		if (ans1 < ans2) {
			list.add(ans1);
			list.add(ans2);
		} else {
			list.add(ans2);
			list.add(ans1);
		}

		return list;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3, 1, 2, 4));
		System.out.println(solve(A));
	}

}
