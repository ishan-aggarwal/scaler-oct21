package day9.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CopyArray {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public static ArrayList<Integer> solve(final List<Integer> A, int B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int num : A) {
			result.add(num + B);
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.addAll(Arrays.asList(1, 2, 3, 2, 1));
		System.out.println(solve(A, 3));
	}
}
