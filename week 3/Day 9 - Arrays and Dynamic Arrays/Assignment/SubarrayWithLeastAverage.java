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

package day9.assignments;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithLeastAverage {
	public static int solve(ArrayList<Integer> A, int B) {

		int len = A.size();

		if (B > len) {
			return 0;
		}

		int currentSum = 0;
		double minAverage = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < len; i++) {
			currentSum += A.get(i);
			if (i >= (B - 1)) {
				if (((currentSum) * 1.0 / B) < minAverage) {
					minAverage = (currentSum) * 1.0 / B;
					index = (i - B + 1);
				}
				// minAverage = (minAverage < (currentSum) / B) ? minAverage : (currentSum) / B;
				currentSum = currentSum - A.get(i - B + 1);
			}

		}
		return index;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(3, 7, 5, 20, -10, 0, 12));
		int B = 2;
		System.out.println(solve(A, B));
	}
}
