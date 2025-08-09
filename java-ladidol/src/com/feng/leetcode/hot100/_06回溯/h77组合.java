package com.feng.leetcode.hot100._06回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class h77组合 {


    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            result = new LinkedList<>();
            LinkedList<Integer> curAns = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                curAns.addLast(i);
                dfs(i, curAns, k, n);
                curAns.removeLast();
            }
            return result;
            
        }
        List<List<Integer>> result;

        void dfs(int curIndex, LinkedList<Integer> curAns, int k, int n){
            if (curAns.size()==k) {
                result.add(new LinkedList<>(curAns));
            }
            for (int i = curIndex + 1; i <= n; i++) {
                curAns.addLast(i);
                dfs(i, curAns, k, n);
                curAns.removeLast();
            }
        }
    }
}
