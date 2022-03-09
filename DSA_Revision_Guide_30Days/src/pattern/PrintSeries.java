package pattern;

class PrintSeries {

	// Function to print the series
	private static void printSeries(int n) {
		int k = 2;
		for (int row = 1; row <= n; ++row) {
			for (int col = 1; col <= row; ++col) {
				System.out.print(String.format("%05d", k * (2 * k - 1)) + " ");
				k += 2;
			}
			System.out.println();
		}
	}

	// Driver code
	public static void main(String args[]) {
		printSeries(2);
		System.out.println();
		printSeries(3);
	}
}
