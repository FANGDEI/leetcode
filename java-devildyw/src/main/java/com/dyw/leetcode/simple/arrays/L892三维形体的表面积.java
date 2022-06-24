package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-24-13:02
 * 给你一个 n * n 的网格grid ，上面放置着一些1 x 1 x 1的正方体。
 * 每个值v = grid[i][j]表示v个正方体叠放在对应单元格(i, j)上。
 * <p>
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * <p>
 * 请你返回最终这些形体的总表面积。
 * <p>
 * 注意：每个形体的底面也需要计入表面积中。
 */
@SuppressWarnings("all")
public class L892三维形体的表面积 {

    public static void main(String[] args) {

    }

    /**
     * 找出总的立方体数量求出面积 再减去被挡住的面的面积
     * @param grid
     * @return
     */
    public int surfaceArea(int[][] grid) {
        int cover = 0; // 统计被覆盖的面数
        int blocks = 0; // 统计所有的立方体数量
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                blocks += grid[i][j];
                //统计因方块堆叠导致覆盖的面数
                cover += grid[i][j] > 1 ? grid[i][j] - 1 : 0;
                //统计上一行同一列盖住了多少面
                if (i>0){
                    cover+=Math.min(grid[i-1][j],grid[i][j]);
                }
                //看看同一行前一列盖住了几个面
                if (j>0){
                    cover+=Math.min(grid[i][j-1],grid[i][j]);
                }
            }

        }

        return blocks*6-2*cover;
    }
}
