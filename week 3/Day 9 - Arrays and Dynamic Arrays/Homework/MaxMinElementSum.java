//Problem Description
//
//Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.
//
//NOTE: You should make minimum number of comparisons.
//
//
//
//Problem Constraints
//1 <= N <= 105
//
//-109 <= A[i] <= 109
//
//
//
//Input Format
//First and only argument is an integer array A of size N.
//
//
//
//Output Format
//Return an integer denoting the sum Maximum and Minimum element in the given array.
//
//
//
//Example Input
//Input 1:
//
// A = [-2, 1, -4, 5, 3]
//Input 2:
//
// A = [1, 3, 4, 1]
//
//
//Example Output
//Output 1:
//
// 1
//Output 2:
//
// 5
//
//
//Example Explanation
//Explanation 1:
//
// Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1. 
//Explanation 2:
//
// Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.

package day9.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxMinElementSum {
	public static int solve(ArrayList<Integer> A) {

		int maxElement = Integer.MIN_VALUE;
		int minElement = Integer.MAX_VALUE;

		for (Integer num : A) {
			if (num > maxElement) {
				maxElement = num;
			}
			if (num < minElement) {
				minElement = num;
			}
		}
		return maxElement + minElement;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(-2, 1, -4, 5, 3));
		System.out.println(solve(A));
	}
}
