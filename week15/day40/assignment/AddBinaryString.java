package day40.assignment;

//Q4. Add Binary Strings

//Problem Description
//
//Given two binary strings, return their sum (also a binary string).
//Example:
//
//a = "100"
//
//b = "11"
//Return a + b = "111".

public class AddBinaryString {
	public static String addBinary(String A, String B) {
		int n = A.length();
		int m = B.length();

		StringBuilder result = new StringBuilder();
		int carry = 0;
		int i = n - 1, j = m - 1;

		while (i >= 0 || j >= 0) {
			int sum = 0;
			if (i >= 0) {
				sum += (A.charAt(i) - '0');
				i--;
			}

			if (j >= 0) {
				sum += (B.charAt(j) - '0');
				j--;
			}
			sum += carry;
			result.append(sum % 2);
			carry = sum / 2;
		}

		if (carry == 1) {
			result.append(1);
		}

		return result.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("100", "11"));
	}
}
