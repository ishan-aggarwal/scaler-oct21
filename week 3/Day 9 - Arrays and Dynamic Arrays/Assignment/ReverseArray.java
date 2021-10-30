//Problem Description
//
//You are given a constant array A.
//
//You are required to return another array which is the reversed form of input array.
//
//
//
//Problem Constraints
//1 <= A.size() <= 10000
//
//1 <= A[i] <= 10000
//
//
//
//Input Format
//First argument is a constant array A.
//
//
//
//Output Format
//You have to return an integer array.
//
//
//
//Example Input
//Input 1:
//
//A = [1,2,3,2,1]
//Input 2:
//
//A = [1,1,10]
//
//
//Example Output
//Output 1:
//
// [1,2,3,2,1] 
//Output 2:
//
// [10,1,1] 
//
//
//Example Explanation
//Explanation 1:
//
//Reversed form of input array is same as original array
//Explanation 2:
//
//Clearly, Reverse of [1,1,10] is [10,1,1]

package day9.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArray {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static ArrayList<Integer> solve(final List<Integer> A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int len = A.size();

		if (len == 0) {
			return result;
		}

		for (int i = len - 1; i >= 0; i--) {
			result.add(A.get(i));
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3, 4));
		System.out.println(solve(A));
	}
}
