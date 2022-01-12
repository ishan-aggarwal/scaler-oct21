package first;

// https://www.scaler.com/test/ee67a73385/?signature=BAhpA%2BC3FQ%3D%3D--7f18a69fc221ce80ba06cf64a570c1b21101ffe0#/index

import java.util.ArrayList;

public class TravellingBusinessman {

	public static ArrayList<Integer> solve(int A) {
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < A; i++) {
			result.add((i + 1) * (A - i));
		}
		return result;
	}

	public static void main(String[] args) {
		int A = 4;
		ArrayList<Integer> ans = solve(A);
		System.out.println(ans);

		System.out.println(solve(3));
	}

}
