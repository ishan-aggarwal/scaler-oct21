package second;

// https://www.scaler.com/test/9662409d2b/?signature=BAhpA%2BC3FQ%3D%3D--7f18a69fc221ce80ba06cf64a570c1b21101ffe0#/index

import java.util.ArrayList;
import java.util.List;

class KCharTroubleUsingList {

	public static String solve(String A, int B) {
		// Base Case
		StringBuilder ans = new StringBuilder();
		if (B == 1) {
			return ans.toString();
		}

		List<CharFrequency> list = new ArrayList<>();
		int n = A.length();
		for (int i = 0; i < n; i++) {

			char currentChar = A.charAt(i);
			if (list.isEmpty() || list.get(list.size() - 1).c != currentChar) {
				list.add(new CharFrequency(currentChar, 1));
			} else {
				CharFrequency top = list.get(list.size() - 1);
				if (top.count == B - 1) {
					list.remove(list.size() - 1);
				} else {
					top.count += 1;
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			char c = list.get(i).c;
			int total = list.get(i).count;
			while (total > 0) {
				ans.append(c);
				total--;
			}
		}
		return ans.toString();
	}

	static class CharFrequency {
		char c;
		int count;

		CharFrequency(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		String ans = solve("abbac", 2);
		System.out.println(ans);
	}
}
