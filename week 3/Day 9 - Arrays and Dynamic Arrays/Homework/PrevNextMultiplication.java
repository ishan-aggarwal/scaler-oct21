//Given an array of integers A, update every element with multiplication of previous and next
//elements with following exceptions.
//a) First element is replaced by multiplication of first and second.
//b) Last element is replaced by multiplication of last and second last.
//
//
//
//Input Format
//
//The only argument given is the integer array A.
//Output Format
//
//Return the updated array.
//Constraints
//
//1 <= length of the array <= 100000
//-10^4 <= A[i] <= 10^4 
//For Example
//
//Input 1:
//    A = [1, 2, 3, 4, 5]
//Output 1:
//    [2, 3, 8, 15, 20]
//
//Input 2:
//    A = [5, 17, 100, 11]
//Output 2:
//    [85, 500, 187, 1100]

package day9.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class PrevNextMultiplication {
	public static ArrayList<Integer> solve(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int size = A.size();
		int element = 0;

		// base case when size is 0 return empty array as res
		if (size == 0) {
			return result;
		}

		// base case when size is 1, return the same element as res
		if (size == 1) {
			result.add(A.get(0));
			return result;
		}

		// take product of first and second element
		int first = A.get(0) * A.get(1);

		// take the product of last two elements
		int last = A.get(size - 2) * A.get(size - 1);

		// add the first element to the result
		result.add(first);

		// base condition when size is 2
		if (size == 2) {
			result.add(last);
			return result;
		}

		for (int i = 1; i < size - 1; i++) {
			element = A.get(i - 1) * A.get(i + 1);
			result.add(element);
		}

		result.add(last);
		return result;
	}

	public static void main(String[] args) {

		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(solve(A));

	}
}
