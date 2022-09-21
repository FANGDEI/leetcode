package com.feng.newline.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L827最大人工岛
 * @author: Ladidol
 * @description: 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格0 变成1 。
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * 岛屿 由一组上、下、左、右四个方向相连的1 形成。
 * 示例 1:
 * <p>
 * 输入: grid = [[1, 0], [0, 1]]
 * 输出: 3
 * 解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
 * 示例 2:
 * <p>
 * 输入: grid = [[1, 1], [1, 0]]
 * 输出: 4
 * 解释: 将一格0变成1，岛屿的面积扩大为 4。
 * 示例 3:
 * <p>
 * 输入: grid = [[1, 1], [1, 1]]
 * 输出: 4
 * 解释: 没有0可以让我们变成1，面积依然为 4。
 * @date: 2022/9/18 22:53
 * @version: 1.0
 */
public class L827最大人工岛 {


    class Solution {
        // 在这道题中，相邻的 11 组成一个岛屿，因此，我们需要将相邻的 1 归到同一个集合中。这可以视为一个合并操作，不难想到用并查集来实现。
        // 第一次遍历 grid，通过并查集的 union 操作合并所有相邻的 1，并且统计每个岛屿的面积，记录在 size 数组中。
        // 再次遍历 grid，对于每个 00，我们统计相邻的四个点中 1
        // 所在的岛屿（通过并查集的 find 操作找到所在岛屿），累加去重后的岛屿面积，更新最大值。

        int[] father;
        int[] size;
        int n;
        int ans = 1;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};//表示四个方向直接用这个5size的一维数组就行了。

        public int largestIsland(int[][] grid) {
            n = grid.length;
            father = new int[n * n];//正方形来着
            size = new int[n * n];
            init();//初始化。

            //初始化已经是1的了。
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        // 四个方向
                        for (int k = 0; k < 4; k++) {
                            int x = i + dirs[k], y = j + dirs[k + 1];
                            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                                int father1 = find(x * n + y), father2 = find(i * n + j);
                                if (father1 == father2) {
                                    continue;
                                }
                                union(father1, father2);
                                ans = Math.max(ans, size[father2]);//可能就出现最大值了。
                            }
                        }
                    }
                }
            }


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0) {
                        int t = 1;//最少就可以加一个本身。
                        Set<Integer> visited = new HashSet<>();
                        for (int k = 0; k < 4; k++) {//看一下四个方向如果被连起来会不会变成更大的。这里有一个很巧妙通过root的去重
                            int x = i + dirs[k], y = j + dirs[k + 1];
                            if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                                int root = find(x * n + y);
                                if (!visited.contains(root)) {//防止有重复的加入。
                                    visited.add(root);
                                    t += size[root];
                                }
                            }
                        }
                        ans = Math.max(ans, t);
                    }
                }
            }

            return ans;
        }

        void init() {
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
                size[i] = 1;//默认大小为一。
            }
        }

        //find方法（路径压缩v2：简约版）
        int find(int x) {
            return x == father[x] ? x : (father[x] = find(father[x]));
        }


        //合并
        void union(int i, int j) {
            father[find(i)] = find(j);
            size[j] += size[i];//自定义操作系列
        }
    }
}
