//Problem Description
//
//Given an array of integers A and multiple values in B which represents number of times array A needs to be left rotated.
//
//Find the rotated array for each value and return the result in the from of a matrix where i'th row represents the rotated array for the i'th value in B.
//
//
//
//Problem Constraints
//1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000
//
//
//Input Format
//The first argument given is the integer array A.
//The second argument given is the integer array B.
//
//
//Output Format
//Return the resultant matrix.
//
//
//Example Input
//Input 1:
// 
//    A = [1, 2, 3, 4, 5]
//    B = [2, 3]
//
//Input 2:
//
//
//    A = [5, 17, 100, 11]
//    B = [1]
//
//
//
//Example Output
//Output 1:
// 
//    [ [3, 4, 5, 1, 2]
//     [4, 5, 1, 2, 3] ]
//
//
//Output 2:
//
//
//    [ [17, 100, 11, 5] ]
//
//
//Example Explanation
//for input 1 -> B[0] = 2 which requires 2 times left rotations
//
//1: [2, 3, 4, 5, 1]
//
//2: [3, 4, 5, 1, 2]
//
//B[1] = 3 which requires 3 times left rotation
//
//1: [2, 3, 4, 5, 1]
//
//2: [3, 4, 5, 1, 2]
//
//2: [4, 5, 1, 2, 4]
//

package day9.assignments;

import java.util.ArrayList;
import java.util.Arrays;

public class MultipleLeftRotations {
	public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int length = A.size();

		for (Integer eachB : B) {
			eachB = eachB % length;
			ArrayList<Integer> eachRotation = new ArrayList<Integer>();
			for (int i = 0; i < length; i++) {
				eachRotation.add(A.get((i + eachB) % length));
				// if ( i <= eachB) {
				// eachRotation.add(A.get(i + eachB));
				// } else {
				// eachRotation.add(A.get(i - eachB - 1));
				// }
			}
			result.add(eachRotation);
		}

		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3, 4, 5));

		ArrayList<Integer> B = new ArrayList<>();
		B.addAll(Arrays.asList(2, 3));

		System.out.println(solve(A, B));
	}
}
