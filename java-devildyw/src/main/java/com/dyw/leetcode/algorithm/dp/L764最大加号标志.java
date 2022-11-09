package com.dyw.leetcode.algorithm.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Devil
 * @since 2022-11-09-10:13
 */
@SuppressWarnings("all")
public class L764最大加号标志 {
    public static void main(String[] args) {
        System.out.println(new L764最大加号标志().orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }

    /**
     * 动态规划
     *
     * @param n
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        /**
         * 初始化 dp 数组 dp[i][j] 的含义为坐标为以 i，j 为中心的构成的加号标志的最大阶数 为 dp[i][j]
         */
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            //将数组填充为 n 后续的动态规划的状态转移方程是取各个方向上的最小值。
            Arrays.fill(dp[i], n);
        }
        //hashSet 记录所有为0 的坐标（转换为一维坐标存储）
        Set<Integer> banned = new HashSet<>();
        for (int[] mine : mines) {
            banned.add(mine[0] * n + mine[1]);
        }


        int res = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /*left (但我理解的是向左遍历 但实际上是计算后续的点的右边的1的阶数 下面同理 都是向一个方向遍历但是计算的是相反方向上的1的阶数 最后取一个点四个方向上的最小值就是该点的加号标志的阶数)*/
            for (int j = 0; j < n; j++) {
                //如果该点为0
                if (banned.contains(i * n + j)) {
                    count = 0; //就将count初始化为0
                } else {
                    count++; //否则就count++ 代表在该方向上阶数增加。
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            /*right*/
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int i = 0; i < n; i++) {
            int count = 0;

            /*up*/
            for (int j = 0; j < n; j++) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
            }

            count = 0;
            /*down*/
            for (int j = n - 1; j >= 0; j--) {
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                res = Math.max(res,dp[j][i]);
            }
        }

        return res;
    }
}
