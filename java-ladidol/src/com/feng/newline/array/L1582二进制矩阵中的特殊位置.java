package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L1582二进制矩阵中的特殊位置
 * @author: Ladidol
 * @description: 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 * <p>
 * 输入：mat = [[1,0,0],
 *             [0,1,0],
 *             [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * @date: 2022/9/4 19:35 每日一题
 * @version: 1.0
 */
public class L1582二进制矩阵中的特殊位置 {
    // 直接模拟，这里用到了二层for循环同时对行和列求和，入过mat[i][j]==1&&r[i]==1&&c[j]==1,就满足条件。
    class Solution {
        public int numSpecial(int[][] mat) {
            int n = mat.length, m = mat[0].length;
            int[] rowSum = new int[n], colSum = new int[m];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    rowSum[i] += mat[i][j];
                    colSum[j] += mat[i][j];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 1 && rowSum[i] == 1 && colSum[j] == 1) ans++;
                }
            }
            return ans;
        }
    }
}
