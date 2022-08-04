package com.feng.leetcode.week;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.draft
 * @className: WeekGame
 * @author: Ladidol
 * @description:
 * @date: 2022/7/31 10:35
 * @version: 1.0
 */
public class W304 {

    class Solution1 {
        public int minimumOperations(int[] nums) {
            //出去非零
            Set<Integer> set = new HashSet<>();
            int count = 0;
            for (int num : nums) {
                if (set.add(num) && num != 0) count++;
            }
            return count;
        }
    }

    class Solution2 {
        public int maximumGroups(int[] grades) {

            return 0;
        }
    }



}
//class Solution {
//    int[] g;
//    int n;
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> path = new ArrayList<>();//路径共用，加入的时候注意clone一个就行了。
//    Map<Integer,Integer> start = new HashMap<>();//起点
//    int max = -1;
//    boolean has = false;
//    void dfs (int cur){
//        if (start.containsKey(cur)){
////                max = Math.max(max, path.size()-1);
//            has = true;
//            max = Math.max(max, path.size());
//            return;
//        }
//        if (cur==-1){
//            return;
//        }
//        //处理下个节点next
//        path.add(g[cur]);
//        dfs(g[cur]);
////        path.remove(path.size()-1);
//    }
//    public int longestCycle(int[] edges) {
//        g = edges;
//        path.add(0);
//        for (int i = 0; i < g.length; i++) {
//            start.put(i,1);//初始化起点
//            dfs(g[i]);
//        }
//        if (has)return max;
//        return -1;
//    }
//
//}