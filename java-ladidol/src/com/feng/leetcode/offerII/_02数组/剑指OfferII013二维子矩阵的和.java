package com.feng.leetcode.offerII._02数组;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/12 13:45
 * @description: {}
 */
public class 剑指OfferII013二维子矩阵的和 {

    //二维前缀和，模板题
    class NumMatrix {

        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            preSum = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 当前格子(和) = 上方的格子(和) + 左边的格子(和) - 左上角的格子(和) + 当前格子(值)【和是指对应的前缀和，值是指原数组中的值】
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            //需要先做一个处理，下标对齐
            row1++;
            col1++;
            row2++;
            col2++;
            // 区间和 = 总和 - 左边和(缩短边-1) - 右边和(缩短边-1) + 左上角的和（两条缩短边都-1）
            return preSum[row2][col2] - preSum[row2][col1 - 1] - preSum[row1 - 1][col2] + preSum[row1 - 1][col1 - 1];
        }
    }

}
