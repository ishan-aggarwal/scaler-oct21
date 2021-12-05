//Q3. Largest Continuous Sequence Zero Sum
//Problem Description
//
//Given an array A of N integers.
//
//Find the largest continuous sequence in a array which sums to zero.
//
//
//
//Problem Constraints
//
//1 <= N <= 106
//
//-107 <= A[i] <= 107
//
//
//
//Input Format
//
//Single argument which is an integer array A.
//
//
//
//Output Format
//
//Return an array denoting the longest continuous sequence with total sum of zero.
//
//NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
//
//
//
//Example Input
//
//A = [1,2,-2,4,-4]
//
//
//Example Output
//
//[2,-2,4,-4]
//
//
//Example Explanation
//
//[2,-2,4,-4] is the longest sequence with total sum of zero.

package day20.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuousSequenceWithZeroSum {
	public static ArrayList<Integer> lszero(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		Map<Long, Integer> prefixSumFrequencyMap = new HashMap<>();
		Long[] prefixSum = new Long[A.size()];

		prefixSum[0] = (long) A.get(0);
		for (int i = 1; i < A.size(); i++) {
			prefixSum[i] = prefixSum[i - 1] + A.get(i);
		}

		int maxLength = 0;
		int startPointer = 0;
		int endPointer = 0;

		for (int i = 0; i < A.size(); i++) {
			if (prefixSum[i] == 0) {
				if ((i + 1) > maxLength) {
					maxLength = i + 1;
					startPointer = 0;
					endPointer = i + 1;
				}
			} else {

				if (prefixSumFrequencyMap.get(prefixSum[i]) == null) {
					prefixSumFrequencyMap.put(prefixSum[i], i);
				} else {
					Integer firstPostition = prefixSumFrequencyMap.get(prefixSum[i]);
					if ((i - (firstPostition + 1)) > maxLength) {
						maxLength = i - (firstPostition + 1);
						startPointer = firstPostition + 1;
						endPointer = i + 1;
					}
				}
			}
		}

		for (int i = startPointer; i < endPointer; i++) {
			result.add(A.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
//		A = [1,2,-2,4,-4]
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(-2);
		A.add(4);
		A.add(-4);

		ArrayList<Integer> result = lszero(A);
		System.out.println(result);
	}
}
