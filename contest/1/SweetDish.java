package first;

// https://www.scaler.com/test/ee67a73385/?signature=BAhpA%2BC3FQ%3D%3D--7f18a69fc221ce80ba06cf64a570c1b21101ffe0#/index

import java.util.ArrayList;
import java.util.Arrays;

public class SweetDish {
	public static int solve(ArrayList<Integer> A, int B, int C) {

		int answer = 0;
		int n = A.size();

		boolean[] isPrime = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (checkPrime(A.get(i))) {
				isPrime[i] = true;
			}
		}

		for (int i = 1; i < (1 << n); i++) {
			long sum = 0;
			boolean containsPrime = false;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sum += A.get(j);
					if (isPrime[j] && !containsPrime) {
						containsPrime = true;
					}
				}
			}
			if ((sum >= B && sum <= C) && containsPrime) {
				answer++;
			}
		}
		return answer;
	}

	private static boolean checkPrime(Integer ele) {
		for (int i = 2; i * i <= ele; i++) {
			if (ele % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
//		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(2, 2, 4, 5));
//		int B = 3, C = 7;
//		System.out.println(solve(A, B, C));

		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(43, 13, 51, 97, 29));
		int B = 9, C = 136;
		System.out.println(solve(A, B, C));
	}
}
