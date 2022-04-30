package week28.day74.classwork;

//Q1. Given the maze and initial loc of the mouse (x,y).
//Return true if there exists a path from the start to the end.
//	TC - O (N*M)
// here cell with value 1 is blocked and 0 means unblocked
// we are marking cells with value 2 to ensure it is not visited again 

public class RatMaze {

	boolean solveMaze(int maze[][]) {

		if (solveMazeUtil(maze, maze.length, 0, 0) == false) {
			System.out.print("Solution doesn't exist");
			return false;
		}

		return true;
	}

	boolean solveMazeUtil(int maze[][], int N, int x, int y) {

		
		if (x == N - 1 && y == N - 1) {
			return true;
		}

		// in case we are crossing the maze boundaries
		if ((x < 0 || x >= N) || (y < 0 || y >= N)) {
			return false;
		}

		if (maze[x][y] == 1 || maze[x][y] == 2) {
			return false;
		}

		maze[x][y] = 2;

		return solveMazeUtil(maze, N, x + 1, y) || solveMazeUtil(maze, N, x - 1, y) || solveMazeUtil(maze, N, x, y + 1)
				|| solveMazeUtil(maze, N, x, y - 1);

	}

	public static void main(String args[]) {
		RatMaze rat = new RatMaze();
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		System.out.println(rat.solveMaze(maze));
	}
}