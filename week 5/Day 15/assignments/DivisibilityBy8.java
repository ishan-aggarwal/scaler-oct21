//Q3. Divisibility by 8
//Given a number A in the form of string. Check if the number is divisible by 8 or not.
//
//Return 1 if it is divisible by 8 else return 0.
//
//
//Input Format
//
//The only argument given is string A.
//Output Format
//
//Return 1 if it is divisible by 8 else return 0.
//
//Constraints
//
//1 <= length of the String <= 100000
//'0' <= A[i] <= '9'
//For Example
//
//Input 1:
//    A = "16"
//Output 1:
//    1
//
//Input 2:
//    A = "123"
//Output 2:
//    0

package day15.assignments;

public class DivisibilityBy8 {
	public static int solve(String A) {

		int length = A.length();
		int num;
		if (length <= 3) {
			num = Integer.parseInt(A);
		} else {
			num = Integer.parseInt(A.substring(length - 3));
		}
		if (num % 8 == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(solve("123"));
	}
}
