package bitmanipulation;

// https://leetcode.com/problems/reverse-bits/

public class ReverseBits {

    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }
    public static int reverseBits(int n) {
        int reversed = 0;
        // iterate for all the 32 bits
        // starting from 0 to 31
        for (int i = 0; i < 32; i++) {

            // In each iteration, we shift reversed to the left by 1 bit (reversed << 1) in order to make room for the next bit.
            // We use bitwise AND operator (n & 1) to extract the LSB of n.
            // We use the bitwise OR operator (|) to combine the extracted bit with reversed.
            reversed = (reversed << 1) | (n & 1);

            // We shift n to the right by 1 bit (n >> 1) to move to the next bit of n.
            n = n >> 1;
        }
        return reversed;
    }
}
