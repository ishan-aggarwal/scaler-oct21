package day34.homework;

//Q4. Spiral Order Matrix II

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

public class SpiralOrderMatrix2 {
	public static int[][] generateMatrix(int A) {

		int[][] result = new int[A][A];
		int value = 1;

		int top = 0, left = 0, bottom = A - 1, right = A - 1;
		while (left <= right && top <= bottom) {

			for (int i = left; i <= right; i++) {
				result[top][i] = value++;
			}
			top++;

			for (int j = top; j <= bottom; j++) {
				result[j][right] = value++;
			}
			right--;

			for (int k = right; k >= left; k--) {
				result[bottom][k] = value++;
			}
			bottom--;

			for (int l = bottom; l >= top; l--) {
				result[l][left] = value++;
			}
			left++;

		}

		return result;
	}

	public static void main(String[] args) {
		int[][] result = generateMatrix(5);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
		}
	}
}
