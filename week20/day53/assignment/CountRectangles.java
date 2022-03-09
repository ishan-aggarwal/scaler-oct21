package day53.assignment;

import java.util.HashMap;
import java.util.Map;

//Q1. Count Rectangles

//Problem Description
//
//Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2-D Cartesian plane.
//
//Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
//
//
//
//Problem Constraints
//
//1 <= N <= 2000
//0 <= A[i], B[i] <= 109
//
//
//
//Input Format
//
//The first argument given is the integer array A.
//The second argument given is the integer array B.
//
//
//
//Output Format
//
//Return the number of unordered quadruplet that form a rectangle.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 1, 2, 2]
// B = [1, 2, 1, 2]
//Input 1:
//
// A = [1, 1, 2, 2, 3, 3]
// B = [1, 2, 1, 2, 1, 2]
//
//
//Example Output
//
//Output 1:
//
// 1
//Output 2:
//
// 3
//
//
//Example Explanation
//
//Explanation 1:
//
// All four given points make a rectangle. So, the answer is 1.
//Explanation 2:
//
// 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
//                                           (1, 1), (3, 1), (3, 2), (1, 2)
//                                           (2, 1), (3, 1), (3, 2), (2, 2)

public class CountRectangles {
	public static int solve(int[] A, int[] B) {
		int answer = 0;
		Map<String, Integer> pairFrequencyMap = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			pairFrequencyMap.put(A[i] + "_" + B[i], pairFrequencyMap.getOrDefault(A[i] + "_" + B[i], 0) + 1);
		}

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < B.length; j++) {

				if (A[i] == A[j] || B[i] == B[j]) {
					continue;
				}

				if (pairFrequencyMap.containsKey(A[i] + "_" + B[j]) && pairFrequencyMap.get(A[i] + "_" + B[j]) == 1
						&& pairFrequencyMap.containsKey(A[j] + "_" + B[i])
						&& pairFrequencyMap.get(A[j] + "_" + B[i]) == 1) {
					answer++;
				}
			}
		}
		return answer / 2;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 2, 2, 3, 3 };
		int[] B = { 1, 2, 1, 2, 1, 2 };
		System.out.println(solve(A, B));
	}
}
