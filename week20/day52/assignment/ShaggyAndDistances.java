package day52.assignment;

import java.util.HashMap;
import java.util.Map;

//Q2. Shaggy and distances - Google

//Problem Description
//
//Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array as a special pair if elements at that index in the array are equal.
//
//Shaggy wants you to find a special pair such that distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array then return -1.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 105
//
//
//
//Input Format
//
//First and only argument is the array A.
//
//
//
//Output Format
//
//Return one integer corresponding to the minimum possible distance between a special pair.
//
//
//
//Example Input
//
//Input 1:
//
//A = [7, 1, 3, 4, 1, 7]
//Input 2:
//
//A = [1, 1]
//
//
//Example Output
//
//Output 1:
//
// 3
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
//Here we have 2 options:
//1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
//2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
//Therefore the minimum possible distance is 3. 
//Explanation 2:
//
//Only possibility is choosing A[1] and A[2].

public class ShaggyAndDistances {

	// TC - O(N) and SC - O(N)
	// Intuition is that we use a map to get O(1) access to the index of the
	// element.
	// For every element we need the index of the most recent occurrence of it
	public static int solve(int[] A) {
		int ans = Integer.MAX_VALUE;
		Map<Integer, Integer> lastOccurenceMap = new HashMap<>();

		// O(N) operation iteration over the array
		for (int i = 0; i < A.length; ++i) {

			// O(1) lookup operation for map
			if (lastOccurenceMap.containsKey(A[i])) {
				ans = Math.min(ans, Math.abs(i - lastOccurenceMap.get(A[i])));
			}

			// again O(1) operation to put an element
			lastOccurenceMap.put(A[i], i);
		}

		if (ans == Integer.MAX_VALUE) {
			return -1;
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] A = { 7, 1, 3, 4, 1, 7 };
		System.out.println(solve(A));
		int[] A1 = { 1, 1 };
		System.out.println(solve(A1));
	}
}
