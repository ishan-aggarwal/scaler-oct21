package day52.assignment;

import java.util.HashSet;
import java.util.Set;

// Problem - Count the number of distinct elements in the array

public class CountDistinctElements {

//	TC - O(N)
//	SC - O(N)
	private static int countUniqueElements(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (Integer x : A) {
			set.add(x);
		}
		return set.size();
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 6, 1, 2, 3, 9, 8, 6 };
		System.out.println(countUniqueElements(A));
	}

}
