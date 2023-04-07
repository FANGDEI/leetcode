package com.jirafa.leetcode.algorithm.dp;

public class 背包_01背包 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
        test_WeightBagProblem(weight, value, bagSize);
    }

    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= bagSize; i++) {
            dp[0][i] = i >= weight[0] ? value[0] : 0;
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[weight.length - 1][bagSize]);
    }

    /**
     * 压缩为一维数组
     * @param weight
     * @param value
     * @param bagSize
     */
    public static void test_WeightBagProblem(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];

        for (int i = 0; i <= bagSize; i++) {
            dp[i] = i >= weight[0] ? value[0] : 0;
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = dp.length; j>=weight[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}
