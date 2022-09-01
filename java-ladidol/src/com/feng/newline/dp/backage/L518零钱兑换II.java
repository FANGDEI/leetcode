package com.feng.newline.dp.backage;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.backage
 * @className: L518零钱兑换II
 * @author: Ladidol
 * @description: 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 * 示例 1：
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * @date: 2022/8/31 14:30
 * @version: 1.0
 */
public class L518零钱兑换II {



    // 一维排序
    // 由题意可知这是组合：
    class Solution {
        // dp[j] += dp[j - nums[i]]
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, 0);//不可能成功
            dp[0] = 1;//不需要硬币就算一次方案
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            return dp[amount];
        }
    }
}
