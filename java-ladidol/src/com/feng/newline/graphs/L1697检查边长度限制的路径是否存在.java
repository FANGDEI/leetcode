package com.feng.newline.graphs;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2022/12/14 17:50
 * @description: {
 * 给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。
 * <p>
 * 给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，你的任务是对于每个查询 queries[j] ，判断是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。
 * <p>
 * 请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 true 时， answer 第 j 个值为 true ，否则为 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
 * 输出：[false,true]
 * 解释：上图为给定的输入数据。注意到 0 和 1 之间有两条重边，分别为 2 和 16 。
 * 对于第一个查询，0 和 1 之间没有小于 2 的边，所以我们返回 false 。
 * 对于第二个查询，有一条路径（0 -> 1 -> 2）两条边都小于 5 ，所以这个查询我们返回 true 。
 * }
 */
public class L1697检查边长度限制的路径是否存在 {

    class Solution11 {
        //*********************常用版本↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓******************************************************************
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
        //*********************常用版本↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑******************************************************************

        /**
         * 判断两点是否连通可以通过并查集来实现。另外，由于查询的顺序对结果没有影响，因此我们可以先将所有查询按照 limit 从小到大排序，所有边也按照边权从小到大排序。
         * 但是会影响最后答案数组的顺序，所以需要原地哈希记录一下位置顺序。
         *
         * @param n
         * @param edgeList
         * @param queries
         * @return
         */
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            this.n = n;
            this.father = new int[n];
            int m = queries.length;
            init();//初始化并查集


            boolean[] ans = new boolean[queries.length];
            int idx = 0;//指针表示edgeList遍历。

            Integer[] qid = new Integer[m];
            for (int i = 0; i < m; ++i) {
                qid[i] = i;
            }
            Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);//根据权值升序
            Arrays.sort(qid, (a, b) -> queries[a][2] - queries[b][2]);//同上，这里用一个qid数组来记录query的顺序
            for (Integer i : qid) {
                int a = queries[i][0], b = queries[i][1], limit = queries[i][2];
                while (idx < edgeList.length && edgeList[idx][2] < limit) {
                    int u = edgeList[idx][0], v = edgeList[idx][1];
                    union(u, v);//讲符合情况的先连通一下
                    ++idx;
                }
                ans[i] = find(a) == find(b);//看一下是否连通
            }
            return ans;
        }
    }


    class Solution {

        /**
         * 判断两点是否连通可以通过并查集来实现。另外，由于查询的顺序对结果没有影响，因此我们可以先将所有查询按照 limit 从小到大排序，所有边也按照边权从小到大排序。
         * 但是会影响最后答案数组的顺序，所以需要原地哈希记录一下位置顺序。
         *
         * @param n
         * @param edgeList
         * @param queries
         * @return
         */
        public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
            father = new int[n];
            int m = queries.length;
            //初始化并查集
            for (int i = 1; i < n; ++i)
                father[i] = i;
            boolean[] ans = new boolean[queries.length];
            int idx = 0;//指针表示edgeList遍历。

            Integer[] qid = new Integer[m];
            for (int i = 0; i < m; ++i) {
                qid[i] = i;
            }
            Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);//根据权值升序
            Arrays.sort(qid, (a, b) -> queries[a][2] - queries[b][2]);//同上，这里用一个qid数组来记录query的顺序
            for (Integer i : qid) {
                int a = queries[i][0], b = queries[i][1], limit = queries[i][2];
                while (idx < edgeList.length && edgeList[idx][2] < limit) {
                    int u = edgeList[idx][0], v = edgeList[idx][1];
                    //讲符合情况的先连通一下
                    father[find(u)] = find(v);
                    ++idx;
                }
                ans[i] = find(a) == find(b);//看一下是否连通
            }
            return ans;
        }

        int[] father;

        int find(int x) {
            return x == father[x] ? x : (father[x] = find(father[x]));
        }

    }


}
