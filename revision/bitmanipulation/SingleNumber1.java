package bitmanipulation;

// https://leetcode.com/problems/single-number/description/
public class SingleNumber1 {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        // declare ans variable
        int ans = 0;
        // iterate over nums array
        for (int x : nums) {
            // XOR operation on ans and x
            // XOR of a number with 0 is number itself
            ans = ans ^ x;
        }
        // return ans
        return ans;
    }
}
