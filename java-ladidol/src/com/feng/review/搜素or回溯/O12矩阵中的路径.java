package com.feng.review.搜素or回溯;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/6 11:01
 * @description: {}
 */
public class O12矩阵中的路径 {

    //染色加回溯，两次回溯，字符串拼接超时
    class Solution1 {
        public boolean exist(char[][] board, String word) {
            isVisited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, word, board[i][j] + "", i, j);
                    if (flag) return true;
                }
            }
            return flag;
        }

        boolean flag = false;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] isVisited;

        void dfs(char[][] board, String word, String cur, int i, int j) {
            //染色
            if (isVisited[i][j]) return;
            isVisited[i][j] = true;

            if (word.equals(cur)) {
                flag = true;
            }


            if (flag) return;

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                    dfs(board, word, cur + board[x][y], x, y);
                    if (flag) return;
                }
            }
            //回溯
            isVisited[i][j] = false;

        }
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            isVisited = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, word, 0, i, j);
                    if (flag) return true;
                }
            }
            return flag;

        }

        boolean flag = false;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] isVisited;

        void dfs(char[][] board, String word, int indexOfWord, int i, int j) {
            //染色
            if (isVisited[i][j]) return;
            isVisited[i][j] = true;

            if (word.charAt(indexOfWord) != board[i][j]) {
                //染色回溯
                isVisited[i][j] = false;
                return;
            }
            if (indexOfWord == word.length() - 1) flag = true;//终止条件，是到最后一位都相等
            if (flag) {
                //染色回溯
                isVisited[i][j] = false;
                return;
            }

            for (int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                    dfs(board, word, indexOfWord + 1, x, y);
                    if (flag) return;
                }
            }

            //染色回溯
            isVisited[i][j] = false;
        }


    }


}
