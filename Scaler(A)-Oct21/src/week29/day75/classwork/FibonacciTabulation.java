package week29.day75.classwork;

// Q1. Find Nth Fibonacci Term
// Bottom Up approach
// Start from solving the smallest sub problems using the already known results and move towards top
public class FibonacciTabulation {

	// TC - O(N) and
	// SC - O(N) for result array
	public static int fib(int n) {

		if (n <= 1) {
			return n;
		}

		int[] result = new int[n + 1];
		result[0] = 0;
		result[1] = 1;

		for (int i = 2; i <= n; i++) {
			result[i] = result[i - 1] + result[i - 2];
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
