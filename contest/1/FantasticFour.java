package first;

// https://www.scaler.com/test/ee67a73385/?signature=BAhpA%2BC3FQ%3D%3D--7f18a69fc221ce80ba06cf64a570c1b21101ffe0#/index

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FantasticFour {
	public static int solve(ArrayList<Integer> A) {

		Set<Integer> set = new HashSet<>();
		set.add(null);

		int totalOperations = 0;

		int countR1 = 0;
		int countR2 = 0;
		int countR3 = 0;

		for (int x : A) {
			if (x % 4 == 1) {
				countR1++;
			} else if (x % 4 == 2) {
				countR2++;
			} else if (x % 4 == 3) {
				countR3++;
			}
		}

		int minR1R3 = Math.min(countR1, countR3);

		totalOperations += minR1R3;

		countR1 = countR1 - minR1R3;
		countR3 = countR3 - minR1R3;

		int left = Math.max(countR1, countR3);

		if (left % 2 == 1) {
			return -1;
		}

		totalOperations += left / 2;
		countR2 = countR2 + left / 2;

		if (countR2 % 2 == 1) {
			return -1;
		}

		totalOperations += countR2 / 2;

		return totalOperations;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(3);
		A.add(4);
		A.add(4);
		A.add(2);
		A.add(2);

		System.out.println(solve(A));
	}
}
