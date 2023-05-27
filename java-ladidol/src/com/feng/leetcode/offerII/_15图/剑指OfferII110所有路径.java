package com.feng.leetcode.offerII._15图;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/26 16:32
 * @description: {https://leetcode.cn/problems/bP4bmD/solutions/939367/tong-guan-jian-2-bfs-hui-su-by-muluo-2-w4gy/}
 */
public class 剑指OfferII110所有路径 {
    //显然使用dfs会好一点。
    class Solution {
        /**
         * 这种还是用回溯来做吧。
         *
         * @param graph 0到n-1
         * @return
         */
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            n = graph.length;
            LinkedList<Integer> curPath = new LinkedList<>();
            curPath.addLast(0);
            dfs(graph, curPath, 0);
            return res;
        }

        int n = 0;
        List<List<Integer>> res = new LinkedList<>();

        public void dfs(int[][] graph, LinkedList<Integer> path, int node) {
            if (node == n - 1) {
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = 0; i < graph[node].length; i++) {
                path.addLast(graph[node][i]);
                dfs(graph, path, graph[node][i]);
                path.removeLast();//回溯
            }
        }
    }
}
