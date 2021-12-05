//Q1. Common Elements
//Problem Description
//
//Given two integer array A and B of size N and M respectively. Your task is to find all the common elements in both the array.
//
//NOTE:
//
//Each element in the result should appear as many times as it shows in both arrays.
//The result can be in any order.
//
//
//Problem Constraints
//
//1 <= N, M <= 105
//
//1 <= A[i] <= 109
//
//
//
//Input Format
//
//First argument is an integer array A of size N.
//
//Second argument is an integer array B of size M.
//
//
//
//Output Format
//
//Return an integer array denoting the common elements.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 2, 2, 1]
// B = [2, 3, 1, 2]
//Input 2:
//
// A = [2, 1, 4, 10]
// B = [3, 6, 2, 10, 10]
//
//
//Example Output
//
//Output 1:
//
// [1, 2, 2]
//Output 2:
//
// [2, 10]
//
//
//Example Explanation
//
//Explanation 1:
//
// Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
//Explantion 2:
//
// Elements (2, 10) appears in both the array.

package day20.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonElements {
	public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		Map<Integer, Integer> freq = new HashMap<>();
		Set<Integer> s1 = new HashSet<>(A);
		Set<Integer> s2 = new HashSet<>(B);

		for (Integer ele : A) {
			if (s2.contains(ele)) {
				freq.put(ele, freq.getOrDefault(ele, 0) + 1);
			}
		}

		for (Integer ele : B) {
			if (s1.contains(ele)) {
				freq.put(ele, freq.get(ele) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			int totalInclusions = entry.getValue() / 2;
			for (int i = 1; i <= totalInclusions; i++) {
				result.add(entry.getKey());
			}
		}

		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
//		 A = [1, 2, 2, 1]
//	     B = [2, 3, 1, 2]

		ArrayList<Integer> A = new ArrayList<>();
		A.add(1);
		A.add(2);
		A.add(2);
		A.add(1);

		ArrayList<Integer> B = new ArrayList<>();
		B.add(2);
		B.add(3);
		B.add(1);
		B.add(2);

		ArrayList<Integer> result = solve(A, B);
		System.out.println(result);
		
//		 A = [2, 1, 4, 10]
//		 B = [3, 6, 2, 10, 10]

	}
}
