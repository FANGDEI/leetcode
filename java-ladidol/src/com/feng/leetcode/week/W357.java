package com.feng.leetcode.week;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/6 10:39
 * @description: {}
 */
public class W357 {


    class Solution {

        private final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int maximumSafenessFactor(List<List<Integer>> grid) {
            int n = grid.size();

            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            queue.offer(new int[]{0, 0, 0}); // {row, col, distance}

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                int distance = cell[2];

                if (grid.get(row).get(col) == 1) {
                    continue;
                }

                if (row == n - 1 && col == n - 1) {
                    return distance;
                }

                for (int[] direction : DIRECTIONS) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol, distance + 1});
                    }
                }
            }

            return 0;
        }
    }


    class Solution2 {
        int target;

        public boolean canSplitArray(List<Integer> nums, int m) {
            //要分成n个数组，所以只要存在连续两个加起来>=m就行了。


            if (nums.size() == 1 || nums.size() == 0) return true;
            for (int i = 1; i < nums.size(); i++) {
                if (nums.get(i) + nums.get(i - 1) >= m) return true;
            }
            return false;
        }

    }


    class Solution1 {
        public String finalString(String s) {
            if (s == null || s.isEmpty()) return "";
            char[] charArray = s.toCharArray();
            StringBuilder ans = new StringBuilder();
            for (char c : charArray) {
                if (c != 'i') {
                    ans.append(c);
                } else {
                    ans.reverse();
                }
            }
            return ans.toString();
        }
    }


}
