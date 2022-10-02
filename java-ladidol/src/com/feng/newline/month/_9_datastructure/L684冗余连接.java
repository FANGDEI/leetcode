package com.feng.newline.month._9_datastructure;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L684冗余连接
 * @author: Ladidol
 * @description: 树可以看成是一个连通且 无环的无向图。
 * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
 * 示例 1：
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 示例 2：
 * 输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai< b i<= edges.length
 * ai != bi
 * edges 中无重复元素*
 * 给定的图是连通的
 * @date: 2022/9/20 0:18
 * @version: 1.0
 */
public class L684冗余连接 {

    // 并查集
    class Solution {

        // 很容易想到，该树不限于二叉树，所以思维可以发散一点，这样方便思考。
        // 那么我们就可以从前向后遍历每一条边，边的两个节点如果不在同一个集合，就加入集合（即：同一个根节点）。
        // 如果边的两个节点已经出现在同一个集合里，说明着边的两个节点已经连在一起了，如果再加入这条边一定就出现环了。

        // 如上理解的话就会发现，实现了多答案取最后一个答案的目的。
        public int[] findRedundantConnection(int[][] edges) {
            init();
            for (int[] edge : edges) {
                if (find(edge[0]) == find(edge[1])) return edge;
                union(edge[0], edge[1]);
            }
            return null;
        }

        //*********************普遍版本******************************************************************
        int n = 1005;

        int[] father = new int[n];

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

    }


}
