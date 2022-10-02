package com.feng.newline.month._9_datastructure;

import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L417太平洋大西洋水流问题
 * @author: Ladidol
 * @description: 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。“太平洋”处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵heights，heights[r][c]表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result的 2D 列表 ，其中result[i] = [ri, ci]表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * 示例 1：
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 * <p>
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * @date: 2022/9/16 22:43
 * @version: 1.0
 */
public class L417太平洋大西洋水流问题 {
    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            // 不想做了。
            return null;
        }
    }

//    class Solution {
//        int N = 200 * 200 + 10;
//        int[] p1 = new int[N], p2 = new int[N];
//        int n, m, tot, S, T;
//        int[][] g;
//        void union(int[] p, int a, int b) {
//            p[find(p, a)] = p[find(p, b)];
//        }
//        int find(int[] p, int x) {
//            if (p[x] != x) p[x] = find(p, p[x]);
//            return p[x];
//        }
//        boolean query(int[] p, int a, int b) {
//            return find(p, a) == find(p, b);
//        }
//        int getIdx(int x, int y) {
//            return x * n + y;
//        }
//        public List<List<Integer>> pacificAtlantic(int[][] _g) {
//            g = _g;
//            m = g.length; n = g[0].length; tot = m * n; S = tot + 1; T = tot + 2;
//            for (int i = 0; i <= T; i++) p1[i] = p2[i] = i;
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    int idx = getIdx(i, j);
//                    if (i == 0 || j == 0) {
//                        if (!query(p1, S, idx)) dfs(p1, S, i, j);
//                    }
//                    if (i == m - 1 || j == n - 1) {
//                        if (!query(p2, T, idx)) dfs(p2, T, i, j);
//                    }
//                }
//            }
//            List<List<Integer>> ans = new ArrayList<>();
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    int idx = getIdx(i, j);
//                    if (query(p1, S, idx) && query(p2, T, idx)) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(i); list.add(j);
//                        ans.add(list);
//                    }
//                }
//            }
//            return ans;
//        }
//        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
//        void dfs(int[] p, int ori, int x, int y) {
//            union(p, ori, getIdx(x, y));
//            for (int[] di : dirs) {
//                int nx = x + di[0], ny = y + di[1];
//                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
//                if (query(p, ori, getIdx(nx, ny)) || g[nx][ny] < g[x][y]) continue;
//                dfs(p, ori, nx, ny);
//            }
//        }
//    }

}
