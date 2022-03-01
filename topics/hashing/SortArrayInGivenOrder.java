package day52.homework;

import java.util.Map;
import java.util.TreeMap;

//Q1. Sort Array in given Order

//Problem Description
//
//Given two array of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B. For the elements not present in B, append them at last in sorted order.
//
//Return the array A after sorting from the above method.
//
//NOTE: Elements of B are unique.
//
//
//
//Problem Constraints
//
//1 <= length of the array A <= 100000
//
//1 <= length of the array B <= 100000
//
//-10^9 <= A[i] <= 10^9
//
//
//
//Input Format
//
//The first argument given is the integer array A.
//
//The second argument given is the integer array B.
//
//
//
//Output Format
//
//Return the array A after sorting as described.
//
//
//
//Example Input
//
//Input 1:
//
//A = [1, 2, 3, 4, 5]
//B = [5, 4, 2]
//Input 2:
//
//A = [5, 17, 100, 11]
//B = [1, 100]
//
//
//Example Output
//
//Output 1:
//
//[5, 4, 2, 1, 3]
//Output 2:
//
//[100, 5, 11, 17]
//
//
//Example Explanation
//
//Explanation 1:
//
// Simply sort as described.
//Explanation 2:
//
// Simply sort as described.

public class SortArrayInGivenOrder {
	public static int[] solve(int[] A, int[] B) {

		Map<Integer, Integer> aFreqMap = new TreeMap<>();

		int[] sortedA = new int[A.length];
		// Prepare the Freq Map for array A
		for (int i = 0; i < A.length; i++) {
			aFreqMap.put(A[i], aFreqMap.getOrDefault(A[i], 0) + 1);
		}

		// 2. Iterate over array B and start adding them in
		// to sortedA as per element frequency in A
		int aIdx = 0;
		for (int i = 0; i < B.length; i++) {
			if (aFreqMap.containsKey(B[i])) {
				int noOfElem = aFreqMap.get(B[i]);
				while (noOfElem > 0) {
					sortedA[aIdx++] = B[i];
					noOfElem--;
				}
				aFreqMap.remove(B[i]);
			}
		}

		// 3. Add the remaining elements of Array A at the end to sortedA array
		// since we are using treemap, it will give the elements in sorted order already
		for (Integer key : aFreqMap.keySet()) {
			int noOfElem = aFreqMap.get(key);
			while (noOfElem > 0) {
				sortedA[aIdx++] = key;
				noOfElem--;
			}
		}
		return sortedA;
	}

	public static void main(String[] args) {
		int[] A = { 5, 17, 100, 11, 5, 11, 5 };
		int[] B = { 1, 100 };
		int[] res = solve(A, B);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}
}
