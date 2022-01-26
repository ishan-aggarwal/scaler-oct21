package day35.assignment;

//Q1. Rearrange Array

//Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
//
//Example:
//
//Input : [1, 0]
//Return : [0, 1]
//Lets say N = size of the array. Then, following holds true :
//
//All elements in the array are in the range [0, N-1]
//N * N does not overflow for a signed integer

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {
	public static void arrange(ArrayList<Integer> A) {

		int N = A.size();
		for (int i = 0; i < N; i++) {
			A.set(i, A.get(i) * N);
		}

		for (int i = 0; i < N; i++) {
			int index = A.get(i) / N;
			int newValue = A.get(index) / N;
			A.set(i, A.get(i) + newValue);
		}

		for (int i = 0; i < N; i++) {
			A.set(i, A.get(i) % N);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 2, 0, 1));
		arrange(A);
		A.stream().forEach(System.out::println);
	}
}
