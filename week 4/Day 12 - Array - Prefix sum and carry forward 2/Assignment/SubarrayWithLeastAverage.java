//Q1. Subarray with least average
//
//Problem Description
//Given an array of size N, Find the subarray with least average of size k.
//
//
//
//Problem Constraints
//1<=k<=N<=1e5
//-1e5<=A[i]<=1e5
//
//
//Input Format
//First argument contains an array A of integers of size N.
//Second argument contains integer k.
//
//
//Output Format
//Return the index of the first element of the subarray of size k that has least average.
//Array indexing starts from 0.
//
//
//Example Input
//Input 1:
//A=[3, 7, 90, 20, 10, 50, 40]
//B=3
//Input 2:
//
//A=[3, 7, 5, 20, -10, 0, 12]
//B=2
//
//
//Example Output
//Output 1:
//3
//Output 2:
//
//4
//
//
//Example Explanation
//Explanation 1:
//Subarray between indexes 3 and 5
//The subarray {20, 10, 50} has the least average 
//among all subarrays of size 3.
//Explanation 2:
//
// Subarray between [4, 5] has minimum average


package day12.assignments;

import java.util.ArrayList;

public class SubarrayWithLeastAverage {
    public int solve(ArrayList<Integer> A, int B) {

		float minAverage = Integer.MAX_VALUE;
		int currentSum = 0;

		for (int i = 0; i < B; i++) {
			currentSum += A.get(i);
		}

		minAverage = currentSum * 1f / B;
		int startIndex = 0;
		float currentAverage = Integer.MAX_VALUE;

		for (int i = 1; i <= A.size() - B; i++) {
			currentSum = currentSum - A.get(i - 1) + A.get(i + B - 1);
			currentAverage = currentSum * 1f / B;
			if (currentAverage < minAverage) {
				minAverage = currentAverage;
				startIndex = i;
			}
		}
		return startIndex;
    }
}
