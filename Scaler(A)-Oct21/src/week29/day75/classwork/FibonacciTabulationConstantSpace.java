package week29.day75.classwork;

// Q1. Find Nth Fibonacci Term

public class FibonacciTabulationConstantSpace {

	// TC - O(N) and
	// SC - O(1) just using three variables now
	public static int fib(int n) {

		if (n <= 1) {
			return n;
		}

		int secondPrev = 0, prev = 1, current = secondPrev + prev;

		for (int i = 2; i <= n; i++) {
			current = secondPrev + prev;
			secondPrev = prev;
			prev = current;
		}

		return current;
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
