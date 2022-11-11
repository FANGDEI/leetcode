package com.dyw.leetcode.algorithm.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author Devil
 * @since 2022-11-11-11:25
 */
@SuppressWarnings("all")
public class L198打家劫舍 {

    public static void main(String[] args) {
        System.out.println(new L198打家劫舍().rob(new int[]{1, 2, 3, 1}));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        if (nums.length==1) return nums[0];

        int n = nums.length;
        /**
         * dp[i] 考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
         */
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //只能在昨天 和 前一天加上今天的值来比较
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[n-1];


    }
}
