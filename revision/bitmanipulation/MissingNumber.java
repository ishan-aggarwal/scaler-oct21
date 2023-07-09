package bitmanipulation;

// https://leetcode.com/problems/missing-number/description/
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        // declare ans variable
        int xor = 0;
        // iterate over nums array
        for (int x : nums)
            // XOR of a number with 0 is number itself
            // XOR operation on ans and x
            xor ^= x;
        // now again XOR with all numbers from 0 to n
        for (int i = 0; i <= nums.length; i++)
            xor ^= i;
        // return ans
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
