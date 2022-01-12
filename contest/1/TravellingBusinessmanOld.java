package first;

import java.util.ArrayList;

public class TravellingBusinessmanOld {

	public static ArrayList<Integer> solve(int A) {

		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 1; i <= A; i++) {
			result.add(i * (A - i + 1));
		}
		return result;

	}

	public static void main(String[] args) {
		int A = 4;
	}

}
