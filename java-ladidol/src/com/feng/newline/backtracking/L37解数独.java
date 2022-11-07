package com.feng.newline.backtracking;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L37解数独
 * @author: Ladidol
 * @description: 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * <p>
 * 解数独可以说是非常难的题目了，如果还一直停留在单层递归的逻辑中，这道题目可以让大家瞬间崩溃。
 * 所以我在开篇就提到了二维递归，这也是我自创词汇，希望可以帮助大家理解解数独的搜索过程。
 * 一波分析之后，在看代码会发现其实也不难，唯一难点就是理解二维递归的思维逻辑。
 * @date: 2022/8/12 15:19
 * @version: 1.0
 */
public class L37解数独 {

    //对这个二维数组要理解一下。
    //当前层宽度————就是当前位置可填数字个数。
    //递归深度——————就是总共有多少个空位。
    class Solution123421 {
        char[][] board;

        public void solveSudoku(char[][] board) {
            this.board = board;
            backtracking();
        }

        boolean backtracking() {
            for (int i = 0; i < 9; i++) {//我猜测这里可以通过startindex来做,不可以，因为是二维，你可以先转化成一维数组。那样就可以startIndex来继续递归了。
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') continue;//有数字就跳过。
                    for (char k = '1'; k <= '9'; k++) {// (i, j) 这个位置放k是否合适
                        if (isValidSudoku(i, j, k)) {//判断当前值
                            board[i][j] = k;
                            if (backtracking()) return true;//成功就返回。
                            board[i][j] = '.';//回溯
                        }
                    }
                    return false;//// 9个数都试完了，都不行，那么就返回false

                }
            }
//            return false;//没有返回true就返回false；
            // 遍历完没有返回false，说明找到了合适棋盘位置了
            return true;
        }

        /**
         * 判断棋盘是否合法有如下三个维度:
         * 同行是否重复
         * 同列是否重复
         * 9宫格里是否重复
         */
        boolean isValidSudoku(int row, int col, int val) {
            // 同行是否重复
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == val) {
                    return false;
                }
            }
            // 同列是否重复
            for (int j = 0; j < 9; j++) {
                if (board[j][col] == val) {
                    return false;
                }
            }
            // 9宫格里是否重复
            int startRow = (row / 3) * 3;
            int startCol = (col / 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] == val) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

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
                        rowUsed[i][num - '0'] = true;
                        colUsed[j][num - '0'] = true;
                        boxUsed[i / 3][j / 3][num - '0'] = true;
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
                            if (!isUsed(board, i, j, k)) {
                                rowUsed[i][k - '0'] = true;
                                colUsed[j][k - '0'] = true;
                                boxUsed[i / 3][j / 3][k - '0'] = true;
                                board[i][j] = k;
                                if (dfs(board)) return true;//找到了就直接开始剪枝。
                                board[i][j] = '.';
                                rowUsed[i][k - '0'] = false;
                                colUsed[j][k - '0'] = false;
                                boxUsed[i / 3][j / 3][k - '0'] = false;
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
        boolean isUsed(char[][] board, int row, int col, char num) {
            return rowUsed[row][num - '0'] || colUsed[col][num - '0'] || boxUsed[row / 3][col / 3][num - '0'];
        }
    }
}
