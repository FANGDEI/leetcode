package com.feng.newline.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L51N皇后
 * @author: Ladidol
 * @description: 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @date: 2022/8/12 14:42
 * @version: 1.0
 */
public class L51N皇后 {
    //首先来看一下皇后们的三个约束条件：不能同行，不能同列，不能同斜线
    //n皇后的解题思路：
    //①棋盘的宽度就是for循环的长度，②递归的深度就是棋盘的高度，③这样就可以套进回溯法的模板里了。

    class Solution123 {


        List<List<String>> res = new ArrayList<>();
        char[][] chessBoard;
        int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            chessBoard = new char[n][n];
            for (char[] c : chessBoard) {
                Arrays.fill(c, '.');//快速初始化一维数组。
            }
            backtracking(0);
            return res;

        }

        void backtracking(int rowIndex) {
            if (rowIndex == n) {
                res.add(new ArrayList<>(getStringList(chessBoard)));
                //return;//因为是取叶子节点其实这里不需要终止条件。
            }
//            StringBuilder curRow = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (isValid(rowIndex, i)) {
                    chessBoard[rowIndex][i] = 'Q';
                    backtracking(rowIndex + 1);
                    chessBoard[rowIndex][i] = '.';
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
