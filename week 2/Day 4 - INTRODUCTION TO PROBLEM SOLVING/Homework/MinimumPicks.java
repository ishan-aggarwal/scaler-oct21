//Problem Description
//
//You are given an array of integers A of size N.
//Return the difference between the maximum among all even numbers of A and the minimum among all odd numbers in A.
//
//
//
//Problem Constraints
//2 <= N <= 1e5
//-1e9 <= A[i] <= 1e9
//There is atleast 1 odd and 1 even number in A
//
//
//
//Input Format
//The first argument given is the integer array, A.
//
//
//
//Output Format
//Return maximum among all even numbers of A - minimum among all odd numbers in A.
//
//
//
//Example Input
//Input 1:
//
// A = [0, 2, 9]
//Input 2:
//
// A = [5, 17, 100, 1]
//
//
//Example Output
//Output 1:
//
//-7
//Output 2:
//
//99
//
//
//Example Explanation
//Explanation 1:
//
//Maximum of all even numbers = 2
//Minimum of all odd numbers = 9
//ans = 2 - 9 = -7
//Explanation 2:
//
//Maximum of all even numbers = 100
//Minimum of all odd numbers = 1
//ans = 100 - 1 = 99

package day4.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumPicks {
	public static int solve(ArrayList<Integer> A) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int ele : A) {
			if (ele % 2 == 0) {
				max = (ele > max) ? ele : max;
			} else {
				min = (ele < min) ? ele : min;
			}
		}
		return (max - min);
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.addAll(Arrays.asList(0, 2, 9));
		System.out.println(solve(A));
	}
}
