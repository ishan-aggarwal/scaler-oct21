package day52.assignment;

import java.util.HashMap;
import java.util.Map;

//Q1. Longest Consecutive Sequence

//Problem Description
//
//Given an unsorted integer array A of size N.
//
//Find the length of the longest set of consecutive elements from the array A.
//
//
//
//Problem Constraints
//
//1 <= N <= 106
//
//-106 <= A[i] <= 106
//
//
//
//Input Format
//
//First argument is an integer array A of size N.
//
//
//
//Output Format
//
//Return an integer denoting the length of the longest set of consecutive elements from the array A.
//
//
//
//Example Input
//
//Input 1:
//
//A = [100, 4, 200, 1, 3, 2]
//Input 2:
//
//A = [2, 1]
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
// The set of consecutive elements will be [1, 2, 3, 4].
//Explanation 2:
//
// The set of consecutive elements will be [1, 2].

// Intuition is if we have any element whose predecessor is present, then largest consecutive sub-sequence will not start from the element x
// and we can simply ignore it...
// in order to find that an element is present or not, we are using map for the lookup purpose
// so as to reduce the overall time complexity
public class LongestConsecutiveSequence {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static int longestConsecutive(final int[] A) {
		int answer = Integer.MIN_VALUE;
		Map<Integer, Boolean> map = new HashMap<>();

		// O(N) operation
		for (int x : A) {
			map.put(x, true);
		}

		// these two loops are also O(N) operation...
		// as all the elements of the array will be visited only once...
		for (int x : A) {
			int copy = x;
			int count = 0;
			if (!map.containsKey(copy - 1)) {
				while (map.containsKey(copy)) {
					count++;
					copy++;
				}
				answer = Math.max(answer, count);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(A));
	}
}
