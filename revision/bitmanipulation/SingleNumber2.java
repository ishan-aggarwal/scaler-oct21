package bitmanipulation;

// https://leetcode.com/problems/single-number-ii/description/
public class SingleNumber2 {

        public static void main(String[] args) {
            int[] nums = {2, 2, 3, 2};
            System.out.println(singleNumber(nums));
        }

        public static int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                // count number of 1s at ith position
                int count = 0;
                for (int x : nums) {
                    if ((x & (1 << i)) != 0)
                        count++;
                }
                // if count is not multiple of 3
                // then ith bit of ans will be 1
                if (count % 3 != 0)
                    ans |= (1 << i);
            }
            return ans;
        }
}
