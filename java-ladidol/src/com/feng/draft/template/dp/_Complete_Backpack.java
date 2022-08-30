package com.feng.draft.template.dp;

/**
 * @projectName: leetcode
 * @package: com.feng.draft.template.dp
 * @className: _Complete_Backpack
 * @author: Ladidol
 * @description:
 * @date: 2022/8/30 21:58
 * @version: 1.0
 */
public class _Complete_Backpack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
//        int[] weight = {2, 1};
//        int[] value = {2, 1};
        System.out.println(maxValue2(3, 4, weight, value));
//        testCompletePack();
//        testCompletePackAnotherWay();

    }


    //先遍历物品，再遍历背包
    private static void testCompletePack() {

        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.length; i++) { // 遍历物品
            for (int j = weight[i]; j <= bagWeight; j++) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp) {
            System.out.print(maxValue + " ");
        }
    }


    // 二维dp
    public static int maxValue(int m, int C, int[] weight, int[] value) {
        int[][] dp = new int[m][C + 1];
        //先预处理第一件物品
        for (int j = 0; j <= C; j++) {
            // 显然只有一件物品的时候，在容量允许的情况下，能选多少件就选多少件。
            int maxK = j / weight[0];
            dp[0][j] = maxK * value[0];
        }
        // 处理剩余物品
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= C; j++) {
                // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                int no = dp[i - 1][j];
                // 考虑第 i 件物品的情况
                int yes = 0;
                for (int k = 0; ; k++) {
                    if (j < value[i] * k) break;
                    yes = Math.max(yes, dp[i - 1][j - k * weight[i]] + k * value[i]);
                }
                dp[i][j] = Math.max(no, yes);
            }
        }
        return dp[m - 1][C];
    }

    // 滚动数组优化
    public static int maxValue1(int m, int C, int[] weight, int[] value) {
        int[][] dp = new int[2][C + 1];
        //先预处理第一件物品
        for (int j = 0; j <= C; j++) {
            // 显然只有一件物品的时候，在容量允许的情况下，能选多少件就选多少件。
            int maxK = j / weight[0];
            dp[0][j] = maxK * value[0];
        }
        // 处理剩余物品
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= C; j++) {
                // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                int no = dp[(i - 1) & 1][j];
                // 考虑第 i 件物品的情况
                int yes = 0;
                for (int k = 0; ; k++) {
                    if (j < value[i] * k) break;
                    yes = Math.max(yes, dp[(i - 1) & 1][j - k * weight[i]] + k * value[i]);
                }
                dp[i & 1][j] = Math.max(no, yes);
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m - 1][C];
    }


    // 一维数组
    public static int maxValue2(int m, int C, int[] weight, int[] value) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= C; j++) {
                // 不考虑第 i 件物品的情况（选择 0 件物品 i）
                int no = dp[j];
                // 考虑第 i 件物品的情况
                int yes = j - weight[i] >= 0 ? dp[j - weight[i]] + value[i] : 0;
                dp[j] = Math.max(no, yes);
            }
        }
        for (int maxValue : dp) {
            System.out.print(maxValue + " ");
        }
        return dp[C];
    }

}
