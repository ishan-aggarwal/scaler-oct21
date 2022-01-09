package second;

// https://www.scaler.com/test/9662409d2b/?signature=BAhpA%2BC3FQ%3D%3D--7f18a69fc221ce80ba06cf64a570c1b21101ffe0#/index

import java.util.Stack;

class KCharTrouble {

	public static String solve(String A, int B) {
		// Base Case
		StringBuilder ans = new StringBuilder();
		if (B == 1) {
			return ans.toString();
		}

		Stack<CharFrequency> stack = new Stack<>();
		int n = A.length();
		for (int i = 0; i < n; i++) {

			char currentChar = A.charAt(i);
			if (stack.isEmpty() || stack.peek().c != currentChar) {
				stack.push(new CharFrequency(currentChar, 1));
			} else {
				CharFrequency top = stack.peek();
				if (top.count == B - 1) {
					stack.pop();
				} else {
					top.count += 1;
				}
			}
		}

		while (!stack.isEmpty()) {
			char c = stack.peek().c;
			int total = stack.peek().count;
			while (total > 0) {
				ans.append(c);
				total--;
			}
			stack.pop();
		}
		return ans.reverse().toString();
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
		String ans = solve("abbacd", 2);
		System.out.println(ans);
	}
}
