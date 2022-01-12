package first;

import java.util.ArrayList;
import java.util.Collections;

public class FantasticFourOld {
	public static int solve(ArrayList<Integer> A) {

		if (A.size() == 1) {
			if (A.get(0) % 4 != 0) {
				return -1;
			} else {
				return 0;
			}
		}

		int ans = 0;
		long sum = 0;
		int twosCount = 0;
		ArrayList<Integer> temp = new ArrayList<>();

		for (Integer ele : A) {
			sum += ele;
			if (ele % 4 != 0) {

				if (ele % 2 == 0) {
					twosCount++;
				} else {
					temp.add(ele % 4);
				}
			}
		}

		if (sum % 2 != 0) {
			return -1;
		}

		if (twosCount % 2 != 0) {
			temp.add(2);
		}

		ans = ans + twosCount / 2;

		int newSum = 0;
		for (int ele : temp) {
			newSum += ele;
		}

		if (newSum % 4 != 0) {
			return -1;
		}

		Collections.sort(temp);

		int i = 0;
		int j = temp.size() - 1;

		while (i <= j) {
			int total = temp.get(i) + temp.get(j);
			if (total % 4 == 0) {
				i++;
				j--;
			} else {
				i++;
				temp.set(j, total);
			}
			ans++;
		}

		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(3);
		A.add(4);
		A.add(4);
		A.add(2);
		A.add(2);

		System.out.println(solve(A));
	}
}
