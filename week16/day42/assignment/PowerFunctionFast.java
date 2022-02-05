package day42.assignment;

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

public class PowerFunctionFast {
	public static int pow(int A, int B, int C) {

		// base case - remember to take modulo with C
		if (B == 0) {
			return (1 % C);
		}

		// in case A is negative or zero, we need to add C before returning the answer
		if (A <= 1 && B == 1) {
			return (A + C) % C;
		}

		// calculate halfpower and store in long
		long halfAns = (1l * pow(A, B / 2, C)) % C;

		// compute the ans using halfpower and store in long by multiplying the
		// calculations with 1l to avoid overflow
		long ans = (1l * halfAns % C * halfAns % C) % C;

		// finally if B is odd again multiply with 1 more a
		if (B % 2 == 1) {
			ans = (1l * A % C * ans % C) % C;
		}

		// finally return the int value of answer
		return (int) ans;
	}

	public static void main(String[] args) {
		System.out.println(pow(2, 3, 3));
	}
}
