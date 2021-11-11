//Problem Description
//
//You are given an integer array A and an integer B. You have to print the same array after rotating it B times towards right.
//
//NOTE: You can use extra memory.
//
//
//
//Problem Constraints
//1 <= |A| <= 106
//
//1 <= A[i] <= 109
//
//1 <= B <= 109
//
//
//
//Input Format
//First line begins with an integer |A| denoting the length of array, and then |A| integers denote the array elements.
//Second line contains a single integer B
//
//
//Output Format
//Print an array of integers which is the Bth right rotation of input array A, on a separate line.
//
//
//
//Example Input
//Input 1:
//
// 4 1 2 3 4
// 2
//Input 2:
//
// 3 1 2 2
// 3
//
//
//Example Output
//Output 1:
//
// 3 4 1 2
//Output 2:
//
// 1 2 2
//
//
//Example Explanation
//Explanation 1:
//
// [1,2,3,4] => [4,1,2,3] => [3,4,1,2]
//Explanation 2:
//
//
// [1,2,2] => [2,1,2] => [2,2,1] => [1,2,2]
//

package day9.assignments;

import java.util.Scanner;

public class RotationGame {
	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output

		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();

		int[] input = new int[size];

		for (int i = 0; i < size; i++) {
			input[i] = scanner.nextInt();
		}

		int B = scanner.nextInt();

		// because after size rotations the array will become same as initial input
		// array
		B = B % size;

		for (int i = 0; i < size; i++) {
			if (i < B) {
				System.out.print(input[size - B + i] + " ");
			} else {
				System.out.print(input[i - B] + " ");
			}
		}
		System.out.println("==== Rotation using reverse technique ====");
		input = reverse(input, 0, size - 1);
		input = reverse(input, 0, B - 1);
		input = reverse(input, B, size - 1);

		for (int i = 0; i < size; i++) {
			System.out.print(input[i] + " ");
		}

	}

	private static int[] reverse(int[] a, int s, int e) {
		while (s < e) {
			a[s] = a[s] ^ a[e];
			a[e] = a[s] ^ a[e];
			a[s] = a[s] ^ a[e];
			s++;
			e--;
		}
		return a;
	}
}