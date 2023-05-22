package com.feng.newline.backtracking;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/19 9:42
 * @description: {}
 */
public class L1079活字印刷 {

    class Solution {
        /**
         * 计数，在dfs回溯
         *
         * @param tiles
         * @return
         */
        public int numTilePossibilities(String tiles) {
            int[] counts = new int[26];
            for (int i = 0; i < tiles.length(); i++) {
                char c = tiles.charAt(i);
                counts[c - 'A'] += 1;
            }
            dfs(counts);
            return ans;
        }

        int ans = 0;

        void dfs(int[] counts) {
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    ans++;
                    counts[i]--;
                    dfs(counts);
                    counts[i]--;//回溯
                }
            }
        }
    }
}
