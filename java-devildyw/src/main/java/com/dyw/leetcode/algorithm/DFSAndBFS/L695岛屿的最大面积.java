package com.dyw.leetcode.algorithm.DFSAndBFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-07-17-12:01
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
@SuppressWarnings("all")
public class L695岛屿的最大面积 {
    public static void main(String[] args) {

    }

    /**
     * 广度优先搜索 通过栈来完成
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        //初始化结果
        int ans = 0;
        //遍历二维数组
        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //初始话当前面积
                int cur = 0;
                //初始化栈
                Deque<int[]> statck = new LinkedList<>();
                //将初始节点push进栈中
                statck.push(new int[]{i, j});
                //广度优先搜索 当栈为空时结束
                while (!statck.isEmpty()) {
                    //取出栈顶元素 得到i和j
                    int[] pop = statck.pop();
                    int cur_i = pop[0], cur_j = pop[1];
                    //如果cur_i和cur_j不在规定范围或是在范围内但不是陆地 就继续下一个循环判断下一个点 跳过下面步骤
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    //如果是陆地 则岛屿面积加一
                    ++cur;
                    //并将该块陆地标记为0 防止重复计算
                    grid[cur_i][cur_j] = 0;
                    //将该点的上下左右点都加入到栈中 进行下一次遍历。
                    for (int index = 0; index < 4; index++) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        statck.push(new int[]{next_i, next_j});
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
}
