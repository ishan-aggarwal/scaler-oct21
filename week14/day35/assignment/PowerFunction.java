package day35.assignment;

//Q3. Implement Power Function

//Problem Description
//
//Implement pow(x, n) % d.
//In other words, given x, n and d,
//
//find (xn % d)
//
//Note that remainders on division cannot be negative. In other words, make sure the answer you return is non negative.
//
//Input : x = 2, n = 3, d = 3
//Output : 2
//
//2^3 % 3 = 8 % 3 = 2.

public class PowerFunction {
	public static int pow(int A, int B, int C) {
		if (B == 0) {
			return 1 % C;
		}

		if (A < 0 && B == 1) {
			return ((A % C) + C) % C;
		}

		int answer = pow((int) ((1l * A % C * A % C) % C), B / 2, C);

		if (B % 2 != 0) {
			answer = (int) ((1l * (A % C) * (answer % C)) % C);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(pow(2, 3, 3));
	}
}
