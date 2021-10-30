//Problem Description
//
//Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.
//
//
//
//Problem Constraints
//0 <= A <= 109
//0 <= B <= 30
//
//
//
//Input Format
//First argument contains a single integer A. Second argument contains a single integer B.
//
//
//
//Output Format
//Return a single integer X.
//
//
//
//Example Input
//Input 1:
//
// A = 3
// B = 3
//Input 2:
//
// A = 15
// B = 2
//
//
//Example Output
//Output 1:
//
// 7
//Output 2:
//
// 12
//
//
//Example Explanation
//Explanation 1:
//
// 3 xor 7 = 4 which is minimum
//Explanation 2:
//
// 15 xor 12 = 3 which is minimum

package day6.homework;

public class SmallestXOR {
	public static int solve(int A, int B) {

		// let starting x be 0
		int x = 0;

		for (int i = 30; i >= 0; i--) {
			if (B == 0) {
				return x;
			}
			// check if ith bit of A is set or not
			if (((1 << i) & A) > 0) {
				// if the ith bit in A is set, set the ith bit in x also
				x |= (1 << i);
				// and reduce the number of bits in B by 1
				B--;
			}
		}

		// if we reach here, at this point x would be same as A...

		// now here it means that above loop is exhausted
		// we need to try for setting some more bits in x to make B zero
		for (int i = 0; i <= 30; i++) {
			if (B == 0) {
				return x;
			}
			if (((1 << i) & x) == 0) {
				x |= (1 << i);
				B--;
			}
		}
		return x;
	}

	public static void main(String[] args) {
		System.out.println(solve(15, 2));
	}
}
