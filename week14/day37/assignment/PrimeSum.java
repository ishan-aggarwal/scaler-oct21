package day37.assignment;

//Q2. Prime Sum
//Problem Description
//
//Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
//
//If there are more than one solutions possible, return the lexicographically smaller solution.
//
//If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
//[a, b] < [c, d], If a < c OR a==c AND b < d. 
//NOTE: A solution will always exist. Read Goldbach's conjecture.
//
//
//
//Problem Constraints
//
//4 <= A <= 2*107
//
//
//
//Input Format
//
//First and only argument of input is an even number A.
//
//
//
//Output Format
//
//Return a integer array of size 2 containing primes whose sum will be equal to given number.
//
//
//
//Example Input
//
// 4
//
//
//Example Output
//
// [2, 2]
//
//
//Example Explanation
//
// There is only 1 solution for A = 4.

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSum {
	public static ArrayList<Integer> primesum(int A) {

		ArrayList<Integer> answer = new ArrayList<>();
		boolean[] isPrime = new boolean[A + 1];
		// set isPrime array to true
		Arrays.fill(isPrime, true);

		// prepare the isPrime array
		for (int i = 2; i * i < A + 1; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j < A + 1; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// now check for i and (A-i) if both are prime...
		// i would be the smallest prime so no need to sort the results if we find one
		for (int i = 2; i < A + 1; i++) {
			int other = A - i;
			if (isPrime[i] && isPrime[other]) {
				answer.add(i);
				answer.add(other);
				return answer;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		ArrayList<Integer> answer = primesum(4);
		answer.stream().forEach(System.out::println);
	}
}
