package com.jirafa.leetcode.algorithm.backTracking;

import java.net.ServerSocket;

/**
 * https://leetcode.cn/problems/sudoku-solver/
 */


public class L37 {

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.')
                    continue;
                for (int k = 1; k <= 9; k++) {
                    if(isValid(board,i,j,k)){
                        board[i][j] = (char)(k+'0');
                        if(solveSudokuHelper(board))
                            return true;
                        board[i][j]='.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board,int row,int col,int val){
        for (int i = 0; i < board.length; i++) {
            if(board[row][i]==(char)(val+'0'))
                return false;
        }
        for (char[] chars : board) {
            if (chars[col] == (char) (val + '0'))
                return false;
        }

        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if(board[i][j]==(char) (val + '0'))
                    return false;
            }
        }


        return true;
    }

}
