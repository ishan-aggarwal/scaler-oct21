package day45.homework;

import java.util.HashSet;
import java.util.Set;

//Q1. Unique Elements

//Problem Description
//
//You are given an array A of N elements. You have to make all elements unique, to do so in one step you can increase any number by one.
//
//Find the minimum number of steps.
//
//
//
//Problem Constraints
//
//1 <= N <= 105
//1 <= A[i] <= 109
//
//
//
//Input Format
//
//The only argument given is an Array A, having N integers.
//
//
//
//Output Format
//
//Return the Minimum number of steps required to make all elements unique.
//
//
//
//Example Input
//
//Input 1:
//
// A = [1, 1, 3]
//Input 2:
//
// A = [2, 4, 5]
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
// We can increase the value of 1st element by 1 in 1 step and will get all unique elements. i.e [2, 1, 3].
//Explanation 2:
//
// All elements are distinct.
//
//
//See Expected Output
//Your input
//4 1 1 2 3
//Output
//3

public class CountStepsToMakeUniqueElements {
	public static int solve(int[] A) {
		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int x : A) {
			if (!set.contains(x)) {
				set.add(x);
			} else {
				while (set.contains(x)) {
					x = x + 1;
					count++;
				}
				set.add(x);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] A = { 1, 1, 3 };
		System.out.println(solve(A));

		int[] B = { 2, 4, 5 };
		System.out.println(solve(B));

		int[] C = { 1, 1, 2, 3 };
		System.out.println(solve(C));
	}
}
