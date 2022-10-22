package com.feng.newline.dfs;

/**
 * @author: ladidol
 * @date: 2022/10/20 17:12
 * @description: 给定一个m x n 二维字符网格board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 */
public class L79单词搜索 {


    //dfs
    class Solution {
        /**
         * 参数：[board, word]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：根据首字母寻找可能的情况，不断深度往下。
         */
        public boolean exist(char[][] board, String word) {

            int n = board.length;
            int m = board[0].length;
            char[] words = word.toCharArray();

            visited = new int[n][m];
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
        int[][] visited;

        void dfs(char[][] board, int i, int j, int index, char[] words) {
            if (board[i][j] != words[index]) {
                return;
            }
            if (index == words.length - 1) {
                flag = true;
                return;
            }
            visited[i][j] = 1;//被搜索过。

            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && visited[x][y] != 1)
                    dfs(board, x, y, index + 1, words);
            }
            visited[i][j] = 0;//搜索状态还原。

        }
    }

    //dfs
    class Solution12 {
        /**
         * 参数：[board, word]
         * 返回值：boolean
         * 作者： ladidol
         * 描述：根据首字母寻找可能的情况，不断深度往下。
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
            board[i][j] = t;//搜索状态还原。

        }
    }


}
