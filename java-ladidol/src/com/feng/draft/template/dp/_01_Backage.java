package com.feng.draft.template.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.dp
 * @className: _01_Backage
 * @author: Ladidol
 * @description:
 * @date: 2022/8/17 20:11
 * @version: 1.0
 */
public class _01_Backage {
    //1. 确定dp数组以及下标的含义：即dp[i][j]表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
    //2. 确定递推公式：
    //3. dp数组如何初始化：
    //4. 确定遍历顺序：
    //5. 举例推导dp数组：
    public static void main(String[] args) {
        //这里是三个物品的重量和价值。
        int[] weights = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bagsize = 4;//背包的最大容量。
        test2weightbagproblem(weights, values, bagsize);
    }

    //01背包二维dp
    static void test1weightbagproblem(int[] weights, int[] values, int bagWeight) {
        int wLen = weights.length;
        int value0 = 0;
        //定义dp数组：dp[i][j]表示背包容量为j时，前i个物品能获得的最大价值
        int[][] dp = new int[wLen + 1][bagWeight + 1];
        //初始化：背包容量为0时，能获得的价值都为0
        for (int i = 0; i <= wLen; i++) {
            dp[i][0] = value0;
        }

        //遍历顺序：先遍历物品，再遍历背包容量，这里的i和j都是直接指的当前意思，不是index-1的情况
        for (int i = 1; i <= wLen; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if (j < weights[i - 1]) {//这里是不可能放下第i个物品，其实就是左上角的初始化。
                    dp[i][j] = dp[i - 1][j];
                } else {//注意这里i的意义
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }

        //打印dp数组
        for (int i = 0; i <= wLen; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }


    //01背包一维dp（滚动数组）
    static void test2weightbagproblem(int[] weights, int[] values, int bagWeight) {
        int wLen = weights.length;
        int value0 = 0;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWeight; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        //打印dp数组
        for (int j = 0; j <= bagWeight; j++) {
            System.out.print(dp[j] + " ");//0 15 15 20 35
        }
    }
}
