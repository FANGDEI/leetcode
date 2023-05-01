package com.feng.review.搜素or回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/17 10:47
 * @description: {}
 */
public class L77组合 {
    //回溯
    class Solution {
        /**
         * @param n
         * @param k
         * @return
         */
        public List<List<Integer>> combine(int n, int k) {
            dfs(n, k, 1, new ArrayList<>());
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();

        void dfs(int n, int k, int curIndex, List<Integer> cur) {
            if (cur.size() == k) {
                res.add(new ArrayList<>(cur));
                return;
            }
            for (int i = curIndex; i <= n - (k - cur.size()) + 1; i++) {
//                if (i == curIndex) continue;
                cur.add(i);
                dfs(n, k, i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
