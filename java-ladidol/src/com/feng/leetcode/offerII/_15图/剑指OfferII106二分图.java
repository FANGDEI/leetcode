package com.feng.leetcode.offerII._15图;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/23 20:23
 * @description: {}
 */
public class 剑指OfferII106二分图 {
    //这是他们说的多远bfs吗
    class Solution {
        /**
         * 从一个点开始BFS，能遍历完所有的点吗？如果所有点是连通的，那就能，但题目没有说。
         * 所以，要遍历每个顶点，再遍历当前顶点的所有相邻顶点，才能保证不漏点。
         *
         * @param graph
         * @return
         */
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;//点的个数
            int[] visited = new int[n];


            for (int i = 0; i < graph.length; i++) {//遍历每一个起点，0未染色、-1蓝色、1黄色
                if (visited[i] != 0) continue;//跳过已经染色的起点
                //现在对每一个起点进行bfs搜索
                Deque<Integer> queue = new ArrayDeque<>();
                queue.offer(i);
                visited[i] = -1;//起点染色为-1
                while (!queue.isEmpty()) {
                    int curStart = queue.poll();
                    int curColor = visited[curStart];
                    int nextColor = -curColor;//双色问题
                    int[] nexts = graph[curStart];//下一个点
                    for (int j = 0; j < nexts.length; j++) {
                        if (visited[nexts[j]] == nextColor) {//如果已经有颜色了，说明染色过
                            continue;
                        } else if (visited[nexts[j]] == 0) {//新点，可以继续bfs了
                            queue.offer(nexts[j]);
                            visited[nexts[j]] = nextColor;
                        } else {//颜色冲突了
                            return false;
                        }
                    }

                }

            }
            return true;

        }


    }
}
