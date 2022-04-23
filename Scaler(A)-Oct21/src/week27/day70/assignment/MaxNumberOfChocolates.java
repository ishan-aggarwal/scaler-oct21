package week27.day70.assignment;

import java.util.Collections;
import java.util.PriorityQueue;

//Q1. Magician and Chocolates
//Problem Description
//Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
//In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
//
//Find the maximum number of chocolates that the kid can eat in A units of time.
//
//NOTE:
//
//floor() function returns the largest integer less than or equal to a given number.
//Return your answer modulo 109+7
//
//
//Problem Constraints
//1 <= N <= 100000
//0 <= B[i] <= INT_MAX
//0 <= A <= 105
//
//
//
//Input Format
//The first argument is an integer A.
//The second argument is an integer array B of size N.
//
//
//
//Output Format
//Return an integer denoting the maximum number of chocolates the kid can eat in A units of time.
//
//
//
//Example Input
//Input 1:
//
// A = 3
// B = [6, 5]
//Input 2:
//
// A = 5
// b = [2, 4, 6, 8, 10]
//
//
//Example Output
//Output 1:
//
// 14
//Output 2:
//
// 33
//
//
//Example Explanation
//Explanation 1:
//
// At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates. 
// At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates. 
// At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate. 
// so, total number of chocolates eaten are 6 + 5 + 3 = 14
//Explanation 2:
//
// Maximum number of chocolates that can be eaten is 33.

public class MaxNumberOfChocolates {
	public static int nchoc1(int A, int[] B) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int x : B) {
			pq.add(x);
		}
		long ans = 0;
		long mod = 1000000007;
		while (A-- > 0) {
			int maxElement = pq.poll();
			ans += (maxElement) % mod;
			pq.add((int) Math.floor(maxElement / 2));

		}
		ans %= mod;
		return (int) ans;
	}

	public static int nchoc(int A, int[] B) {

		int n = B.length;
		for (int i = (n >> 1); i > 0; i--) {
			heapify(B, n, i);
		}

		long ans = 0;
		long m = 1000000007;

		while (A != 0 && B[0] != 0) {
			ans = (ans + B[0]) % m;
			B[0] = B[0] >> 1;
			heapify(B, n, 1);
			A--;
		}
		return (int) ans;
	}

	static void heapify(int[] arr, int n, int index) {
		while ((index << 1) <= n) {
			int left = index << 1;
			int right = (index << 1) + 1;

			if (right <= n) {
				if (arr[index - 1] < arr[left - 1] && arr[left - 1] > arr[right - 1]) {
					swap(arr, index - 1, left - 1);
					index = left;
				} else if (arr[index - 1] < arr[right - 1]) {
					swap(arr, index - 1, right - 1);
					index = right;
				} else
					break;
			} else {
				if (arr[index - 1] < arr[left - 1])
					swap(arr, index - 1, left - 1);
				break;
			}
		}
	}

	static void swap(int[] arr, int index1, int index2) {
		arr[index1] = arr[index1] ^ arr[index2];
		arr[index2] = arr[index1] ^ arr[index2];
		arr[index1] = arr[index1] ^ arr[index2];
	}

	public static void main(String[] args) {
		int A = 5;
		int[] B = { 2, 4, 6, 8, 10 };
		System.out.println(nchoc(A, B));
		System.out.println(nchoc1(A, B));
	}
}