package day37.assignment;

//Q4. Prime Subsequences

//Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.
//
//A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.
//
//
//
//Input Format
//
//The first argument given is an Array A, having N integers.
//Output Format
//
//Return an integer X, i.e number of Prime subsequences. 
//As X can be very large print X % (1000000007), here % is modulus operator.
//Constraints
//
//1 <= N <= 1e3
//1 <= A[i] <= 1e6
//For Example
//
//Input:
//    A = [1, 2, 3]
//Output:
//     3
//
//Explanation:
//    no. Subsequences      Prime subsequences
//    1.  [1]                     No
//    2.  [1, 2]                  No
//    3.  [1, 3]                  No
//    4.  [1, 2, 3]               No
//    5.  [2]                     Yes
//    6.  [2, 3]                  Yes
//    7.  [3]                     Yes
//    8.  []                      No
//
//    here we have 3 subsequences(5, 6, 7) those have only prime number(s). 

public class PrimeSubsequences {
	public static int solve(int[] A) {

		int modulo = 1000000007;
		int count = 0;
		for (int x : A) {
			if (isPrime(x)) {
				count++;
			}
		}
		return pow(2, count, modulo) - 1;
	}

	public static int pow(int A, int B, int C) {
		if (B == 0) {
			return 1 % C;
		}

		int answer = pow((int) ((1l * A % C * A % C) % C), B / 2, C);
		if (B % 2 != 0) {
			answer = (int) ((1l * (A % C) * (answer % C)) % C);
		}
		return answer;
	}

	public static boolean isPrime(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i * i <= N; i++) {
			if (N % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 3 };
		System.out.println(solve(A));
	}
}
