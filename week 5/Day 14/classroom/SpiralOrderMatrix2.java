package day14.classroom;

import java.util.ArrayList;

public class SpiralOrderMatrix2 {
	public static void generateMatrix(ArrayList<ArrayList<Integer>> A) {

		int rows = A.size();
		int cols = A.get(0).size();

		int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

		while (top <= bottom && left <= right) {

			for (int j = left; j <= right; j++) {
				System.out.print(A.get(top).get(j) + " ");
			}
			top++;

			for (int i = top; i <= bottom; i++) {
				System.out.print(A.get(i).get(right) + " ");
			}
			right--;

			for (int j = right; j >= left; j--) {
				System.out.print(A.get(bottom).get(j) + " ");
			}
			bottom--;

			for (int i = bottom; i >= top; i--) {
				System.out.print(A.get(i).get(left) + " ");
			}
			left++;
		}
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();

		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(1);
		row1.add(2);
		row1.add(3);
		row1.add(4);

		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(5);
		row2.add(6);
		row2.add(7);
		row2.add(8);

		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(9);
		row3.add(10);
		row3.add(11);
		row3.add(12);

		ArrayList<Integer> row4 = new ArrayList<>();
		row4.add(13);
		row4.add(14);
		row4.add(15);
		row4.add(16);

		A.add(row1);
		A.add(row2);
		A.add(row3);
		A.add(row4);

		generateMatrix(A);

	}
}
