package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-17-18:52
 * <p>
 * <p>
 * 给定一个 row x col 的二维网格地图 grid ，其中：grid[i][j] = 1 表示陆地， grid[i][j] = 0 表示水域。
 * <p>
 * 网格中的格子 水平和垂直 方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿
 * （或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
 * 格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 */
@SuppressWarnings("all")
public class L463岛屿的周长 {
    public static void main(String[] args) {


    }

    /**
     * 思路: 当只有一个岛屿格子的时候周长为四 每当有两个格子相邻就会各自损失1的周长
     */
    public int islandPerimeter(int[][] grid) {
        int iLength = grid.length;
        int jLength = grid[0].length;

        int count = 0; //岛屿格子的数目
        int edge = 0; //岛屿格子相邻的边数

        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                count++;
                if (j + 1 < jLength && grid[i][j + 1] == 1) { //计算左边是否有相邻的格子
                    edge++;
                }
                if (i + 1 < iLength && grid[i + 1][j] == 1) { //计算下面是否有相邻的格子
                    edge++;
                }
            }
        }
        return 4 * count - 2 * edge;
    }
}
