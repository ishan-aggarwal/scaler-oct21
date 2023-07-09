package bitmanipulation;

// https://leetcode.com/problems/number-of-1-bits/

public class NumberOfOneBits {
    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++)
            if ((n & (1 << i)) != 0)
                count++;
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                count++;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }
}
