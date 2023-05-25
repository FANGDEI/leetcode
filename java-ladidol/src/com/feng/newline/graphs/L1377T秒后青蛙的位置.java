package com.feng.newline.graphs;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/24 9:45
 * @description: {
 * 无向树（Undirected Tree）和普通的树（Directed Tree）在定义上有所不同，主要区别在于它们的边是否有方向。
 * 方向性：普通的树中的边是有方向的，从父节点指向子节点；而无向树中的边是没有方向的，可以在两个节点之间自由地来回穿越。
 * 子节点数量：在普通的树中，每个节点只能有一个父节点，但是可以有多个子节点；而在无向树中，每个节点可以有多个父节点和多个子节点。
 * 根节点：在普通的树中，必须有一个根节点作为整个树的起点，而在无向树中，没有固定的根节点，可以从任意一个节点开始遍历整个树。
 * <p>
 * }
 */
public class L1377T秒后青蛙的位置 {
    //bfs
    class Solution {
        /**
         * 建立邻接表cnt记录所有点之间的关系,mark记录该点是否被反问过,res记录到达该点的概率
         * 建立队列q,进行层序遍历
         * 每遍历一层时间t--,当时间不够到达target,退出循环返回0
         *
         * @param n
         * @param edges
         * @param t
         * @param target
         * @return
         */
        public double frogPosition(int n, int[][] edges, int t, int target) {
            if (n == 1) return 1.0;//特殊情况特殊处理
            ArrayList<Integer>[] neiTables = new ArrayList[n + 1];
            Arrays.setAll(neiTables, item -> new ArrayList<>());//填充全部为list
            //构建邻接表
            for (int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                neiTables[u].add(v);
                neiTables[v].add(u);
            }
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(1);
            double[] res = new double[n + 1];
            boolean[] visited = new boolean[n + 1];
            res[1] = 1;
            visited[1] = true;
            while (!queue.isEmpty() && t > 0) {

                int size = queue.size();
                t--;//时间先消耗
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    double p = res[cur];//到达当前节点概率；
                    int nextCount = 0;//没有遍历过的子节点个数
                    for (int j = 0; j < neiTables[cur].size(); j++) {
                        int next = neiTables[cur].get(j);
                        if (!visited[next]) {
                            nextCount++;
                        }
                    }
                    for (int j = 0; j < neiTables[cur].size(); j++) {
                        int next = neiTables[cur].get(j);
                        if (!visited[next]) {//也有去重操作
                            res[next] = p / nextCount;
                            queue.add(next);
                            visited[next] = true;//染色
                            if (next == target) {
                                //注意是t秒后到这个节点，不是t秒内！！！
                                if (t == 0 || neiTables[next].size() == 1) {
                                    return res[next];
                                }
                            }
                        }

                    }
                }
            }
            return 0;
        }
    }
}
