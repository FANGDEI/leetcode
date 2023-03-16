package top.dyw.leetcode.algorithm.dp;

import java.util.Arrays;

/**
 * @author Devil
 * @since 2022-11-17-15:45
 */
@SuppressWarnings("all")
public class L674最长连续递增序列 {

    public static void main(String[] args) {
        System.out.println(new L674最长连续递增序列().findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    public int findLengthOfLCIS(int[] nums) {
        /**
         * dp[i]表示以i结尾的数组的连续递增的子序列长度为dp[i]
         */
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            //一定是连续的 这里的状态转移方程体现了这一点 这也是与 L300最长递增子序列的差别
            if (nums[i]>nums[i-1]){
                dp[i] = dp[i-1]+1;
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
