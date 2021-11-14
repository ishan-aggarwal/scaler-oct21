//Q1. Xor queries
//
//Problem Description
//
//You are given an array A (containing only 0 and 1) as element of N length.
//Given L and R, you need to determine value of XOR of all elements from L to R (both inclusive) and number of unset bits (0's) in the given range of the array.
//
//
//
//Problem Constraints
//
//1<=N,Q<=100000
//1<=L<=R<=N
//
//
//Input Format
//
//First argument contains the array of size N containing 0 and 1 only. 
//Second argument contains a 2D array with Q rows and 2 columns, each row represent a query with 2 columns representing L and R.
//
//
//Output Format
//
//Return an 2D array of Q rows and 2 columns i.e the xor value and number of unset bits in that range respectively for each query.
//
//
//Example Input
//
//A=[1,0,0,0,1]
//B=[ [2,4],
//    [1,5],
//    [3,5] ]
//
//
//Example Output
//
//[[0 3]
//[0 3]
//[1 2]]
//
//
//Example Explanation
//
//In the given case the bit sequence is of length 5 and the sequence is 1 0 0 0 1. 
//For query 1 the range is (2,4), and the answer is (array[2] xor array[3] xor array[4]) = 0, and number of zeroes are 3, so output is 0 3. 
//Similarly for other queries.

package day12.homework;

import java.util.ArrayList;

public class XorQueries {
	public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

		int[] countZeros = new int[A.size()];
		prepareCountList(countZeros, A);
		ArrayList<ArrayList<Integer>> result = prepareResult(countZeros, B);

		return result;
	}

	private static ArrayList<ArrayList<Integer>> prepareResult(int[] countZeros, ArrayList<ArrayList<Integer>> B) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int startIndex = 0;
		int endIndex = 0;
		int querySize = 0;
		int totalZerosInRange = 0;
		int totalOnesInRange = 0;
		int xorResult = 0;
		for (ArrayList<Integer> query : B) {
			ArrayList<Integer> eachQueryResults = new ArrayList<>();
			startIndex = query.get(0) - 1;
			endIndex = query.get(1) - 1;
			querySize = endIndex - startIndex + 1;

			if (startIndex > 0) {
				totalZerosInRange = countZeros[endIndex] - countZeros[startIndex - 1];
			} else {
				totalZerosInRange = countZeros[endIndex];
			}
			totalOnesInRange = querySize - totalZerosInRange;
			if ((totalOnesInRange & 1) == 1) {
				xorResult = 1;
			} else {
				xorResult = 0;
			}
			eachQueryResults.add(xorResult);
			eachQueryResults.add(totalZerosInRange);

			result.add(eachQueryResults);
		}
		return result;
	}

	private static void prepareCountList(int[] countZeros, ArrayList<Integer> A) {

		Integer firstElement = A.get(0);
		if (firstElement == 0) {
			countZeros[0] = 1;
		}

		for (int j = 1; j < A.size(); j++) {
			if (A.get(j) == 0) {
				countZeros[j] = countZeros[j - 1] + 1;
			} else {
				countZeros[j] = countZeros[j - 1];
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(0);
		A.add(0);
		A.add(0);
		A.add(1);

		ArrayList<ArrayList<Integer>> B = new ArrayList<>();
		ArrayList<Integer> q1 = new ArrayList<Integer>() {
			{
				add(2);
				add(4);
			}
		};
		ArrayList<Integer> q2 = new ArrayList<Integer>() {
			{
				add(1);
				add(5);
			}
		};
		ArrayList<Integer> q3 = new ArrayList<Integer>() {
			{
				add(3);
				add(5);
			}
		};
		B.add(q1);
		B.add(q2);
		B.add(q3);

		ArrayList<ArrayList<Integer>> result = solve(A, B);
		for (ArrayList<Integer> list : result) {
			System.out.println(list.toString());
		}
	}
}
