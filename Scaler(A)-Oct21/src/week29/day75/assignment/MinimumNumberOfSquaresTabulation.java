package week29.day75.assignment;

//Q4. Minimum Number of Squares

//Problem Description
//Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
//
//
//
//Problem Constraints
//1 <= A <= 105
//
//
//
//Input Format
//First and only argument is an integer A.
//
//
//
//Output Format
//Return an integer denoting the minimum count.
//
//
//
//Example Input
//Input 1:
//
// A = 6
//Input 2:
//
// A = 5
//
//
//Example Output
//Output 1:
//
// 3
//Output 2:
//
// 2
//
//
//Example Explanation
//Explanation 1:
//
// Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
// Minimum count of numbers, sum of whose squares is 6 is 3. 
//Explanation 2:
//
// We can represent 5 using only 2 numbers i.e. 12 + 22 = 5

public class MinimumNumberOfSquaresTabulation {

	// TC - O(N*SQRT(N))
	// SC - O(N)
	public static int countMinSquares(int A) {

		// base condition
		// A = 1, (1)^2 = 1
		// A = 2, (1)^2 + (1)^2 = 2
		// A = 3, (1)^2 + (1)^2 + (1)^2 = 3
		if (A <= 3) {
			return A;
		}

		// taken a DP array of size (A+1)
		int[] minSquaresResult = new int[A + 1];

		// starting data initialized
		minSquaresResult[0] = 0;
		minSquaresResult[1] = 1;
		minSquaresResult[2] = 2;
		minSquaresResult[3] = 3;

		// iterate over all the numbers to populate the dp array
		// This is O(N) operation considering A as N
		for (int num = 4; num <= A; num++) {
			minSquaresResult[num] = num; // the max answer can be achieved by finding squares of all 1s and adding
			// this is O(SQRT(N)) operation
			for (int idx = 1; idx <= Math.sqrt(num); idx++) {
				minSquaresResult[num] = Math.min(minSquaresResult[num], 1 + minSquaresResult[num - idx * idx]);
			}
		}

		return minSquaresResult[A];

	}

	public static void main(String[] args) {
		System.out.println(countMinSquares(6));
		System.out.println(countMinSquares(5));
	}
}
