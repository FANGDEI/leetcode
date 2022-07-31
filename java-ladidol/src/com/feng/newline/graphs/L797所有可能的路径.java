package com.feng.newline.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.graphs
 * @className: L797所有可能的路径
 * @author: Ladidol
 * @description: 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * @date: 2022/7/31 11:11
 * @version: 1.0
 */
public class L797所有可能的路径 {


    class Solution {
        int[][] g;
        int n;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();//路径共用，加入的时候注意clone一个就行了。
        void dfs (int cur){
            if (cur==n-1){//终止条件
                res.add(new ArrayList<>(path));//重新new一个path链表
                return ;
            }
            for (int next : g[cur]) {//处理目前节点的触发路径。
                path.add(next);//遍历到的节点加入路径
                dfs(next);//进入下一层递归
                path.remove(path.size()-1);//回溯
            }
        }
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            g = graph;
            n = g.length;
            path.add(0);
            dfs(0);
            return res;
        }
    }

//    class DFS {
//        int[][] g;
//        int n;
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        void dfs (int cur){
//            if (cur==n-1){
//                res.add(path);
//                return ;
//            }
//            for (int next : g[cur]) {
//                path.add(next);
//                dfs(next);
//                path.remove(path.size()-1);
//            }
//
//        }
//    }


}
