//Problem Description
//
//Reverse the bits of an 32 bit unsigned integer A.
//
//
//
//Problem Constraints
//0 <= A <= 232
//
//
//
//Input Format
//First and only argument of input contains an integer A.
//
//
//
//Output Format
//Return a single unsigned integer denoting the decimal value of reversed bits.
//
//
//
//Example Input
//Input 1:
//
// 0
//Input 2:
//
// 3
//
//
//Example Output
//Output 1:
//
// 0
//Output 2:
//
// 3221225472
//
//
//Example Explanation
//Explanation 1:
//
//        00000000000000000000000000000000
//
//=>      00000000000000000000000000000000
//Explanation 2:
//
//        00000000000000000000000000000011    
//=>      11000000000000000000000000000000

package day6.homework;

public class ReverseBits {
	public static long reverse(long a) {

		int[] temp = new int[32];

		for (int i = 0; i < 32; i++) {
			temp[i] = 0;
		}

		int i = 0;
		while (a != 0) {
			temp[i] = (int) (a % 2);
			a = a >> 1;
			i++;
		}

		long result = 0;
		int j = 31;
		for (i = 31; i >= 0; i--) {
			result += (temp[i] * Math.pow(2, j - i));
		}
		return result;

	}
	
	public static void main(String[] args) {
		System.out.println(reverse(3));
	}
}
