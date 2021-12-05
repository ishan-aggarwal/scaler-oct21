package day16.classroom;

public class HungerGame {

	public static void main(String[] args) {
		int n = 100;
		int res = getLastManStanding(n);
		System.out.println(res);
	}

	private static int getLastManStanding(int number) {

		// 2^k <= N
		// x = N - 2^k
		// 2 (x) + 1

		int k = (int) (Math.log(number) / Math.log(2));
		int x = (int) (number - Math.pow(2, k));
		return 2 * x + 1;
	}

}
