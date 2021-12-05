//Q1. Largest Number
//Problem Description
//
//Given a array A of non negative integers, arrange them such that they form the largest number.
//
//Note: The result may be very large, so you need to return a string instead of an integer.
//
//
//
//Problem Constraints
//
//1 <= len(A) <= 100000
//0 <= A[i] <= 2*109
//
//
//
//Input Format
//
//First argument is an array of integers.
//
//
//
//Output Format
//
//Return a string representing the largest number.
//
//
//
//Example Input
//
//Input 1:
//
// A = [3, 30, 34, 5, 9]
//Input 2:
//
// A = [2, 3, 9, 0]
//
//
//Example Output
//
//Output 1:
//
// "9534330"
//Output 2:
//
// "9320"
//
//
//Example Explanation
//
//Explanation 1:
//
// A = [3, 30, 34, 5, 9]
// Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
//Explanation 2:
//
// Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320. 

package day18.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber_Important {
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
	public static String largestNumber(final int[] A) {

		List<String> list = new ArrayList<>();

		for (int ele : A) {
			list.add(String.valueOf(ele));
		}

		boolean isAllZero = list.stream().allMatch(ele -> ele.equals("0"));
		if (isAllZero) {
			return "0";
		}

		Collections.sort(list, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

		int size = list.size();
		StringBuilder builder = new StringBuilder();
		for (int i = size - 1; i >= 0; i--) {
			builder.append(list.get(i));
		}

		return builder.toString();
	}

	public static void main(String[] args) {
		int[] A = { 3, 30, 34, 5, 9 };
		System.out.println(largestNumber(A));
	}
}
