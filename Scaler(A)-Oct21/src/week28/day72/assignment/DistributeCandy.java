package week28.day72.assignment;

import java.util.ArrayList;
import java.util.Arrays;

//Q1. Distribute Candy
//N children are standing in a line. Each child is assigned a rating value.
//
//You are giving candies to these children subjected to the following requirements:
//
//Each child must have at least one candy.
//Children with a higher rating get more candies than their neighbors.
//What is the minimum number of candies you must give?
//
//
//
//Problem Constraints
//1 <= N <= 105
//-109 <= A[i] <= 109
//
//
//
//Input Format
//The first and only argument is an integer array A representing the rating of children.
//
//
//
//Output Format
//Return an integer representing the minimum candies to be given.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2]
//Input 2:
//
// A = [1, 5, 2, 1]
//
//
//Example Output
//Output 1:
//
// 3
//Output 2:
//
// 7
//
//
//Example Explanation
//Explanation 1:
//
// The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor. 
// So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
//Explanation 2:
//
// Candies given = [1, 3, 2, 1]

public class DistributeCandy {

	// Total TC - O(N) and SC - O(N)
	public static int candy(ArrayList<Integer> A) {

		int ans = 0;
		int n = A.size();
		int[] candies = new int[n];
		// each child should get one candy
		Arrays.fill(candies, 1);

		// check for neighbors from left to right
		// if neighbor has higher rating, he should get more candies than his neighbor
		for (int i = 1; i < n; i++) {
			if (A.get(i) > A.get(i - 1))
				candies[i] = candies[i - 1] + 1;
		}

		// check for neighbors from right to left
		// if neighbor has higher rating, he should get more candies than his neighbor
		for (int i = n - 2; i >= 0; i--) {
			if (A.get(i) > A.get(i + 1) && candies[i] <= candies[i + 1])
				candies[i] = candies[i + 1] + 1;
		}

		// count total candies
		for (int i = 0; i < n; i++) {
			ans += candies[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 2, 1));
		System.out.println(candy(A));
	}
}
