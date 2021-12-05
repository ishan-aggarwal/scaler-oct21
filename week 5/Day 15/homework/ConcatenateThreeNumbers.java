//Q2. Concatenate Three Numbers
//Problem Description
//
//Given three 2-digit integers, A, B and C, find out the minimum number that can be obtained by concatenating them in any order.
//
//Return the minimum result that can be obtained.
//
//
//
//Problem Constraints
//
//10 <= A, B, C <= 99
//
//
//
//Input Format
//
//The first argument of input contains an integer, A.
//
//The second argument of input contains an integer, B.
//
//The third argument of input contains an integer, C.
//
//
//
//Output Format
//
//Return an integer, representing the answer.
//
//
//
//Example Input
//
//Input 1:
//
// A = 10
// B = 20
// C = 30
//Input 2:
//
// A = 55
// B = 43
// C = 47 
//
//
//Example Output
//
//Output 1:
//
// 102030 
//Output 2:
//
// 434755 
//
//
//Example Explanation
//
//Explanation 1:
//
// 10 + 20 + 30 = 102030 
//Explanation 2:
//
// 43 + 47 + 55 = 434755 

package day15.homework;

public class ConcatenateThreeNumbers {
	public static int solve(int A, int B, int C) {

		String str = new String();
		int min, max;
		if (A == B && B == C) {
			str = "" + A + B + C;
		} else if (A == B || A == C || B == C) {
			min = Math.min(Math.min(A, B), C);
			max = Math.max(Math.max(A, B), C);
			int minCount = 0;
			if (A == min) {
				minCount++;
			}
			if (B == min) {
				minCount++;
			}
			if (C == min) {
				minCount++;
			}
			if (minCount == 2) {
				str = "" + min + min + max;
			} else {
				str = "" + min + max + max;
			}
		} else {
			min = Math.min(Math.min(A, B), C);
			max = Math.max(Math.max(A, B), C);
			str = "" + min;
			if (max != A && min != A) {
				str += A;
			} else if (max != B && min != B) {
				str += B;
			} else if (max != C && min != C) {
				str += C;
			}
			str += max;
		}
		return Integer.parseInt(str);
	}

	public static void main(String[] args) {
		System.out.println(solve(10, 20, 30));
	}
}
