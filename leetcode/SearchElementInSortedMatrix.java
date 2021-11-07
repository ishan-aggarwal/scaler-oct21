// 74. Search a 2D Matrix
// https://leetcode.com/problems/search-a-2d-matrix/

class SearchElementInSortedMatrix {
	
	public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int rowIndex = -1, colIdex = -1;
        int rowLow = 0, rowHigh = rows - 1;
        int columnLow = 0, columnHigh = columns - 1;
        
        rowIndex = findRowIndex(matrix, rowLow, rowHigh, columnHigh, target);
        colIdex = findColIndex(matrix, rowIndex, columnLow, columnHigh, target);
        
        if (matrix[rowIndex][colIdex] != target) {
			return false;
		} else {
			return true;
		}
    }

	private static void search(int[][] mat, int n, int x) {

		int low = 0;
		int high = n - 1;

		int rowIndex = -1;
		int colIdex = -1;

		rowIndex = findRowIndex(mat, low, high, high, x);
		colIdex = findColIndex(mat, rowIndex, low, high, x);

		if (mat[rowIndex][colIdex] != x) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at position " + rowIndex + ", " + colIdex);
		}
	}

	private static int findColIndex(int[][] mat, int rowIndex, int low, int high, int x) {
		int midColIndex = -1;
		while (low <= high) {
			midColIndex = low + (high - low) / 2;
			if (mat[rowIndex][midColIndex] < x) {
				low = midColIndex + 1;
			} else if (mat[rowIndex][midColIndex] > x) {
				high = midColIndex - 1;
			} else {
				return midColIndex;
			}
		}
		return midColIndex;
	}

	private static int findRowIndex(int[][] mat, int low, int high, int n, int x) {
		int midRowIndex = -1;
		while (low <= high) {
			midRowIndex = low + (high - low) / 2;
			if (mat[midRowIndex][0] < x) {
				if (mat[midRowIndex][n] >= x) {
					return midRowIndex;
				}
				low = midRowIndex + 1;
			} else if (mat[midRowIndex][0] > x) {
				high = midRowIndex - 1;
			} else {
				return midRowIndex;
			}
		}
		return midRowIndex;
	}

	// driver program to test above function
	public static void main(String[] args) {
//		int mat[][] = { 
//				{ 10, 20, 30, 40 }, 
//				{ 15, 25, 35, 45 }, 
//				{ 27, 29, 37, 48 }, 
//				{ 32, 33, 39, 50 } 
//				};

		int mat1[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		search(mat1, 4, 16);
	}
}
