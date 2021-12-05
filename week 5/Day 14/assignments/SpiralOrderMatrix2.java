//Q3. Spiral Order Matrix II
//Problem Description
//
//Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
//
//
//
//Problem Constraints
//
//1 <= A <= 1000
//
//
//
//Input Format
//
//First and only argument is integer A
//
//
//Output Format
//
//Return a 2-D matrix which consists of the elements in spiral order.
//
//
//
//Example Input
//
//Input 1:
//
//1
//Input 2:
//
//2
//
//
//Example Output
//
//Output 1:
//
//[ [1] ]
//Output 2:
//
//[ [1, 2], [4, 3] ]
//
//
//Example Explanation
//
//Explanation 1:
//
// 
//Only 1 is to be arranged.
//Explanation 2:
//
//1 --> 2
//      |
//      |
//4<--- 3

package day14.assignments;

public class SpiralOrderMatrix2 {
	public static int[][] generateMatrix(int A) {

		int[][] spiral = new int[A][A];
		int value = 1;

		int left = 0;
		int right = A - 1;
		int top = 0;
		int bottom = A - 1;

		while (left <= right && top <= bottom) {

			for (int i = left; i <= right; i++) {
				spiral[top][i] = value;
				value++;
			}

			top++;

			for (int i = top; i <= bottom; i++) {
				spiral[i][right] = value;
				value++;
			}

			right--;

			for (int i = right; i >= left; i--) {
				spiral[bottom][i] = value;
				value++;
			}

			bottom--;

			for (int i = bottom; i >= top; i--) {
				spiral[i][left] = value;
				value++;
			}

			left++;
		}
		return spiral;

	}
}
