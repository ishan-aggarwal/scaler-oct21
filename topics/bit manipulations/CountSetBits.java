package day40.assignment;

//Q3. Number of 1 Bits

//Problem Description
//
//Write a function that takes an integer and returns the number of 1 bits it has.
//
//
//Problem Constraints
//
//1 <= A <= 109
//
//
//Input Format
//
//First and only argument contains integer A
//
//
//Output Format
//
//Return an integer as the answer
//
//
//Example Input
//
//Input1:
//11
//
//
//Example Output
//
//Output1:
//3
//
//
//Example Explanation
//
//Explaination1:
//11 is represented as 1011 in binary.

public class CountSetBits {
	public static int numSetBits(int A) {
		int setBits = 0;
		while (A != 0) {
			A &= (A - 1);
			setBits++;
		}
		return setBits;
	}

	public static void main(String[] args) {
		System.out.println(numSetBits(11));
	}
}
