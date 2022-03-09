package bfs;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private static int[] solve(int[] a) {
		int[] freq = new int[10];
		for (int x : a) {
			while (x != 0) {
				freq[x % 10]++;
				x /= 10;
			}
		}

		int max = 0;
		for (int x : freq) {
			max = Math.max(max, x);
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			if (max == freq[i]) {
				result.add(i);
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String[] args) {
		int[] a = { 25, 2, 3, 57, 38, 41 };
		int[] res = solve(a);
		for (int x : res) {
			System.out.print(x + " ");
		}
	}

}
