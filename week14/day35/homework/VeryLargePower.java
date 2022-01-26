package day35.homework;

//Q2. Very Large Power

//Problem Description
//
//Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
//
//"^" means power ,
//
//"%" means "mod", and
//
//"!" means factorial.
//
//
//
//Problem Constraints
//
//1 <= A, B <= 5e5
//
//
//
//Input Format
//
//First argument is the integer A
//
//Second argument is the integer B
//
//
//
//Output Format
//
//Return one integer, the answer to the problem
//
//
//
//Example Input
//
//Input 1:
//
//A = 1
//B = 1
//Input 2:
//
//A = 2
//B = 2
//
//
//Example Output
//
//Output 1:
//
//1
//Output 2:
//
//4
//
//
//Example Explanation
//
//Explanation 1:
//
// 1! = 1. Hence 1^1 = 1.
//Explanation 2:
//
// 2! = 2. Hence 2^2 = 4.

public class VeryLargePower {
	public static int solve(int A, int B) {

		int modulo = 1000000007;
		long factorialValue = fact(B, modulo);
		int power = (int) (factorialValue % (modulo - 1));

		int result = pow(A, power, modulo);

		return result;
	}

	public static int pow(int A, int B, int C) {
		if (B == 0) {
			return 1 % C;
		}
		int answer = pow((int) ((1l * A % C * A % C) % C), B / 2, C);
		if (B % 2 != 0) {
			answer = (int) ((1l * (A % C) * (answer % C)) % C);
		}
		return answer;
	}

	private static long fact(int B, int modulo) {
		long ans = 1L;
		int i = 1;
		while (i <= B) {
			ans = ans * i;
			ans = ans % (modulo - 1);
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int A = 2, B = 2;
		System.out.println(solve(A, B));
	}
}
