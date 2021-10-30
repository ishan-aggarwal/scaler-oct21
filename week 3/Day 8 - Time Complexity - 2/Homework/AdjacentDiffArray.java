//Problem Description
//
//You are given an integer array A having N integers.
//
//You have to construct and return an array containing all the adjacent / consecutive element differences (A[i + 1] - A[i]) in the same order.
//
//
//
//Problem Constraints
//1 <= N <= 105
//
//1 <= A[i] <= 109
//
//
//
//Input Format
//First and only argument is an integer array A.
//
//
//
//Output Format
//Return an integer array.
//
//
//
//Example Input
//Input 1:
//
// A = [6, 2, 4, 4, 3]
//Input 2:
//
// A = [2]
//
//
//Example Output
//Output 1:
//
// [-4, 2, 0, -1]
//Output 2:
//
// []
//
//
//Example Explanation
//Explanation 1:
//
// A[1] - A[0] = 2 - 6 = -4
// A[2] - A[1] = 4 - 2 = 2
// A[3] - A[2] = 4 - 4 = 0
// A[4] - A[3] = 3 - 4 = -1 
// ∴ Result Array = [-4, 2, 0, -1]
//Explanation 2:
//
// As there is only one element in the array, there are no adjacent element pairs. So, an empty integer array is returned.

package day8.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class AdjacentDiffArray {
	public static ArrayList<Integer> solve(ArrayList<Integer> A) {

		int size = A.size();
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (size == 1) {
			return result;
		}

		for (int i = 0; i < size - 1; i++) {
			result.add(A.get(i + 1) - A.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(6, 2, 4, 4, 3));
		System.out.println(solve(A));
	}
}
