package week28.day74.classwork;

//Q2. Rat in a maze (Google)

// Given the maze and start point of rat (si, sj)
// end point of the rat (ei, ej)
// blocked cells - 1
// cells filled with cheese - 0
// empty cell - can have any value
// Count the number of paths from start to end such that the rat can 
// eat all the cheese present in the maze without stepping
// on the same cell twice in the path.

public class RatMaze2 {

	// TC for this solution would be - 4 ^ (N*M)
	// because after visiting the current entire path we are making the cells reset
	// to their previous state
	// since we can move in four directions from every cell there are four
	// possibilities
	int solveMaze(int maze[][], int si, int sj, int ei, int ej) {

		int totalCheese = 0;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] == 0) {
					totalCheese += 1;
				}
			}
		}

		int currCheese = 0;
		return solveMazeUtil(maze, maze.length, maze[0].length, si, sj, ei, ej, totalCheese, currCheese);
	}

	private int solveMazeUtil(int maze[][], int n, int m, int si, int sj, int ei, int ej, int totalCheese,
			int currCheese) {

		// if we have reached the end
		if (si == ei && sj == ej) {
			// return 1 only if we have eaten the entire cheese
			if (totalCheese == currCheese) {
				return 1;
			} else {
				return 0;
			}
		}

		// in case we are crossing the maze boundaries
		if ((si < 0 || si >= n) || (sj < 0 || sj >= m)) {
			return 0;
		}

		// if it blocked cell - 1
		// if it is already visited cell - 2
		if (maze[si][sj] == 1 || maze[si][sj] == -1) {
			return 0;
		}

		// store the current maze state so that it can be restored for other paths
		int prevState = maze[si][sj];
		maze[si][sj] = -1;

		// increasing running count of cheese by 1 only if the current cell has a cheese
		// in it.
		int ans = solveMazeUtil(maze, n, m, si + 1, sj, ei, ej, totalCheese,
				(prevState == 0) ? currCheese + 1 : currCheese)
				+ solveMazeUtil(maze, n, m, si - 1, sj, ei, ej, totalCheese,
						(prevState == 0) ? currCheese + 1 : currCheese)
				+ solveMazeUtil(maze, n, m, si, sj + 1, ei, ej, totalCheese,
						(prevState == 0) ? currCheese + 1 : currCheese)
				+ solveMazeUtil(maze, n, m, si, sj - 1, ei, ej, totalCheese,
						(prevState == 0) ? currCheese + 1 : currCheese);

		// after the entire first path restore the current cell position to its previous
		// state
		maze[si][sj] = prevState;

		// return count of all the paths
		return ans;
	}

	public static void main(String args[]) {
		RatMaze2 rat = new RatMaze2();
		int maze[][] = { { 100, 0, 0, 0 }, { 0, 0, 1, 0 }, { 101, 0, 0, 0 } };
		System.out.println(rat.solveMaze(maze, 0, 0, 2, 0));
	}
}