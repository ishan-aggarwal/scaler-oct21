//Q3. Count ways to make sum of odd and even indexed elements equal by removing an array element
//
//Problem Description
//
//Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
//
//
//
//Problem Constraints
//
//1<=n<=1e5
//-1e5<=A[i]<=1e5
//
//
//Input Format
//
//First argument contains an array A of integers of size N
//
//
//Output Format
//
//Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
//
//
//
//Example Input
//
//Input 1:
//A=[2, 1, 6, 4]
//Input 2:
//
//A=[1, 1, 1]
//
//
//Example Output
//
//Output 1:
//1
//Output 2:
//
//3
//
//
//Example Explanation
//
//Explanation 1:
//Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
//Therefore, the required output is 1. 
//Explanation 2:
//
// Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
//Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
//Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
//Therefore, the required output is 3.

package day12.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountWaysToMakeOddEvenSumSame {
	public static int solve(ArrayList<Integer> A) {
		int length = A.size();

// handle boundary cases
		if (length == 0 || length == 2) {
			return 0;
		}

		if (length == 1) {
			return 1;
		}

// prepare prefix sum arrays
		int[] evenPrefixSum = prepareEvenPrefixSum(A, length);
		int[] oddPrefixSum = prepareOddPrefixSum(A, length);

// calculate results
		int answer = 0;

		for (int i = 0; i < length; i++) {

			if (isSumEqual(evenPrefixSum, oddPrefixSum, i, length)) {
				answer++;
			}

		}

// return result
		return answer;
	}

	private static boolean isSumEqual(int[] evenPrefixSum, int[] oddPrefixSum, int currentIndex, int length) {

		int evenSum, oddSum;
		evenSum = (currentIndex - 1 > 0)
				? evenPrefixSum[currentIndex - 1] + oddPrefixSum[length - 1] - oddPrefixSum[currentIndex]
				: oddPrefixSum[length - 1] - oddPrefixSum[currentIndex];
		oddSum = (currentIndex - 1 > 0)
				? oddPrefixSum[currentIndex - 1] + evenPrefixSum[length - 1] - evenPrefixSum[currentIndex]
				: evenPrefixSum[length - 1] - evenPrefixSum[currentIndex];

		if (evenSum == oddSum) {
			return true;
		}

		return false;
	}

	private static int[] prepareOddPrefixSum(List<Integer> A, int length) {
		int[] oddPrefixSum = new int[length];
		oddPrefixSum[0] = 0;
		for (int i = 1; i < length; i++) {
			if (i % 2 != 0) {
				oddPrefixSum[i] = oddPrefixSum[i - 1] + A.get(i);
			} else {
				oddPrefixSum[i] = oddPrefixSum[i - 1];
			}
		}
		return oddPrefixSum;
	}

	private static int[] prepareEvenPrefixSum(List<Integer> A, int length) {

		int[] evenPrefixSum = new int[length];
		evenPrefixSum[0] = A.get(0);

		for (int i = 1; i < length; i++) {
			if (i % 2 == 0) {
				evenPrefixSum[i] = evenPrefixSum[i - 1] + A.get(i);
			} else {
				evenPrefixSum[i] = evenPrefixSum[i - 1];
			}
		}
		return evenPrefixSum;
	}

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(1);

		System.out.println(solve(a));
	}
}
