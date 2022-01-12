package second;

import java.util.Arrays;

public class LittlePonyTaxSaving {
	public static int solve(int[] A, int[] B) {

		int n = A.length;
		int[][] input = new int[n][2];
		long answer = 0;

		int modulo = 1000000007;
		int count = 0;
		for (int i = 0; i < n; i++) {
			input[i][count++] = A[i];
			input[i][count++] = B[i];
			count = 0;
		}

		Arrays.sort(input, (int[] first, int[] second) -> {
			return first[0] * second[1] - first[1] * second[0];
		});

		int[] postFixSum = new int[n];
		postFixSum[n - 1] = input[n - 1][1];
		for (int i = input.length - 2; i >= 0; i--) {
			postFixSum[i] = postFixSum[i + 1] + input[i][1];
		}

		for (int i = 0; i < input.length; i++) {
			answer += input[i][0] * postFixSum[i];
			answer = answer % modulo;
		}

		return (int) answer;
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 2 };
		int[] B = { 1, 2, 2 };

		System.out.println(solve(A, B));
	}
}
