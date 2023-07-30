//Problem Description
//
//Write a function that takes an integer and returns the number of 1 bits it has.
//
//
//Problem Constraints
//1 <= A <= 109
//
//
//Input Format
//First and only argument contains integer A
//
//
//Output Format
//Return an integer as the answer
//
//
//Example Input
//Input1:
//11
//
//
//Example Output
//Output1:
//3
//
//
//Example Explanation
//Explaination1:
//11 is represented as 1011 in binary.

package day5.Assignments;

public class NumberOfOneBits {
    public static int numSetBits(int A) {
        int countOneBits = 0;
// 		while (A != 0) {
        while (A > 0) {
            if ((A & 1) == 1) {
                countOneBits++; // increase the count only if the right most bit is set
            }
            A >>= 1; // right shift of number by 1 place/ or 1 bit
        }
        return countOneBits;

        // lets say the number is 6 (110)

//		int total_ones = 0;
//		while (A != 0) {
//		    A = A & (A - 1); // 6 && 5 (110) & (101) = 4 then 4 & 3 = (100) & (011) = 0 so answer is 2
//		    total_ones++;
//		}
//		return total_ones;

    }

    public static void main(String[] args) {
        System.out.println(numSetBits(11));
    }
}
