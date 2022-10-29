package com.feng.newline.dp.backage;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.backage
 * @className: L322零钱兑换
 * @author: Ladidol
 * @description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 你可以认为每种硬币的数量是无限的。
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * @date: 2022/8/31 19:50
 * @version: 1.0
 */
public class L322零钱兑换 {

    // 二维解法
    class Solution1 {
        // 略，和279完全平方数很相似！
    }


    // 一维解法，也是和279完全平方数一样的，就是后界面判断有点不一样。
    // 注意这些初始化。
    class Solution2 {
        // dp[j] = Math.min(dp[j], dp[j-coins[j]] + 1)
        public int coinChange(int[] coins, int amount) {
            int INF = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;// 当不考虑任何硬币的时候，只能凑出总和为 0 的方案，所使用的硬币数量为 0
            for (int i = 0; i < coins.length; i++) {
                for (int j = 0; j <= amount; j++) {
                    int no = dp[j];
                    int yes = j >= coins[i] ? dp[j - coins[i]] + 1 : INF;
                    dp[j] = Math.min(no, yes);
                }
            }
            return dp[amount] == INF ? -1 : dp[amount];
        }
    }

    // 修改一下一维解法：
    class Solution23 {
        // dp[j] = Math.min(dp[j], dp[j-coins[j]] + 1)
        public int coinChange(int[] coins, int amount) {
            int INF = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    int no = dp[j];
                    int yes = dp[j - coins[i]] + 1;
                    dp[j] = Math.min(no, yes);
                }
            }
            return dp[amount] == INF ? -1 : dp[amount];
        }
    }

    //就是完全背包问题
    class Solution345 {
        /**
         * 参数：[coins, amount]
         * 返回值：int
         * 作者： ladidol
         * 描述：dp[i][j]：考虑前i个硬币，硬币和是j，所需的最少硬币数。
         * dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j - nums.get(i)] + 1)
         */
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int INF = amount + 1;//到达不了的硬币数,注意是硬币个数，不是硬币种类。
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, INF);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= amount; j++) {
                    int no = dp[j];
                    int yes = j >= coins[i] ? dp[j - coins[i]] + 1 : INF;
                    dp[j] = Math.min(no, yes);
                }
            }
            System.out.println("dp = " + Arrays.toString(dp));
            System.out.println("(dp[amount] == INF) = " + (dp[amount] == INF));

            return dp[amount] == INF ? -1 : dp[amount];
        }
    }


    //完全背包问题，可以背多个同样的元素。
    class Solution {
        /**
         * 参数：[coins, amount]
         * 返回值：int
         * 作者： ladidol
         * 描述：值得注意的是，这里是求得最少的硬币个数。2022年10月27日20:14:44
         */
        public int coinChange(int[] coins, int amount) {
            int n = coins.length, m = amount;
            int[] dp = new int[m + 1];
            int INF = m + 1;
            //初始化背包
            for (int j = 0; j < m + 1; j++) {
                dp[j] = INF;
            }
            dp[0] = 0;

            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j < m + 1; j++) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
            return dp[m] == INF ? -1 : dp[m];
        }
    }


}
