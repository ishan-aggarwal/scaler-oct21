package week29.day75.classwork;

//Q4. Coin Change - 1 (Unboxed and many others)
//Given some coins with their values & a value k.
//Count the number of getting the sum k by using the coins.
//One coin can be used multiple times

public class CoinChange1Recursion {

	// let length of coins array be n
	// TC - O(n^k)
	// SC - O(k)
	public static int countWays(int[] coins, int k) {

		if (k < 0)
			return 0;

		if (k == 0)
			return 1;

		int count = 0;
		for (int i = 0; i < coins.length; i++) {
			count += countWays(coins, k - coins[i]);
		}

		return count;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 7 };
		System.out.println(countWays(coins, 3));
		System.out.println(countWays(coins, 7));
	}
}
