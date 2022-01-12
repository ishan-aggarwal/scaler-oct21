package first;

// https://www.scaler.com/test/ee67a73385/?signature=BAhpA%2BC3FQ%3D%3D--7f18a69fc221ce80ba06cf64a570c1b21101ffe0#/index

public class BusDilemma {

	public static int solve(int[] A, int B) {

		int ans = 0;
		int maxPS = A[0];
		int minPS = A[0];

		int sum = A[0];

		for (int i = 1; i < A.length; i++) {
			sum = sum + A[i];
			if (sum > maxPS) {
				maxPS = sum;
			}

			if (sum < minPS) {
				minPS = sum;
			}
		}

		if (maxPS > B || Math.abs(minPS) > B) {
			return ans;
		}

		// System.out.println(maxPS);
		// System.out.println(minPS);

		if (minPS > 0) {
			int minPeopleAtStart = 0;
			int maxPeopleAtStart = B - maxPS;
			ans = maxPeopleAtStart - minPeopleAtStart + 1;
		} else {
			int minPeopleAtStart = Math.abs(minPS);
			int maxPeopleAtStart = Math.min(B, B - maxPS);
			ans = maxPeopleAtStart - minPeopleAtStart + 1;
		}

		return ans;

	}

	public static void main(String[] args) {
		int[] A = { 2, 1, -3 };
		int B = 5;
		System.out.println(solve(A, B));

		int[] A1 = { -1, 1 };
		int B1 = 4;
		System.out.println(solve(A1, B1));

		int[] A2 = { 2, 4, 1, 2 };
		int B2 = 10;
		System.out.println(solve(A2, B2));
	}
}
