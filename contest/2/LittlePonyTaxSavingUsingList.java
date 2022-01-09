package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LittlePonyTaxSavingUsingList {
	public static int solve(int[] A, int[] B) {

		int n = A.length;
		List<List<Integer>> input = new ArrayList<>();
		long answer = 0;

		int modulo = 1000000007;
		for (int i = 0; i < n; i++) {
			input.add(i, new ArrayList<>(Arrays.asList(A[i], B[i])));
		}

		Collections.sort(input, new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> first, List<Integer> second) {
//				return first.get(0) * second.get(1) - second.get(0) * first.get(1);
				long firstRes = first.get(0) * second.get(1);
				long secondRes = second.get(0) * first.get(1);
				return (int) (firstRes - secondRes);
			}
		});

//		Collections.sort(input, (List<Integer> first, List<Integer> second) -> {
//			return first.get(0) * second.get(1) - second.get(0) * first.get(1);
//		});

		int[] postFixSum = new int[n];
		postFixSum[n - 1] = input.get(input.size() - 1).get(1);
		for (int i = input.size() - 2; i >= 0; i--) {
			postFixSum[i] = postFixSum[i + 1] + input.get(i).get(1);
		}

		for (int i = 0; i < input.size(); i++) {
			answer += input.get(i).get(0) * postFixSum[i];
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
