//Problem Description
//
//You are given an array of distinct integers A, you have to find and return all elements in array which have at-least two greater elements than themselves.
//
//NOTE: The result should have the order in which they are present in the original array.
//
//
//
//Problem Constraints
//3 <= |A| <= 105
//
//-109 <= A[i] <= 109
//
//
//
//Input Format
//First and only argument is an integer array A.
//
//
//
//Output Format
//Return an integer array containing the elements of A which have at-least two greater elements than themselves in A.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2, 3, 4, 5]
//Input 2:
//
// A = [11, 17, 100, 5]
//
//
//Example Output
//Output 1:
//
// [1, 2, 3]
//Output 2:
//
// [11, 5]
//
//
//Example Explanation
//Explanation 1:
//
// Number of elements greater than 1: 4
// Number of elements greater than 2: 3
// Number of elements greater than 3: 2
// Number of elements greater than 4: 1
// Number of elements greater than 5: 0
// Elements 1, 2 and 3 have atleast 2 elements strictly greater than themselves.
//Explanation 2:
//
// Number of elements greater than 11: 2
// Number of elements greater than 17: 1
// Number of elements greater than 100: 0
// Number of elements greater than 5: 3
// Elements 5 and 11 have atleast 2 elements strictly greater than themselves.

package day4.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementsWithAtleastTwoGreater {
	public static ArrayList<Integer> solve(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) > max1) {
				max2 = max1;
				max1 = A.get(i);
			} else if (A.get(i) > max2) {
				max2 = A.get(i);
			}
		}
		for (Integer element : A) {
			if (element != max1 && element != max2) {
				result.add(element);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(solve(A));
	}
}
