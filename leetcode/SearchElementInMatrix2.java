// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/

class SearchElementInMatrix2 {

	public static boolean searchMatrix(int[][] matrix, int target) {

		int rows = matrix.length;
		int columns = matrix[0].length;
		int columnIndex = columns - 1, rowIndex = 0;
		boolean isElementPresent = false;
		while (columnIndex >= 0 && rowIndex <= rows - 1) {
			if (matrix[rowIndex][columnIndex] == target) {
				isElementPresent = true;
				break;
			} else if (matrix[rowIndex][columnIndex] > target) {
				columnIndex--;
			} else {
				rowIndex++;
			}
		}
		if (isElementPresent) {
			return true;
		} else {
			return false;
		}
	}

	// driver program to test above function
	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(searchMatrix(mat, 37));
	}
}
