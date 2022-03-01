package day52.assignment;

//Q5. Distinct Numbers in Window

//Problem Description
//
//You are given an array of N integers, A1, A2 ,…, AN and an integer B. Return the of count of distinct numbers in all windows of size B.
//
//Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
//
//NOTE: if B > N, return an empty array.
//
//
//
//Input Format
//
//First argument is an integer array A
//Second argument is an integer B.
//
//
//
//Output Format
//
//Return an integer array.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 1, 3, 4, 3]
// B = 3
//Input 2:
//
// A = [1, 1, 2, 2]
// B = 1
//
//
//Example Output
//
//Output 1:
//
// [2, 3, 3, 2]
//Output 2:
//
// [1, 1, 1, 1]
//
//
//Example Explanation
//
//Explanation 1:
//
// A=[1, 2, 1, 3, 4, 3] and B = 3
// All windows of size B are
// [1, 2, 1]
// [2, 1, 3]
// [1, 3, 4]
// [3, 4, 3]
// So, we return an array [2, 3, 3, 2].
//Explanation 2:
//
// Window size is 1, so the output array is [1, 1, 1, 1].

import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersCountInWindow {

	// TC - O(N)
	// SC - O(N)

	public static int[] dNums(int[] A, int B) {
		int n = A.length;
		if (B > n) {
			return new int[] {};
		}

		// this is the result array to store the result
		int[] res = new int[n - B + 1];

		// taking a frequency map to store the frequency of all the elements in the
		// window of size B
		// in case the element is not present put the frequency count as 1.
		Map<Integer, Integer> freqMap = new HashMap<>();
		int index = 0;

		// create a frequency map for first B elements of the array
		for (int i = 0; i < B; ++i) {
			freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1);
		}

		// store the size of frequency map in resultant array
		res[index++] = freqMap.size();

		// O(N) operation
		// now every time we iterate over the array, we put the element at current index
		// and discard the element which is not
		// part of the sliding window
		// in case the frequency becomes zero for the discarded element, we will also
		// remove the element from the map
		// finally store the size of the frequency map in resultant array
		for (int i = B; i < n; i++) {
			freqMap.put(A[i], freqMap.getOrDefault(A[i], 0) + 1);
			freqMap.put(A[i - B], freqMap.get(A[i - B]) - 1);
			if (freqMap.get(A[i - B]) == 0) {
				freqMap.remove(A[i - B]);
			}
			res[index++] = freqMap.size();
		}

		// return the result
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 3, 4, 3 };
		int B = 3;
		int[] res = dNums(A, B);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}
}
