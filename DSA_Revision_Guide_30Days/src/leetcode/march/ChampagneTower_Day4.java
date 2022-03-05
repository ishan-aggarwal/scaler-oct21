package leetcode.march;

//799. Champagne Tower

//https://leetcode.com/problems/champagne-tower/
//Medium
//
//We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup of champagne.
//
//Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)
//
//For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.
//
//
//
//Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)
//
// 
//
//Example 1:
//
//Input: poured = 1, query_row = 1, query_glass = 1
//Output: 0.00000
//Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
//Example 2:
//
//Input: poured = 2, query_row = 1, query_glass = 1
//Output: 0.50000
//Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
//Example 3:
//
//Input: poured = 100000009, query_row = 33, query_glass = 17
//Output: 1.00000
// 
//
//Constraints:
//
//0 <= poured <= 109
//0 <= query_glass <= query_row < 100

class ChampagneTower_Day4 {

	// idea behind this problem is that...
	// whatever water is poured inside a glass it can contain maximum 1 in it and
	// rest of the water will flow out of it...
	// to two glasses on left and right equally
	// water in [i][j] would flow to water in [i+1][j] and [i+1][j+1]
	// ([i][j] - 1) / 2.0
	public static double champagneTower(int poured, int query_row, int query_glass) {

		// take a dp array to persist the old results
		double[][] dp = new double[101][101];

		// first glass gets poured with the input water
		dp[0][0] = poured;

		// we need to query till the given row and for given glass...
		// each row contains row number of glasses
		for (int i = 0; i < query_row; ++i) {
			for (int j = 0; j <= i; ++j) {
				if (dp[i][j] >= 1) {
					dp[i + 1][j] += (dp[i][j] - 1.0) / 2.0;
					dp[i + 1][j + 1] += (dp[i][j] - 1.0) / 2.0;
					dp[i][j] = 1.0;
				}
			}
		}

		// return the minimum of the two
		return Math.min(1, dp[query_row][query_glass]);
	}

	public static void main(String[] args) {
		int poured = 100000009, query_row = 33, query_glass = 17;
		System.out.println(champagneTower(poured, query_row, query_glass));

	}
}