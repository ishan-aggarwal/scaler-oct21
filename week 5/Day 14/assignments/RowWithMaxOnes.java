package day14.assignments;

import java.util.ArrayList;

public class RowWithMaxOnes {
	public static int solve(ArrayList<ArrayList<Integer>> A) {

		int rows = A.size();
		int cols = A.get(0).size();

		int i = 0, j = cols - 1;
		int ans = -1;
		while (i < rows && j >= 0) {

			if (A.get(i).get(j) == 1) {
				j--;
				ans = (i + 1);
			} else {
				i++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();

		ArrayList<Integer> row1 = new ArrayList<>();
		row1.add(0);
		row1.add(1);
		row1.add(1);

		ArrayList<Integer> row2 = new ArrayList<>();
		row2.add(0);
		row2.add(0);
		row2.add(1);

		ArrayList<Integer> row3 = new ArrayList<>();
		row3.add(0);
		row3.add(1);
		row3.add(1);

		A.add(row1);
		A.add(row2);
		A.add(row3);

		System.out.println(solve(A));

	}
}
