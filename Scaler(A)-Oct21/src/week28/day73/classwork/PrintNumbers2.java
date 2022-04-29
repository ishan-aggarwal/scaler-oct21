package week28.day73.classwork;

import java.util.ArrayList;
import java.util.Arrays;

//Q1. Print all N digit numbers using {1, 2}
// N = 1 then {1} , {2}, {3}, {4}, {5}

public class PrintNumbers2 {

	public static void print(int n) {
		int[] curr = new int[n];
		generate(0, n, curr);
	}

	// TC - N * 5 ^ N (total results would be 5^N)
	// SC - O(N) - stack size + O(N) - list size
	private static void generate(int idx, int n, int[] curr) {
		if (n == 0) {
			System.out.println(Arrays.toString(curr)); // TC - O(N)
			return;
		}
		for (int i = 1; i <= 5; i++) {
			curr[idx] = i;
			generate(idx + 1, n - 1, curr);
		}
	}

	public static void print1(int n) {
		ArrayList<Integer> curr = new ArrayList<Integer>();
		generate1(0, n, curr);
	}

	// same can be done without idx also as we are no longer using idx
	private static void generate1(int idx, int n, ArrayList<Integer> curr) {
		if (n == 0) {
			System.out.println(curr); // TC - O(N)
			return;
		}

		for (int i = 1; i <= 5; i++) {
//			curr.add(i);
			curr.add(idx, i);
			generate1(idx + 1, n - 1, curr);
			curr.remove(curr.size() - 1);
		}
	}

	public static void main(String[] args) {
		print(2);
		System.out.println();
		print1(2);
	}
}
