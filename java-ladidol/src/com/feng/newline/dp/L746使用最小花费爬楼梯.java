package com.feng.newline.dp;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L746使用最小花费爬楼梯
 * @author: Ladidol
 * @description: 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 示例 1：
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * @date: 2022/8/16 16:12
 * @version: 1.0
 */
public class L746使用最小花费爬楼梯 {
    // 题目中说了：每当你爬上一个阶梯你都要花费对应的体力值

    //1. 确定dp数组以及下标的含义：到达第i个台阶上所需最小代价。
    //2. 确定递推公式：dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
    //3. dp数组如何初始化：dp[0] = cost[0]; dp[1] = cost[1];
    //4. 确定遍历顺序：从前向后
    //5. 举例推导dp数组：1,100,2,3,3,103,4,5,105,6;
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            if (cost.length < 2) return 0;
            int[] dp = new int[cost.length];//dp[]中不包括最后一步的意义。到达第i个台阶上所需最小代价。
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < dp.length; i++) {
                dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
            }
            //注意最后一步可以理解为不用花费，所以取倒数第一步，第二步的最少值
            return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
        }
    }
}
