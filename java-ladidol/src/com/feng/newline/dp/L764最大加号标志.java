package com.feng.newline.dp;

import java.util.Arrays;

/**
 * @author: ladidol
 * @date: 2022/11/9 16:07
 * @description: 在一个 n x n 的矩阵grid中，除了在数组mines中给出的元素为0，其他每个元素都为1。mines[i] = [xi, yi]表示grid[xi][yi] == 0
 * 返回 grid 中包含1的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * 一个k阶由1组成的 “轴对称”加号标志 具有中心网格grid[r][c] == 1，以及4个从中心向上、向下、向左、向右延伸，长度为k-1，由1组成的臂。
 * 注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * 示例 1：
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 示例 2：
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi < n
 * 每一对 (xi, yi) 都 不重复
 */
public class L764最大加号标志 {


    //暴力解法
    class Solution123 {
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            int grid[][] = new int[n][n];

            //初始化数组
            for (int i = 0; i < n; i++) {
                Arrays.fill(grid[i], 1);
            }
            for (int i = 0; i < mines.length; i++)
                grid[mines[i][0]][mines[i][1]] = 0;


            int ans = 0;
            int cnt;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cnt = 0;
                    if (grid[i][j] == 1) {
                        cnt = 1;
                        int step = Math.min(i, j); //每一个起点能最大往外延伸的长度
                        for (int k = 1; k <= step; k++) {
                            if (i - k >= 0
                                    && i + k < n
                                    && j - k >= 0
                                    && j + k < n
                                    && grid[i - k][j] == 1
                                    && grid[i + k][j] == 1
                                    && grid[i][j - k] == 1
                                    && grid[i][j + k] == 1) {//不越界且满足条件
                                cnt++;
                            } else {
                                break;
                            }
                        }
                    }
                    ans = Math.max(ans, cnt);
                }
            }

            return ans;
        }
    }

    //前缀和+预处理
    class Solution {
        /**
         * 参数：[n, mines]
         * 返回值：int
         * 作者： ladidol
         * 描述：预处理当前点上下左右四个方向的连续1长度，木桶原理，判断最小值。
         */
        public int orderOfLargestPlusSign(int n, int[][] mines) {
            //通过i+1位当前的角标来做题。
            int[][] grid = new int[n + 10][n + 10];

            for (int i = 1; i <= n; i++) {
                Arrays.fill(grid[i], 1);
            }
            for (int[] mine : mines) {
                grid[mine[0] + 1][mine[1] + 1] = 0;
            }

            //预处理四个方向，我们可以直接两个方向合一起处理
            int[][] up = new int[n + 10][n + 10], down = new int[n + 10][n + 10], left = new int[n + 10][n + 10], right = new int[n + 10][n + 10];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (grid[i][j] == 1) {
                        up[i][j] = up[i - 1][j] + 1;
                        left[i][j] = left[i][j - 1] + 1;
                    }
                }
            }
            for (int i = n; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    if (grid[i][j] == 1) {
                        down[i][j] = down[i + 1][j] + 1;
                        right[i][j] = right[i][j + 1] + 1;
                    }
                }
            }
            printArrays(up);
            System.out.println();
            printArrays(down);
            System.out.println();
            printArrays(left);
            System.out.println();
            printArrays(right);


            //开始检查结果了
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    ans = Math.max(ans,
                            Math.min(
                                    Math.min(up[i][j], down[i][j]),
                                    Math.min(left[i][j], right[i][j])));
                }
            }
            return ans;
        }

        /**
         * 参数：[arr]
         * 返回值：void
         * 作者： ladidol
         * 描述：待删除
         */
        void printArrays(int[][] arr){
            for (int[] ints : arr) {
                System.out.println(Arrays.toString(ints));
            }
        }
    }

}