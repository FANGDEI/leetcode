package com.dyw.leetcode.剑指Offer;

import com.dyw.leetcode.algorithm.回溯.template.BackTracking;

/**
 * @author Devil
 * @since 2023-03-05-21:05
 */
@SuppressWarnings("all")
public class O12矩阵中的路径 {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean flag = backTracking(board,visited,i,j,0,word);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board,boolean[][] visited,int row,int col, int index, String word) {
        if (board[row][col]!=word.charAt(index)){
            return false;
        }
        if (index== word.length()-1){
            return true;
        }

        visited[row][col] = true;
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean result = false;
        for (int[] direction : directions) {
            int newRow = row+direction[0];
            int newCol = col + direction[1];

            if (newRow>=0&&newRow<board.length&&newCol>=0&&newCol<board[0].length){
                if (!visited[newRow][newCol]){
                    boolean flag = backTracking(board, visited, newRow, newCol, index + 1, word);
                    if (flag){
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[row][col] = false;
        return result;
    }
}
