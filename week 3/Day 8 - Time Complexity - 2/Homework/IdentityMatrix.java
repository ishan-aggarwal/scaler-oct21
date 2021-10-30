package day8.homework;

import java.util.ArrayList;
import java.util.List;

public class IdentityMatrix {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int solve(final List<ArrayList<Integer>> A) {

		int rows = A.size();
		int cols = A.get(0).size();
		int isIdentityMatrix = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == j) {
					if ((A.get(i)).get(j) != 1) {
						isIdentityMatrix = 0;
						break;
					}
				} else {
					if ((A.get(i)).get(j) != 0) {
						isIdentityMatrix = 0;
						break;
					}
				}
			}
		}
		return isIdentityMatrix;
	}
}
