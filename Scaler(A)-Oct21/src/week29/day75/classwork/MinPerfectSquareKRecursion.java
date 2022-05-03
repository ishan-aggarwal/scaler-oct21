package week29.day75.classwork;

//Q5. Minimum number of Perfect Square sum as K()
//Given a number K. Find the minimum number of perfect squares needed to achieve the sum K.
public class MinPerfectSquareKRecursion {


	public static int minPerfectSqaresSumAsN(int n) {

		if (n <= 0)
			return 0;

		// base cases
		if (n <= 3)
			return n;

		int ans = n;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			ans = Math.min(ans, 1 + minPerfectSqaresSumAsN(n - i * i));
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println("4  = " + minPerfectSqaresSumAsN(4));
		System.out.println("5  = " + minPerfectSqaresSumAsN(5));
		System.out.println("6  = " + minPerfectSqaresSumAsN(6));
		System.out.println("7  = " + minPerfectSqaresSumAsN(7));
		System.out.println("8  = " + minPerfectSqaresSumAsN(8));
		System.out.println("9  = " + minPerfectSqaresSumAsN(9));
		System.out.println("10 = " + minPerfectSqaresSumAsN(10));
		System.out.println("11 = " + minPerfectSqaresSumAsN(11));
		System.out.println("12 = " + minPerfectSqaresSumAsN(12));
	}
}
