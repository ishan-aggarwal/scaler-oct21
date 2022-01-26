package day37.homework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Q4. Distinct Primes
//You have given an array A having N integers. Let say G is the product of all elements of A.
//
//You have to find the number of distinct prime divisors of G.
//
//
//
//Input Format
//
//The first argument given is an Array A, having N integers.
//Output Format
//
//Return an Integer, i.e number of distinct prime divisors of G.
//Constraints
//
//1 <= N <= 1e5
//1 <= A[i] <= 1e5
//For Example
//
//Input:
//    A = [1, 2, 3, 4]
//Output:
//     2
//
//Explanation:
//    here G = 1 * 2 * 3 * 4 = 24
//    and distinct prime divisors of G are [2, 3]

public class DistinctPrimes {
	public static int solve(int[] A) {

		int maxElement = findMax(A);
		boolean[] isPrime = new boolean[maxElement + 1];

		Arrays.fill(isPrime, true);
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i <= maxElement; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= maxElement; j += i) {
					isPrime[j] = false;
				}
			}
		}

		Set<Integer> primes = new HashSet<>();

		return primes.size();

	}

	private static int findMax(int[] A) {
		int maxElement = Integer.MIN_VALUE;
		for (int x : A) {
			maxElement = Math.max(maxElement, x);
		}
		return maxElement;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4 };
		System.out.println(solve(A));
	}
}
