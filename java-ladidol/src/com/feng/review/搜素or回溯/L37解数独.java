package com.feng.review.搜素or回溯;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L37解数独
 * @author: Ladidol
 * @description:
 * @date: 2022/8/12 15:19 2023年3月11日19:44:10
 * @version: 1.0
 */
public class L37解数独 {

    //记忆性搜索，这一次使用了三个数组表示不同的维度的记忆性。
    class Solution {

        boolean[][] rowUsed = new boolean[9][10];//数字那一位要多开一个空间
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];

        public void solveSudoku(char[][] board) {
            //初始化被使用数组
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char num = board[i][j];
                    if (num != '.') {
                        changeStatus(i, j, num, true);
                    }
                }
            }
            dfs(board);
        }

        boolean dfs(char[][] board) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        for (char k = '1'; k <= '9'; k++) {
                            if (!isUsed(i, j, k)) {
                                changeStatus(i, j, k, true);
                                board[i][j] = k;
                                if (dfs(board)) return true;//找到了就直接开始剪枝。
                                board[i][j] = '.';
                                changeStatus(i, j, k, false);
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * 判断棋盘是否合法有如下三个维度:
         * 同行是否重复
         * 同列是否重复
         * 9宫格里是否重复
         */
        boolean isUsed(int row, int col, char num) {
            return rowUsed[row][num - '0'] || colUsed[col][num - '0'] || boxUsed[row / 3][col / 3][num - '0'];
        }

        /**
         * 染色和去染色
         * @param row
         * @param col
         * @param num
         * @param status
         */
        void changeStatus(int row, int col, char num, boolean status) {
            rowUsed[row][num - '0'] = status;
            colUsed[col][num - '0'] = status;
            boxUsed[row / 3][col / 3][num - '0'] = status;
        }
    }
}
