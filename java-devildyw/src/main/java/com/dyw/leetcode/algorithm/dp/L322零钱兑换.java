package com.dyw.leetcode.algorithm.dp;

/**
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author Devil
 * @since 2022-11-09-11:03
 */
@SuppressWarnings("all")
public class L322零钱兑换 {

    public static void main(String[] args) {
        System.out.println(new L322零钱兑换().coinChange(new int[]{1, 2, 5}, 11));
    }

    /**
     * 完全背包这里是计算抽成背包容量的最小物品数量
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE-1;
        /**
         * dp[i] 的含义为 能凑成金额 i 的硬币的最小数量
         */
        int[] dp = new int[amount+1];
        //初始化dp数组为最大值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        //当金额为0时需要的硬币数为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) { //这里背包和物品遍历的先后顺序不影响结果
            for (int j = coins[i]; j < amount + 1; j++) {
                //只有 dp[j-coins[i]]不是初始最大值时,该位才有选择的必要. 这里只是减少遍历的次数 如果加上该条条件也不影响结果 因为取最小值 肯定不会取到 max+1
                if (dp[j-coins[i]]!=max){
                    //选择硬币数最小的情况
                    /**
                     * 递推公式: dp[j] = Math.min(dp[j],dp[j-coins[i]]+1) 找到了 凑足 j-coins[i] 金额的最少硬币个数为 dp[j-coins[i]],那么只需要再加上一个硬币 coins[i] 即 dp[j-coins[i]] + 1 就是 dp[j]
                     */
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        //如果dp[amount] == max 代表 无法凑成金额 amount
        return dp[amount]==max?-1:dp[amount];
    }
}
