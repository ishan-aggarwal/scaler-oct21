//You are given an Array A of size N.
//
//Find for how many elements, there is a strictly smaller element and a strictly greater element.
//
//
//
//Input Format
//
//Given only argument A an Array of Integers.
//Output Format
//
//Return an Integer X, i.e number of elements.
//Constraints
//
//1 <= N <= 1e5
//1 <= A[i] <= 1e6
//For Example
//
//Example Input:
//    A = [1, 2, 3]
//    
//Example Output:
//    1
//   
//Explanation:
//    only 2 have a strictly smaller and strictly greater element, 1 and 3 respectively.

package day4.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class SmallerAndGreater {
	public static int solve(ArrayList<Integer> A) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		int count = 0;
		for (int ele : A) {
			if (ele > max) {
				max = ele;
			}
			if (ele < min) {
				min = ele;
			}
		}

		for (int ele : A) {
			if (ele < max && ele > min) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(1, 2, 3));
		System.out.println(solve(A));
	}
}
