package day14.classroom;

import java.util.ArrayList;

public class PrintMatrixBounday {
	public static void generateMatrix(ArrayList<ArrayList<Integer>> A) {

		int rows = A.size();
		int cols = A.get(0).size();

		for (int j = 0; j < cols; j++) {
			System.out.print(A.get(0).get(j) + " ");
		}

		for (int i = 1; i < rows; i++) {
			System.out.print(A.get(i).get(cols - 1) + " ");
		}

		for (int j = cols - 2; j >= 0; j--) {
			System.out.print(A.get(rows - 1).get(j) + " ");
		}

		for (int i = rows - 2; i >= 1; i--) {
			System.out.print(A.get(i).get(0) + " ");
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
