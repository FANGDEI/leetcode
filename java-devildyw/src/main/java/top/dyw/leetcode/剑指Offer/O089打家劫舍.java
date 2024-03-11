package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/08/09 14:44
 **/
@SuppressWarnings("all")
public class O089打家劫舍 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[n-1];
    }
}
