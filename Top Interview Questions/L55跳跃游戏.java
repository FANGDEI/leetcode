public class L55跳跃游戏 {
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            int[] dp = new int[nums.length];
            return process(nums, 0, dp);
        }

        public boolean process(int[] nums, int k, int[] dp) {
            boolean ans = false;
            if (dp[k] == 1) {
                return false;
            }
            if (k + nums[k] >= nums.length - 1) {
                return true;
            }
            for (int i = 1; i <= nums[k]; i++) {
                if (k + i < nums.length) {
                    ans = process(nums, k + i, dp);
                    if (ans == true) {
                        break;
                    }
                }
                if (!ans) {
                    dp[k + i] = 1;
                }
            }
            return ans;
        }
    }
}
