package com.dyw.leetcode.algorithm.dp;

/**
 *
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *
 * @author Devil
 * @since 2022-11-07-11:38
 */
@SuppressWarnings("all")
public class L518零钱兑换II {

    public static void main(String[] args) {
        System.out.println(new L518零钱兑换II().change(3, new int[]{2}));
    }

    /**
     * 完全背包 背包最大容量为 amount 物品是 coins（重量与价值相同） 同一件物品可以放多次 试问装满容量为 amounts 背包有多少种方法。
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        /**
         * 1.确定dp数组下标以及下标的含义
         * dp[j] 凑成总金额j的货币的组合总数
         *
         * 2.确定递推公式
         * dp[j]（考虑coin[i]的组合总和）就是所有的dp[j-coins[i]](不考虑+coins[i])相加 即dp[j] += dp[j - coins[i]];
         * 求装满背包有几种方法，一般公式都是：dp[j] += dp[j - nums[i]]; 因为只用计算装满有多少中方式 而不是问你该容量背包能装下物品的最大物品价值 所以不用加上value （不是同一个维度）
         *
         * 3. dp数组初始化 dp[0] = 1 dp[0] 是递归公式的基础 不然后续全都为0了（含义：凑满0元的组合只有一种 那就是不装）
         *
         * 4. 遍历顺序： 先coins 再背包
         *
         * 5. <img src="https://img-blog.csdnimg.cn/20210120181331461.jpg">
         */

        //递推表达式
        int[] dp = new int[amount+1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
