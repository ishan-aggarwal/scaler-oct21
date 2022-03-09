package day53.homework;

//Q1. Points on same line

//Problem Description
//
//Given two array of integers A and B describing a pair of (A[i], B[i]) coordinates in 2D plane. A[i] describe x coordinates of the ith point in 2D plane whereas B[i] describes the y-coordinate of the ith point in 2D plane.
//
//Find and return the maximum number of points which lie on the same line.
//
//
//
//Problem Constraints
//
//1 <= (length of the array A = length of array B) <= 1000
//
//-105 <= A[i], B[i] <= 105
//
//
//
//Input Format
//
//First argument is an integer array A.
//Second argument is an integer array B.
//
//
//
//Output Format
//
//Return the maximum number of points which lie on the same line.
//
//
//
//Example Input
//
//Input 1:
//
// A = [-1, 0, 1, 2, 3, 3]
// B = [1, 0, 1, 2, 3, 4]
//Input 2:
//
// A = [3, 1, 4, 5, 7, -9, -8, 6]
// B = [4, -8, -3, -2, -1, 5, 7, -4]
//
//
//Example Output
//
//Output 1:
//
// 4
//Output 2:
//
// 2
//
//
//Example Explanation
//
//Explanation 1:
//
// The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
//Explanation 2:
//
// Any 2 points lie on a same line.

import java.util.HashMap;
import java.util.Map;

public class CountPointsOnSameLine {
	public static int solve(int[] A, int[] B) {

		int answer = 0;
		for (int i = 0; i < A.length; i++) {
			Map<String, Integer> freqMap = new HashMap<>();
			int count = 1;
			String str = "";
			int currMax = 0;
			for (int j = 0; j < A.length; j++) {
				if (i != j) {
					if (A[i] == A[j] && B[j] == B[i]) {
						count++;
					} else {
						int numerator = B[i] - B[j];
						int denominator = A[i] - A[j];
						int gcd = findGCD(numerator, denominator);
						str = "" + (numerator / gcd) + "-" + (denominator / gcd);
						freqMap.compute(str, (key, value) -> (value == null) ? 1 : value + 1);
					}
					currMax = Math.max(currMax, count);
					if (freqMap.containsKey(str)) {
						currMax = Math.max(currMax, count + freqMap.get(str));
					}
				}
			}
			answer = Math.max(answer, currMax);
		}
		return answer;
	}

	private static int findGCD(int a, int b) {
		if (b == 0)
			return a;
		return findGCD(b, a % b);
	}

	public static void main(String[] args) {
		int[] A = { -1, 0, 1, 2, 3, 3 };
		int[] B = { 1, 0, 1, 2, 3, 4 };
		System.out.println(solve(A, B));

	}
}
