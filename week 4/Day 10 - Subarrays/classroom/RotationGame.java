/*
 * Given an array of size N and a number k
 * Rotate the array by k position from right to left or left to right 
 * (using constant extra space)
 * 
 * Amazon, OLA, Airtel
 * 
 */

package day10.classroom;

import java.util.Arrays;
import java.util.List;

public class RotationGame {

	public static List<Integer> rightRotateByK(List<Integer> A, int k) {

		int size = A.size();
		k = k % size;

		rotate(A, 0, size - 1);
		rotate(A, 0, k - 1);
		rotate(A, k, size - 1);

		return A;
	}

	public static List<Integer> leftRotateByK(List<Integer> A, int k) {

		int size = A.size();
		k = k % size;

		rotate(A, 0, size - 1);
		rotate(A, 0, size - k - 1);
		rotate(A, size - k, size - 1);

		return A;
	}

	private static void rotate(List<Integer> A, int start, int end) {
		while (start < end) {
			int temp = A.get(start);
			A.set(start, A.get(end));
			A.set(end, temp);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {

		Integer A[] = { 3, 7, 1, 6, 8, -2, 9 };
		Integer A1[] = { 3, 7, 1, 6, 8, -2, 9 };
		List<Integer> list = Arrays.asList(A);
		List<Integer> list1 = Arrays.asList(A1);
		int k = 3;

		System.out.println("========= Input list ===========");
		System.out.println(list.toString());

		System.out.println("======== rightRotateByK =========");
		System.out.println(rightRotateByK(list, k).toString());

		System.out.println("========= leftRotateByK ===========");
		System.out.println(leftRotateByK(list1, k).toString());

	}
}
