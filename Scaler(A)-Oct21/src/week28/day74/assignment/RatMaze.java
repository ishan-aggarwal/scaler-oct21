package week28.day74.assignment;

import java.util.ArrayList;
import java.util.Arrays;

//Q3. Rat In a Maze

//Problem Description
//
//Given a grid A, a rat is at position (1, 1). He wants to go to the position (n, n) where n is size of the square matrix A.
//
//1 represents a traversable cell and 0 represents a non-traversable cell. Rat can only move right or down.
//
//Return a path that the rat can take.
//
//
//
//Problem Constraints
//
//1 <= |A| <= 4
//
//
//
//Input Format
//
//First and only argument is the vector of vectors A.
//
//
//
//Output Format
//
//Return a vector of vectors that denotes a path that can be taken.
//
//
//
//Example Input
//
//Input 1:
//
//A = [   [1, 0]
//        [1, 1]
//    ]
//Input 2:
//
//A = [    [1, 1, 1]
//         [1, 0, 1]
//         [0, 0, 1]
//    ]
//
//
//Example Output
//
//Output 1:
//
//[   [1, 0]
//    [1, 1]
//]
//Output 2:
//
//[    [1, 1, 1]
//     [0, 0, 1]
//     [0, 0, 1]
//]
//
//
//Example Explanation
//
//Explanation 1:
//
// Path is shown in output.
//Explanation 2:
//
// Path is shown in output.

public class RatMaze {

	public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
		solveMaze(A, 0, 0, A.size());
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(0).size(); j++) {
				// change 2 to 1 for the cells where we marked visited to find the answer
				// before printing the final result
				if (A.get(i).get(j) == 2) {
					A.get(i).set(j, 1);
				}
			}
		}
		return A;
	}

	private boolean solveMaze(ArrayList<ArrayList<Integer>> a, int si, int sj, int size) {

		// check if we reached the end then return true
		if (si == size - 1 && sj == size - 1) {
			return true;
		}

		// check for boundary conditions and if outside of boundary return false
		if ((si < 0 || si >= size) || (sj < 0 || sj >= size)) {
			return false;
		}

		// non-traversable cell or already visited cell
		if (a.get(si).get(sj) == 0 || a.get(si).get(sj) == 2) {
			return false;
		}

		// int prev = a.get(si).get(sj);
		// mark current cell as visited (can set any value here)
		a.get(si).set(sj, 2);

		boolean dResult = solveMaze(a, si + 1, sj, size);
		if (!dResult && (si + 1 < size && sj < size)) {
			// marking the cell as 0 as it does not result in path
			a.get(si + 1).set(sj, 0);
		}

		boolean rResult = solveMaze(a, si, sj + 1, size);
		if (!rResult && (si < size && sj + 1 < size)) {
			// marking the cell as 0 as it does not result in path
			a.get(si).set(sj + 1, 0);
		}

		// mark non-visited - this step would be required when all paths are needed
		// in the final answer
		// a.get(si).set(sj, prev);

		return dResult || rResult;
	}

	public static void main(String args[]) {
		RatMaze rat = new RatMaze();
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
		A.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
		A.add(new ArrayList<>(Arrays.asList(0, 0, 1)));

		System.out.println(rat.solve(A));
	}
}