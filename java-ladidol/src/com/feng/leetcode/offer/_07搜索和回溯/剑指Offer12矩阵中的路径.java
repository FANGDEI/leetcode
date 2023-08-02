package com.feng.leetcode.offer._07搜索和回溯;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:54
 * @description: {}
 */
public class 剑指Offer12矩阵中的路径 {




    //dfs+回溯
    class Solution {
        /**
         * 根据首字母寻找可能的情况，不断深度往下。
         * 注意回溯：使用了棋盘也要复原
         * @param board
         * @param word
         * @return
         */
        public boolean exist(char[][] board, String word) {

            int n = board.length;
            int m = board[0].length;
            char[] words = word.toCharArray();

//                visited = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (flag) return true;
                    dfs(board, i, j, 0, words);
                }
            }

            return flag;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean flag = false;
//            int[][] visited;

        void dfs(char[][] board, int i, int j, int index, char[] words) {
            if (board[i][j] != words[index]) {
                return;
            }
            if (index == words.length - 1) {
                flag = true;
                return;
            }
            char t = board[i][j];
            board[i][j] = '#';//被搜索过。

            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length)
                    dfs(board, x, y, index + 1, words);
            }
            //注意回溯
            board[i][j] = t;//搜索状态还原。

        }
    }



}
