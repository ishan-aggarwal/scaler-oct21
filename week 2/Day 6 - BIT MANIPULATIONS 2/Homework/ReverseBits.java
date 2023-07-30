//Problem Description
//
//Reverse the bits of an 32 bit unsigned integer A.
//
//
//
//Problem Constraints
//0 <= A <= 232
//
//
//
//Input Format
//First and only argument of input contains an integer A.
//
//
//
//Output Format
//Return a single unsigned integer denoting the decimal value of reversed bits.
//
//
//
//Example Input
//Input 1:
//
// 0
//Input 2:
//
// 3
//
//
//Example Output
//Output 1:
//
// 0
//Output 2:
//
// 3221225472
//
//
//Example Explanation
//Explanation 1:
//
//        00000000000000000000000000000000
//
//=>      00000000000000000000000000000000
//Explanation 2:
//
//        00000000000000000000000000000011    
//=>      11000000000000000000000000000000

package day6.Homework;

public class ReverseBits {

    /*
    Steps:
*   1. Left Shift the result by 1 bit.
*   2. Check the LSB of the given number N, if its 1 then add/OR 1 to the result.
*   3. Right shift N by 1
    */
    public static long reverse1(long N) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((N & 1) == 1) {
                result = result | 1;
            }
            N = N >> 1;
        }
        return result;
    }

    public static long reverse2(long N) {
        long reversedNumber = 0;
        int temp, i = 31;
        while (N > 0) {
            temp = (int) (N & 1); // check if value at LSB is 1 or 0
            if (temp == 1) { // if value at LSB is 1 then add set the bit at ith position in result
                reversedNumber += (temp * (1L << i));
            }
            i--; // decrement i
            N = N >> 1; // right shift N by 1
        }
        return reversedNumber;
    }

    public static long reverseSimple(long A) {
        int longbitNumber = 32;
        long N = A;
        long ans = 0l;
        while (N > 0) {
            long x = N % 2;
            ans = (ans | (x << longbitNumber - 1));
            longbitNumber--;
            N = N / 2;
        }
        return ans;
    }

    public static long reverse(long a) {
        int[] temp = new int[32];
        for (int i = 0; i < 32; i++) {
            temp[i] = 0;
        }
        int i = 0;
        while (a != 0) {
            temp[i] = (int) (a % 2);
            a = a >> 1;
            i++;
        }
        long result = 0;
        int j = 31;
        for (i = 31; i >= 0; i--) {
            result += (temp[i] * Math.pow(2, j - i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(3));
        System.out.println(reverse1(3));
        System.out.println(reverse2(3));
    }
}
