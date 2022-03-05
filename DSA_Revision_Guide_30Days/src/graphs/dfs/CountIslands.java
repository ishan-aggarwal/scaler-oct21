package graphs.dfs;

public class CountIslands {

	public static int solve(int[][] mat) {
		int answer = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					markIsland(mat, i, j);
					answer++;
				}
			}
		}
		return answer;
	}

	private static void markIsland(int[][] mat, int row, int col) {

		// check valid move
		if ((row < 0) || (row >= mat.length) || (col < 0) || (col >= mat[0].length) || mat[row][col] != 1) {
			return;
		}

		mat[row][col] = 0;
		markIsland(mat, row - 1, col);
		markIsland(mat, row, col + 1);
		markIsland(mat, row + 1, col);
		markIsland(mat, row, col - 1);
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
		System.out.println(solve(mat));
	}

}
