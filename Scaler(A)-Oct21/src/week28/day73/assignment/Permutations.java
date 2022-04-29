package week28.day73.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Q4. Permutations
//Problem Description
//Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//
//NOTE:
//
//No two entries in the permutation sequence should be the same.
//For the purpose of this problem, assume that all the numbers in the collection are unique.
//Return the answer in any order
//WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
//If you do, we will disqualify your submission retroactively and give you penalty points.
//
//
//Problem Constraints
//1 <= N <= 9
//
//
//
//Input Format
//Only argument is an integer array A of size N.
//
//
//
//Output Format
//Return a 2-D array denoting all possible permutation of the array.
//
//
//
//Example Input
//A = [1, 2, 3]
//
//
//Example Output
//[ [1, 2, 3]
//  [1, 3, 2]
//  [2, 1, 3] 
//  [2, 3, 1] 
//  [3, 1, 2] 
//  [3, 2, 1] ]
//
//
//Example Explanation
//All the possible permutation of array [1, 2, 3].

public class Permutations {

	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> current = new ArrayList<Integer>(A);
		int start = 0;

		// parameter required are - start index, current, answer and input list
		compute1(start, current, answer, A);
		return answer;
	}

	public static void compute1(int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> answer,
			ArrayList<Integer> A) {
		if (index == A.size()) {
			answer.add(new ArrayList<>(current));
			return;
		}

		for (int j = index; j < A.size(); j++) {
			Collections.swap(current, j, index); // do swap step
			compute1(index + 1, current, answer, A);
			Collections.swap(current, j, index); // undo swap step
		}
	}

	public static void compute(int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> answer,
			ArrayList<Integer> A) {

		// base condition
		if (index == A.size()) {
			answer.add(new ArrayList<>(current));
			return;
		}

		// iterate from current index to last element and get element from next position
		// to index position
		for (int j = index; j < A.size(); j++) {
			// do swap step
			swap(index, j, current);
			// Recursion call for next index elements - solving subproblem
			compute(index + 1, current, answer, A);
			// UNDO swap step - restore original condition
			swap(index, j, current);
		}
	}

	// swapping list elements
	public static void swap(int src, int dest, ArrayList<Integer> A) {
		int temp = A.get(src);
		A.set(src, A.get(dest));
		A.set(dest, temp);
	}

	public static void genList(int index, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> answer,
			ArrayList<Integer> A) {
		if (index == A.size()) {
			answer.add(new ArrayList<>(current));
			return;
		}

		for (int j = index; j < A.size(); j++) {
			Collections.swap(current, j, index);
			genList(index + 1, current, answer, A);
			Collections.swap(current, j, index);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		System.out.println(permute(A));
	}
}
