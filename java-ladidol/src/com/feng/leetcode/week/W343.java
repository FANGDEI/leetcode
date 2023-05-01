package com.feng.leetcode.week;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/30 10:35
 * @description: {}
 */
public class W343 {


    //第一题
    class Solution1 {
        public int isWinner(int[] player1, int[] player2) {
            int sum1 = 0;
            int sum2 = 0;
            int flag1 = 1, flag2 = 1;
            int flag11 = 1, flag22 = 1;
            for (int i = 0; i < player1.length; i++) {
                sum1 += player1[i] * Math.max(flag11, flag1);
                sum2 += player2[i] * Math.max(flag22, flag2);
                if (player1[i] == 10) flag1 = 2;
                else flag1 = 1;
                if (player2[i] == 10) flag2 = 2;
                else flag2 = 1;
                if (i > 0 && player1[i - 1] == 10) flag11 = 2;
                else flag11 = 1;
                if (i > 0 && player2[i - 1] == 10) flag22 = 2;
                else flag22 = 1;
            }
            if (sum1 == sum2) return 0;
            return sum1 > sum2 ? 1 : 2;
        }
    }

    class Solution11 {
        public int isWinner(int[] player1, int[] player2) {
            int sum1 = 0;
            int sum2 = 0;
            int flag1 = 1, flag2 = 1;
            for (int i = 0; i < player1.length; i++) {
                // 计算玩家的得分
                int score1 = player1[i];
                int score2 = player2[i];
                if (player1[i] == 10) {
                    flag1 = Math.min(flag1 + 1, 3);
                } else {
                    flag1 = player1[i - 1] == 10 ? Math.min(flag1 + 1, 3) : 1;
                }
                if (player2[i] == 10) {
                    flag2 = Math.min(flag2 + 1, 3);
                } else {
                    flag2 = player2[i - 1] == 10 ? Math.min(flag2 + 1, 3) : 1;
                }
                score1 = flag1 >= 2 ? score1 * 2 : score1;
                score2 = flag2 >= 2 ? score2 * 2 : score2;
                sum1 += score1;
                sum2 += score2;
            }
            // 比较得分
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return 2;
            } else {
                return 0;
            }
        }
    }

    //第二题
    class Solution2 {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            boolean[][] alive = new boolean[m][n];
            // 记录每个数字所在的行
            // 记录每个数字所在的列

            // 遍历 arr 中的每个元素，将包含该元素的 mat 单元格涂色，并记录涂色的行和列
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        if (mat[j][k] == num) {
                            alive[j][k] = true;
                            // 检查当前数字所在的行或列是否已经涂色满了
                            if (isRowFull(alive, j) || isColFull(alive, k)) {
                                return i;
                            }
                        }
                    }
                }
            }

            // 如果没有找到符合条件的元素，返回 -1
            return -1;
        }

        // 判断指定行是否已经涂色满了
        private boolean isRowFull(boolean[][] alive, int row) {
            for (boolean num : alive[row]) {
                if (!num) {
                    return false;
                }
            }
            return true;
        }

        // 判断指定列是否已经涂色满了
        private boolean isColFull(boolean[][] alive, int col) {
            for (int i = 0; i < alive.length; i++) {
                if (!alive[i][col]) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution22 {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            Map<Integer, Set<Integer>> rowMap = new HashMap<>();
            Map<Integer, Set<Integer>> colMap = new HashMap<>();

            // 遍历矩阵，记录每个数字所在的行和列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int num = mat[i][j];
                    rowMap.computeIfAbsent(num, k -> new HashSet<>()).add(i);
                    colMap.computeIfAbsent(num, k -> new HashSet<>()).add(j);
                }
            }

            // 遍历 arr 中的每个元素，在哈希表中查找其在矩阵中的位置，并涂色
            boolean[][] alive = new boolean[m][n];
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                if (rowMap.containsKey(num) && colMap.containsKey(num)) {
                    Set<Integer> rows = rowMap.get(num);
                    Set<Integer> cols = colMap.get(num);
                    for (int row : rows) {
                        for (int col : cols) {
                            alive[row][col] = true;
                            // 检查当前数字所在的行或列是否已经涂色满了
                            if (isRowFull(alive, row) || isColFull(alive, col)) {
                                return i;
                            }
                        }
                    }
                }
            }

            // 如果没有找到符合条件的元素，返回 -1
            return -1;
        }

        // 判断指定行是否已经涂色满了
        private boolean isRowFull(boolean[][] alive, int row) {
            for (int j = 0; j < alive[0].length; j++) {
                if (!alive[row][j]) {
                    return false;
                }
            }
            return true;
        }

        // 判断指定列是否已经涂色满了
        private boolean isColFull(boolean[][] alive, int col) {
            for (int i = 0; i < alive.length; i++) {
                if (!alive[i][col]) {
                    return false;
                }
            }
            return true;
        }
    }

    //第四题
    static class Solution4 {

        public String smallestBeautifulString(String s, int k) {
            char[] c = s.toCharArray();
            c[s.length() - 1]++;
            for (int i = s.length() - 1; i < s.length();) {
                if (c[i] == 'a' + k) {
                    c[i--] = 'a';
                    if (i < 0) {
                        return "";
                    }
                    c[i]++;
                } else if (i > 0 && c[i] == c[i - 1] || i > 1 && c[i] == c[i - 2]) {
                    c[i]++;
                } else {
                    i++;
                }
            }
            return String.valueOf(c);
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String ans = solution4.smallestBeautifulString("acdc", 4);
        System.out.println("ans = " + ans);

    }


}
