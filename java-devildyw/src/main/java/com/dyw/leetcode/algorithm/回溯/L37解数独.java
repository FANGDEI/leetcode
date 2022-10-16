package com.dyw.leetcode.algorithm.回溯;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 *
 * @author Devil
 * @since 2022-10-16-11:41
 */
@SuppressWarnings("all")
public class L37解数独 {

    public static void main(String[] args) {

    }

    //因为这里是在传入的数组上操作 所以这里没有返回值 也就不需要为其新建列表了
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }

    private boolean solveSudokuHelper(char[][] board) {
        //双循环遍历
        //第一个循环遍历棋盘的行，一个for循环遍历棋盘的列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.'){//找到数字
                    continue;
                }

                for (char k = '1';k<='9';k++){
                    if (isValidSudoku(i,j,k,board)){ //判断这个位置填k是否有效
                        board[i][j]=k; //有效将k填入
                        if (solveSudokuHelper(board)){
                            return true;
                        }
                        board[i][j] = '.'; //回溯
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    private boolean isValidSudoku(int row, int col, char val, char[][] board) {
        //同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val){
                return false;
            }
        }

        //同列
        for (int i = 0; i < 9; i++) {
            if (board[i][col]==val){
                return false;
            }
        }

        //九宫格里是否重复
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for (int i = startRow; i < startRow+3; i++) {
            for (int j = startCol; j < startCol+3; j++) {
                if (board[i][j]==val){
                    return false;
                }
            }
        }
        return true;
    }

}
