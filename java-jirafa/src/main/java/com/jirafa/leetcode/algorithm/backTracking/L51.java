package com.jirafa.leetcode.algorithm.backTracking;

import java.util.*;

public class L51 {
    List<List<String>> list;

    public List<List<String>> solveNQueens(int n) {
        list=new LinkedList<>();
        char[][] chessBoard=new char[n][n];
        for(char[] ch:chessBoard){
            Arrays.fill(ch, '.');
        }
        backtrack(chessBoard,n,0);
        return list;
    }

    public void backtrack(char[][] chessBoard, int n,int row){
        if(row==n ){
            ArrayList<String> path = new ArrayList<>();
            for(char[] ch:chessBoard){
                path.add(String.copyValueOf(ch));
            }
            list.add(path);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(chessBoard,row,i)){
                chessBoard[row][i]='Q';
                backtrack(chessBoard,n,row+1);
                chessBoard[row][i]='.';
            }
        }

    }

    public Boolean isValid(char[][] ch,int row,int col){
        for (int i = 0; i < row; i++) {
            if(ch[i][col]=='Q'){
                return false;
            }
        }

        for (int i = row-1, j=col-1; i >= 0&&j >= 0; i--,j--) {
            if(ch[i][j]=='Q')
                return false;
        }

        for(int i=row-1,j=col+1;i >= 0&&j < ch.length; i--,j++){
            if(ch[i][j]=='Q')
                return false;
        }

        return true;
    }
}
