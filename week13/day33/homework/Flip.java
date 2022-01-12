package day33.homework;

public class Flip {
	public static int[] flip(String A) {

		int n = A.length(), count = 0, max = 0;
		int start = -1, end = -1;

		for (int i = 0, j = 0; j < n; j++) {
			if (A.charAt(j) == '1') {
				count--;
			} else {
				count++;
			}

			if (count < 0) {
				count = 0;
				i = j + 1;
			}

			if (count > max) {
				start = i;
				end = j;
				max = count;
			}
		}

		if (start == -1) {
			return new int[] {};
		}

		return new int[] { start + 1, end + 1 };

	}

	public static void main(String[] args) {
		int[] res = flip("111");
		for (int x : res) {
			System.out.print(x + " ");
		}
	}
}
