package first;

import java.util.ArrayList;
import java.util.Arrays;

public class SweetDishOld {
	public static int solve(ArrayList<Integer> A, int B, int C) {

		int answer = 0;
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();

		int n = A.size();

		for (int i = 1; i < (1 << n); i++) {
			ArrayList<Integer> eachSubset = new ArrayList<>();
			long sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					eachSubset.add(A.get(j));
					sum += A.get(j);
				}
			}
			if (sum >= B && sum <= C) {
				subsets.add(eachSubset);
			}
		}

		for (ArrayList<Integer> eachSubset : subsets) {
			if (eachSubset.contains(1) || eachSubset.contains(2) || eachSubset.contains(3)
					|| containsPrime(eachSubset)) {
				answer++;
			}
		}
		return answer;
	}

	private static boolean containsPrime(ArrayList<Integer> eachSubset) {
		for (Integer ele : eachSubset) {
			if (checkPrime(ele)) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkPrime(Integer ele) {
		boolean res = false;
		if (ele % 2 == 0) {
			return res;
		}

		for (int i = 3; i <= Math.sqrt(ele); i += 2) {
			if (ele % i == 0) {
				return res;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 2, 4, 5));
		int B = 3, C = 7;
		System.out.println(solve(A, B, C));

	}
}
