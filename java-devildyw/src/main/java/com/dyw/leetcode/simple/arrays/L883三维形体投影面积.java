package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-06-22-12:29
 *
 * 在n x n的网格grid中，我们放置了一些与 x，y，z 三轴对齐的1 x 1 x 1立方体。
 *
 * 每个值v = grid[i][j]表示 v个正方体叠放在单元格(i, j)上。
 *
 * 现在，我们查看这些立方体在 xy、yz和 zx平面上的投影。
 *
 * 投影就像影子，将 三维 形体映射到一个 二维 平面上。从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *
 * 返回 所有三个投影的总面积 。
 *
 */
@SuppressWarnings("all")
public class L883三维形体投影面积 {
    public static void main(String[] args) {
        System.out.println(new L883三维形体投影面积().projectionArea(new int[][]{{2}}));
    }

    /**
     * 思路: 对于xy平面找到不为0的区域相加 即为面积 其他两面都要找到其上的最高块数
     * @param grid
     * @return
     */
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int area = 0;

        for (int i = 0; i < n; i++) {
            int maxi = -1;
            for (int j = 0; j < m; j++) {
                if (grid[i][j]!=0){
                    area++;
                }
                if (maxi < grid[i][j]){
                    maxi = grid[i][j];
                }
            }
            area += maxi;

            int maxj = -1;
            for (int j = 0; j < m; j++) {
                if (maxj < grid[j][i]){
                    maxj = grid[j][i];
                }
            }
            area += maxj;
        }


        return area;

    }

    /**
     * leetcode官方题解
     * @param grid
     * @return
     */
    public int projectionArea01(int[][] grid) {
        int n = grid.length;

        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j]>0?1:0;
                yzHeight =Math.max(yzHeight,grid[j][i]);
                zxHeight = Math.max(zxHeight,grid[i][j]);
            }
            yzArea+=yzHeight;
            zxArea+=zxHeight;
        }
        return xyArea+yzArea+zxArea;
    }
}
