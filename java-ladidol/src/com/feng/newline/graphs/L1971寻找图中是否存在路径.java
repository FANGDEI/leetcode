package com.feng.newline.graphs;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/19 16:15
 * @description: {}
 * 有一个具有 n 个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * 请你确定是否存在从顶点 source 开始，到顶点 destination 结束的 有效路径 。
 * 给你数组 edges 和整数 n、source 和 destination，如果从 source 到 destination 存在 有效路径 ，则返回 true，否则返回 false 。
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * 输出：true
 * 解释：存在由顶点 0 到顶点 2 的路径:
 * - 0 → 1 → 2
 * - 0 → 2
 * 示例 2：
 * <p>
 * 输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * 输出：false
 * 解释：不存在由顶点 0 到顶点 5 的路径.
 * 提示：
 * <p>
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * 不存在重复边
 * 不存在指向顶点自身的边
 */
public class L1971寻找图中是否存在路径 {
    //并查集模板题
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {
            this.n = n;
            father = new int[n];
            init();
            for (int[] edge : edges) {
                union(edge[0],edge[1]);
            }
            return find(source) == find(destination);



        }
        int n;

        int[] father;

        void init() {
            for (int i = 1; i < n; ++i)
                father[i] = i;
        }

        //find方法（路径压缩v2：简约版）
        int find(int x) {
            return x == father[x] ? x : (father[x] = find(father[x]));
        }


        //合并
        void union(int i, int j) {
            father[find(i)] = find(j);
        }

        //查询
        boolean query(int x, int y) {
            return find(x) == find(y);
        }
    }
}
