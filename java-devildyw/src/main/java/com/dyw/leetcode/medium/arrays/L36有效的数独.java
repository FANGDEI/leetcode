package com.dyw.leetcode.medium.arrays;

/**
 * @author Devil
 * @since 2022-07-15-10:34
 * <p>
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用'.'表示。
 */
@SuppressWarnings("all")
public class L36有效的数独 {
    public static void main(String[] args) {
    }

    /**
     * 方法一 暴力搜索 每遍历到一个元素都去与它的每一行每一列以及所在3*3小九宫格中查看是否有相同元素
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] >= '0' && board[i][j] <= '9') {
                    if (!getEffective(i, j, board)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean getEffective(int i, int j, char[][] board) {
        //验证一行 判断在i这行上是否有重复的元素
        for (int k = 0; k < board[i].length; k++) {
            if (board[i][k] == board[i][j] && k != j) {
                return false;
            }
        }

        //验证一列 判断在j这一列是否有重复的元素
        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == board[i][j] && k != i) {
                return false;
            }
        }

        //验证3*3方格 (i/3)*3是为了找到该i和j所在位置的3*3方格的起始位置。
        int heng = (i / 3) * 3;
        int zhong = (j / 3) * 3;

        for (int k1 = heng; k1 < heng + 3; k1++) {
            for (int k2 = zhong; k2 < zhong + 3; k2++) {
                if (board[k1][k2] == board[i][j] && (k1 != i && k2 != j)) {
                    return false;
                }
            }

        }
        return true;
    }


    /**
     * leetcode官方题解 一次遍历
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku01(char[][] board) {
        //rows数组用于记录每一行中元素出现的次数(对应下标的值就是出现的次数)
        int[][] rows = new int[9][9];
        //colums数组用于记录每一列中元素出现的次数(对应下标的值就是出现的次数)
        int[][] colums = new int[9][9];
        //subboxes三维数组用于记录每个3*3方格中元素出现的次数
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    //数字 因为我们建立的数组的下标是可以与0-9的数字一一对应的
                    rows[i][index]++;
                    colums[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    //判断在一定范围内是否出现了多次同样的数字
                    if (rows[i][index] > 1 || colums[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
