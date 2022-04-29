package week28.day73.assignment;

public class Sixlets_Scaler {
	private static int sixlets(int a[], int i, int sum, int cnt) {
		if (sum > 1000)
			return 0;
		if (cnt == 0)
			return 1;
		if (i == a.length)
			return 0;
		// Take ith element or leave it.
		return sixlets(a, i + 1, sum, cnt) + sixlets(a, i + 1, sum + a[i], cnt - 1);
	}

	public static int solve(int[] A, int B) {
		return sixlets(A, 0, 0, B);
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, 8 };
		int B = 2;
		System.out.println(solve(A, B));
	}
}