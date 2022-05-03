package week29.day75.classwork;

import java.util.Arrays;

// Q1. Find Nth Fibonacci Term
// Top down approach
// remember the results for the problems that we already solved

public class FibonacciMemoization {

	static int[] result = new int[100];

	static {
		Arrays.fill(result, -1);
	}

	// TC - O(N) and
	// SC - O(N) for stack space and O(N) for result array
	public static int fib(int n) {

		if (n <= 1) {
			return n;
		}

		if (result[n] == -1) {
			result[n] = fib(n - 1) + fib(n - 2);
		}

		return result[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
		System.out.println(fib(7));
	}
}
