package day52.assignment;

import java.util.HashMap;
import java.util.Map;

// Problem - Asked in Swiggy and follow up was to do in single iteration

// Given an array of N elements, count the number of duplicate pairs i.e. A[i] = A[j] and i != j
// (i,j) == (j,i)

public class CountDuplicatePairs {

	// TC - O(N)
	// SC - O(N)
	// Idea is to use a hashmap to store the frequency count of elements.
	// whenever we are seeing a repeated element it will form a pair with all
	// previous occurrences of it
	// so we will add the previous frequency count first to the answer and then
	// increase the frequency and
	// store it in the map
	// Also, the key point of the solution is we have done this in single iteration
	public static int solve(final int[] A) {
		int answer = 0;
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int x : A) {
			if (freqMap.containsKey(x)) {
				answer = answer + freqMap.get(x);
			}
			freqMap.put(x, freqMap.getOrDefault(x, 0) + 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 1, 4, 1, 2, 3, 4, 1, 6 };
		System.out.println(solve(A));
	}

}
