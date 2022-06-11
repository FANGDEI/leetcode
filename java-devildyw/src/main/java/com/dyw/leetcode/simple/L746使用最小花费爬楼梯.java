package com.dyw.leetcode.simple;

/**
 * @author Devil
 * @since 2022-06-11-19:48
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
@SuppressWarnings("all")
public class L746使用最小花费爬楼梯 {
    public static void main(String[] args) {
        System.out.println(new L746使用最小花费爬楼梯().minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

    /**
     * 由题可知 cost[i]是中的每个元素都对应的每一阶台阶向上爬所需要支付的费用 所以楼梯顶部就为所对应的下表为n
     * 初始化一个长度为n+1的dp数组 题目就转变为求到达数组下表为n所用的最小花费 其中dp[i]表示到达下标i的最小花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        //初始化dp数组为cost.length加一 根据题意讲下标0 和 1位置上的值初始化为1
        int[] dp = new int[length + 1];
        //一开始可以选择从0或者1开始走 所以都初始化为0
        dp[0] = dp[1] = 0;
        /*
        当 2≤i≤n 时，可以从下标 i−1 使用 cost[i−1] 的花费达到下标 i，或者从下标 i−2 使用 cost[i−2] 的花费达到下标 i。为了使总花费最小，
        dp[i] 应取上述两项的最小值，因此状态转移方程如下：
        dp[i] = min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
         */
        for (int i = 2; i <= length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[length];
    }
}
