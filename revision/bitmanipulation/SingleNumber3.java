package bitmanipulation;

import java.util.Arrays;

// https://leetcode.com/problems/single-number-iii/
public class SingleNumber3 {
    public static int[] singleNumber(int[] nums) {

        // step1: find xor of all numbers

        int xor = 0;
        for (int x : nums)
            xor ^= x;

        // step2: find first set bit in xor
        int firstSetBit = -1;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) != 0) {
                firstSetBit = i;
                break;
            }
        }

        if (firstSetBit == -1) return new int[]{-1, -1};

        // step3: find xor of all numbers having firstSetBit as set and not set
        int var1 = 0;
        int var2 = 0;
        for (int x : nums) {
            if ((x & (1 << firstSetBit)) != 0)
                var1 ^= x;
            else
                var2 ^= x;
        }

        // step4: return var1 and var2
        return new int[]{var1, var2};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

}
