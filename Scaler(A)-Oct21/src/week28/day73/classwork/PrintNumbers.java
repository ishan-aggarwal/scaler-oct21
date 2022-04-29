package week28.day73.classwork;

import java.util.ArrayList;
import java.util.Arrays;

//Q1. Print all N digit numbers using {1, 2}
// N = 1 then {1} , {2}
// N = 2 then {1,1}, {1,2}, {2,1}, {2,2}

public class PrintNumbers {

	public static void print(int n) {
		int[] curr = new int[n];
		generate(0, n, curr);
	}

	// TC - N * 2 ^ N
	// SC - O(N) - stack size + O(N) - list size
	private static void generate(int idx, int n, int[] curr) {
		if (n == 0) {
			System.out.println(Arrays.toString(curr)); // TC - O(N)
			return;
		}
		curr[idx] = 1;
		generate(idx + 1, n - 1, curr);
		curr[idx] = 2;
		generate(idx + 1, n - 1, curr);
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

//		curr.add(idx, 1);
		curr.add(1);
		generate1(idx + 1, n - 1, curr);
		curr.remove(curr.size() - 1);

//		curr.add(idx, 2);
		curr.add(2);
		generate1(idx + 1, n - 1, curr);
		curr.remove(curr.size() - 1);
	}

	public static void main(String[] args) {
		print(2);
		System.out.println();
		print1(2);
	}
}
