package day32.classwork;

//Q3. Max Sum Contiguous Subarray

//Problem Description
//
//Find the contiguous subarray within an array, A of length N which has the largest sum.
//
//
//
//Problem Constraints
//
//1 <= N <= 1e6
//-1000 <= A[i] <= 1000
//
//
//
//Input Format
//
//The first and the only argument contains an integer array, A.
//
//
//
//Output Format
//
//Return an integer representing the maximum possible sum of the contiguous subarray.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 3, 4, -10] 
//Input 2:
//
// A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 
//
//
//Example Output
//
//Output 1:
//
// 10 
//Output 2:
//
// 6 
//
//
//Example Explanation
//
//Explanation 1:
//
// The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
//Explanation 2:
//
// The subarray [4,-1,2,1] has the maximum possible sum of 6. 

public class MaxSumContiguousSubarrayWithLargestLength {
	public static int[] maxSubArray(final int[] A) {

		// note answer is initialized with Integer minimum
		int answer = Integer.MIN_VALUE;

		// current sum is initialized with zero
		int currentSum = 0;

		int startPos = 0;
		int endPos = 0;
		int largestLength = Integer.MIN_VALUE;

		// iterate over the array
		for (int start = 0, end = 0; end < A.length; end++) {
			// add current element to the sum
			currentSum += A[end];

			// update answer if current sum is greater than answer
			// and set the values for startPos and endPos
			if (currentSum > answer || (currentSum == answer && (end - start + 1) > largestLength)) {
				answer = currentSum;
				startPos = start;
				endPos = end;
				largestLength = end - start + 1;
			}
			// reset the current sum to zero if it is negative and adjust the start pointer
			// also to position end + 1
			if (currentSum < 0) {
				currentSum = 0;
				start = end + 1;
			}
		}

		return new int[] { startPos, endPos, answer };
	}

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -500, 4, 96, -200, -1, 2, 1, -5, 4, -800, 100 };

		int[] res = maxSubArray(A);
		for (int x : res) {
			System.out.println(x + " ");
		}
	}
}
