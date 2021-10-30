//Problem Description
//
//Find the contiguous subarray within an array, A of length N which has the largest sum.
//
//
//
//Problem Constraints
//1 <= N <= 1e6
//-1000 <= A[i] <= 1000
//
//
//
//Input Format
//The first and the only argument contains an integer array, A.
//
//
//
//Output Format
//Return an integer representing the maximum possible sum of the contiguous subarray.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2, 3, 4, -10] 
//Input 2:
//
// A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 
//
//
//**Example Output**
//Output 1:
//
// 10 
//Output 2:
//
// 6 
//
//
//**Example Explanation**
//Explanation 1:
//
// The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
//Explanation 2:
//
// The subarray [4,-1,2,1] has the maximum possible sum of 6. 

package day9.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumContiguousSubarray {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static int maxSubArray(final List<Integer> A) {

		int length = A.size();
		int currentSum = A.get(0);
		int maxSum = A.get(0);

		for (int i = 1; i < length; i++) {
			if (currentSum < 0) {
				currentSum = 0;
			}
			currentSum += A.get(i);
			if (currentSum > maxSum) {
				maxSum = currentSum;
			}
		}

		return maxSum;

	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3, 4, -10));
		System.out.println(maxSubArray(A));
	}
}
