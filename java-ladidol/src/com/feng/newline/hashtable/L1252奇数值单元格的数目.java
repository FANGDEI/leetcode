package com.feng.newline.hashtable;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L1252奇数值单元格的数目
 * @author: Ladidol
 * @description:
 * 给你一个 m x n 的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个二维索引数组 indices，indices[i] = [ri, ci] 指向矩阵中的某个位置，其中 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 对 indices[i] 所指向的每个位置，应同时执行下述增量操作：
 *
 * ri 行上的所有单元格，加 1 。
 * ci 列上的所有单元格，加 1 。
 * 给你 m、n 和 indices 。请你在执行完所有 indices 指定的增量操作后，返回矩阵中 奇数值单元格 的数目。
 *
 * 示例：
 * 输入：m = 2, n = 3, indices = [[0,1],[1,1]]
 * 输出：6
 * 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
 * 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
 * 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
 *
 * @date: 2022/7/12 9:38
 * @version: 1.0
 */
//每日一题2022年7月12日10:16:49
public class L1252奇数值单元格的数目 {
    public static void main(String[] args) {

        System.out.println((3&0));
    }

    class Solution {
        public int oddCells(int m, int n, int[][] indices) {

            //法子1 通过hash算每一行加的个数，算每一列加的个数。
            //https://leetcode.cn/problems/cells-with-odd-values-in-a-matrix/solution/by-xu-shu-wu-xing-qu-2-ejvh/
            //法子2 由于特殊的性质，总数等于m*n,奇数个数=r奇数*c偶数+r偶数*c奇数
            int[] row = new int[m];
            int[] col = new int[n];
            for (int i = 0; i < indices.length; i++) {
                row[indices[i][0]] += 1;//一个数字为行增；
                col[indices[i][1]] += 1;//列增；
            }
            int rnt = 0;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if ((row[i]&1)==1){//&同1为一
                    rnt++;
                }
            }
            for (int i = 0; i < n; i++) {
                if ((col[i]&1)==1){
                    cnt++;
                }
            }
            return rnt * (n-cnt) + (m-rnt) * cnt;
        }
    }
}
