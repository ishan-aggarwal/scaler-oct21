//Q2. First Repeating element
//Problem Description
//
//Given an integer array A of size N, find the first repeating element in it.
//
//We need to find the element that occurs more than once and whose index of first occurrence is smallest.
//
//If there is no repeating element, return -1.
//
//
//
//Problem Constraints
//
//1 <= N <= 105
//
//1 <= A[i] <= 109
//
//
//
//Input Format
//
//First and only argument is an integer array A of size N.
//
//
//
//Output Format
//
//Return an integer denoting the first repeating element.
//
//
//
//Example Input
//
//Input 1:
//
// A = [10, 5, 3, 4, 3, 5, 6]
//Input 2:
//
// A = [6, 10, 5, 4, 9, 120]
//
//
//Example Output
//
//Output 1:
//
// 5
//Output 2:
//
// -1
//
//
//Example Explanation
//
//Explanation 1:
//
// 5 is the first element that repeats
//Explanation 2:
//
// There is no repeating element, output -1

package day20.assignments;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstRepeatingElement {
	public static int solve(List<Integer> A) {

		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (Integer ele : A) {
			frequencyMap.put(ele, frequencyMap.getOrDefault(ele, 0) + 1);
		}

		for (Integer ele : A) {
			if (frequencyMap.get(ele) >= 2) {
				return ele;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Integer[] A = { 10, 5, 3, 4, 3, 5, 6 };
		List<Integer> list = Arrays.asList(A);
		System.out.println(solve(list));

	}
}
