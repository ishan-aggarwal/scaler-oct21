//Q3. Closest MinMax
//
//Given an array A. Find the size of the smallest subarray such that it contains atleast one occurrence of the maximum value of the array
//
//and atleast one occurrence of the minimum value of the array.
//
//Problem Constraints
//
//1 <= |A| <= 2000
//
//Input Format
//
//First and only argument is vector A
//
//Output Format
//
//Return the length of the smallest subarray which has atleast one occurrence of minimum and maximum element of the array
//
//Example Input
//
//Input 1:
//
//A = [1, 3]
//Input 2:
//
//A = [2]
//
//
//Example Output
//
//Output 1:
//
// 2
//Output 2:
//
// 1
//
//
//Example Explanation
//
//Explanation 1:
//
// Only choice is to take both elements.
//Explanation 2:
//
// Take the whole array.

package day11.assignments;

import java.util.ArrayList;

public class ClosestMinMax {
	public static int solve(ArrayList<Integer> A) {

		int minDistance = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxPos = -1;
		int minPos = -1;

		for (int i = 0; i < A.size(); i++) {

			if (A.get(i) > max) {
				max = A.get(i);
			}
			if (A.get(i) < min) {
				min = A.get(i);
			}
		}

		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) == max) {
				maxPos = i;
			}

			if (A.get(i) == min) {
				minPos = i;
			}

			if (minPos != -1 && maxPos != -1) {
				minDistance = Math.min(minDistance, Math.abs(minPos - maxPos) + 1);
			}
		}
		return minDistance;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(1);
		list.add(-9);

		System.out.println(solve(list));
	}
}
