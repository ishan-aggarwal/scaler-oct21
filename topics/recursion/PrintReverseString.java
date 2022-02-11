package day42.homework;

import java.util.Scanner;

public class PrintReverseString {
	public static void main(String[] args) {
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output

		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		int n = input.length();

		int start = 0, end = n - 1;

		char[] array = input.toCharArray();
		reverse(array, start, end);

		// String answer = new String(input);
//		System.out.println(new String(array));

		System.out.println();
		reverseString(input);

		sc.close();
	}

	// correct way as we need to print the reverse string
	private static void reverseString(String input) {
		if (input.length() == 0) {
			return;
		}
		reverseString(input.substring(1));
		System.out.print(input.charAt(0));
	}

	private static void reverse(char[] input, int start, int end) {
		if (start > end) {
			return;
		}

//		char temp = input[start];
//		input[start] = input[end];
//		input[end] = temp;

		System.out.print(input[end]);
		reverse(input, start, --end);
	}
}