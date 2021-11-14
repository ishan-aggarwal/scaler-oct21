//Q3. Arithmetic Progression?
//
//Problem Description
//
//Given an integer array A of size N. Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0.
//
//A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
//
//
//
//Problem Constraints
//
//2 <= N <= 105
//
//-109 <= A[i] <= 109
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
//Return 1 if the array can be rearranged to form an arithmetic progression, otherwise, return 0
//
//
//
//Example Input
//
//Input 1:
//
// A = [3, 5, 1]
//Input 2:
//
// A = [2, 4, 1]
//
//
//Example Output
//
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//
//Explanation 1:
//
// We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
//Explanation 2:
//
// There is no way to reorder the elements to obtain an arithmetic progression.

package day11.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CheckAP {

	public static int solve(ArrayList<Integer> A) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int size = A.size();
		int difference = 0;
		int temp = 0;
		for (Integer element : A) {
			if (element > max) {
				max = element;
			}
			if (element < min) {
				min = element;
			}
		}

		difference = (max - min) / (size - 1);
		Set<Integer> elements = new HashSet<>(A);

		if (difference == 0 && elements.size() == 1) {
			return 1;
		}

		for (int i = 1; i <= size; i++) {
			temp = min + (i - 1) * difference;

			if (!elements.contains(temp)) {
				return 0;
			} else {
				elements.remove(temp);
			}
		}

		if (elements.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {

		ArrayList<Integer> input = new ArrayList<>();
		input.add(3);
		input.add(5);
		input.add(1);
		
		System.out.println(solve(input));
	}

}
