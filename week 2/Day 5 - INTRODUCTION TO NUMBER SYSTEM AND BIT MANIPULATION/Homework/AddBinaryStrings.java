//Problem Description
//
//Given two binary strings, return their sum (also a binary string).
//Example: ``` a = "100"
//
//b = "11" Return a + b = "111". ```
//

package day5.homework;

public class AddBinaryStrings {
	public static String addBinary(String A, String B) {
		int i = A.length() - 1;
		int j = B.length() - 1;

		String res = "";
		int sum = 0;
		while (i >= 0 || j >= 0 || sum == 1) {

			if (i >= 0) {
				sum = sum + (A.charAt(i) - '0');
			}

			if (j >= 0) {
				sum = sum + (B.charAt(j) - '0');
			}

			res = (char) (sum % 2 + '0') + res;
			sum = sum / 2;

			i--;
			j--;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(addBinary("100", "11"));
	}
}
