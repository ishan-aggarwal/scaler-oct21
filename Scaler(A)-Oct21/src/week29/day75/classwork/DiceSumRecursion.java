package week29.day75.classwork;

// Q3. Dice Sum
// Given one 6 faced dice and a number N.
// Count the number of ways to get a sum of N 
// if you can roll dice as many times as you want.
public class DiceSumRecursion {

	// TC - O(6^N)
	// SC - O(N)
	public static int countWays(int n) {

		if (n < 0)
			return 0;

		if (n <= 1)
			return 1;

		return countWays(n - 1) + countWays(n - 2) + countWays(n - 3) + countWays(n - 4) + countWays(n - 5)
				+ countWays(n - 6);
	}

	public static void main(String[] args) {
		System.out.println(countWays(1));
		System.out.println(countWays(2));
		System.out.println(countWays(3));
		System.out.println(countWays(4));
		System.out.println(countWays(5));
		System.out.println(countWays(6));
	}
}
