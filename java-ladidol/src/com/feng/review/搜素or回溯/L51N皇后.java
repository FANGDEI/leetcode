package com.feng.review.搜素or回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L51N皇后
 * @author: Ladidol
 * @description:
 * @date: 2022/8/12 14:42 2023年3月11日19:17:29
 * @version: 1.0
 */
public class L51N皇后 {
    //首先来看一下皇后们的三个约束条件：不能同行，不能同列，不能同斜线
    //n皇后的解题思路：
    //①棋盘的宽度就是for循环的长度，②递归的深度就是棋盘的高度，③这样就可以套进回溯法的模板里了。
    //回溯
    class Solution {

        char[][] chessBoard;
        List<List<String>> ans = new ArrayList<>();
        int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            this.chessBoard = new char[n][n];

            //先初始化
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chessBoard[i][j] = '.';
                }
            }

            for (int j = 0; j < n; j++) {
                chessBoard[0][j] = 'Q';
                dfs(chessBoard, 1);
                chessBoard[0][j] = '.';
            }
            return ans;
        }

        void dfs(char[][] chessBoard, int row) {
            if (row == n) {
                ans.add(getStringList(chessBoard));
            }
            for (int j = 0; j < n; j++) {
                if (isValid(row, j)) {
                    chessBoard[row][j] = 'Q';
                    dfs(chessBoard, row + 1);
                    chessBoard[row][j] = '.';
                }
            }

        }


        boolean isValid(int row, int col) {
            //这上个方法。只会往上面遍历查找以前的Queen，相当于剪枝了。
            // 检查列
            for (int i = 0; i < row; ++i) { // 相当于剪枝
                if (chessBoard[i][col] == 'Q') {
                    return false;
                }
            }

            // 检查45度对角线
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessBoard[i][j] == 'Q') {
                    return false;
                }
            }

            // 检查135度对角线
            for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
                if (chessBoard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        //将二维char数组转化成一维String链表
        List<String> getStringList(char[][] chessboard) {
            List<String> list = new ArrayList<>();

            for (char[] c : chessboard) {
                list.add(String.copyValueOf(c));
            }
            return list;
        }
    }


}
