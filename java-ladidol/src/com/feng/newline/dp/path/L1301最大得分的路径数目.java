package com.feng.newline.dp.path;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp.path
 * @className: L1301最大得分的路径数目
 * @author: Ladidol
 * @description: 给你一个正方形字符数组 board ，你从数组最右下方的字符 'S' 出发。
 * 你的目标是到达数组最左上角的字符 'E' ，数组剩余的部分为数字字符 1, 2, ..., 9 或者障碍 'X'。在每一步移动中，你可以向上、向左或者左上方移动，可以移动的前提是到达的格子没有障碍。
 * 一条路径的 「得分」 定义为：路径上所有数字的和。
 * 请你返回一个列表，包含两个整数：第一个整数是 「得分」 的最大值，第二个整数是得到最大得分的方案数，请把结果对10^9 + 7 取余。
 * 如果没有任何路径可以到达终点，请返回 [0, 0] 。
 * 示例 1：
 * <p>
 * 输入：board = ["E23","2X2","12S"]
 * 输出：[7,1]
 * 示例 2：
 * <p>
 * 输入：board = ["E12","1X1","21S"]
 * 输出：[4,2]
 * 示例 3：
 * <p>
 * 输入：board = ["E11","XXX","11S"]
 * 输出：[0,0]
 * @date: 2022/8/27 17:03
 * @version: 1.0
 */
public class L1301最大得分的路径数目 {
    //废弃的方法；
//    class Solution {
//        int n;
//        int[][] dp;
//
//        public int[] pathsWithMaxScore(List<String> board) {
//            this.n = board.size();
//            //将board转换成二维数组
//            char[][] chars = new char[n][n];
//            for (int i = 0; i < n; i++) {
//                chars[i] = board.get(i).toCharArray();
//            }
//            int sum = 0;
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    if (chars[i][j] >= '0' && chars[i][j] <= '9') {
//                        sum += Integer.parseInt(String.valueOf(chars[i][j]));
//                    }
//                }
//            }
//
//            //方向数组：技巧之一
//            int[][] dirs = {{1, 0},{0, 1}, {1, 1}};//右，下，右下 三个方向。
//
//            dp = new int[n * n][sum + 1];
//            dp[n * n - 1][sum] = 0;
//            for (int i = 0; i <= sum; i++) {
//                for (int index = 0; index < n * n; index++) {
//                    int x = parseIdx(index)[0];//类似之前的解法，但是现在,发现初始化的时候可能会出问题也。
//                }
//            }
//
//
//        }
//
//
//        // 将 (x, y) 转换为 index
//        int getIndex(int x, int y) {
//            return x * n + y;//注意这里是列数！！！
//        }
//
//
//        // 将 index 解析回 (x, y)
//        int[] parseIdx(int index) {
//            return new int[]{index / n, index % n};
//        }
//    }

    //先用两个一维dp来做（二维降的一维，实质还是二维。）
    class Solution1 {
        int n;
        int mod = 1000000007;
        int INF = Integer.MIN_VALUE;
        // 双dp,sores表示最大值，scores[(x,y)] = Math.max(scores[x,y+1],scores[x+1,y],scores[x+1,y+1])
        // paths跟着scores最大值走。
        int[] paths;// 代表从右下角到位置 i 并取到最大得分的方案数量
        int[] scores;// 代表从右下角到位置 i 并取到最大得分

        public int[] pathsWithMaxScore(List<String> board) {
            this.n = board.size();
            paths = new int[n * n];
            scores = new int[n * n];
            //将board转换成二维数组
            char[][] chars = new char[n][n];
            for (int i = 0; i < n; i++) {
                chars[i] = board.get(i).toCharArray();
            }


            //方向数组：技巧之一
            int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};//右，下，右下 三个方向。

            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    //初始化，从起点位置得分为0，path却有一条
                    if (j == n - 1 && i == n - 1) {
                        paths[getIndex(i, j)] = 1;
                        continue;//必须要单的提出来，不然后面结果会影响。
                    }
                    //碰到障碍了
                    if (chars[i][j] == 'X') {
                        scores[getIndex(i, j)] = INF;
                        continue;
                    }
                    //如果走到第一个格子（终点是字母，所以必须单独拿出来）
                    int val = (i == 0 && j == 0) ? 0 : chars[i][j] - '0';

                    int maxScore = INF, maxPath = 0;
                    for (int[] dir : dirs) {//尝试从前面三个方向进行转移
                        int tmpX = i + dir[0], tmpY = j + dir[1];
                        if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n) {//pre合法
                            int score = scores[getIndex(tmpX, tmpY)] + val;
                            int path = paths[getIndex(tmpX, tmpY)];
                            int[] tmp = updateMaxPre(score, path, maxScore, maxPath);
                            maxScore = tmp[0];
                            maxPath = tmp[1];//已经取模
                        }
                    }
                    //更新dp
                    scores[getIndex(i, j)] = maxScore < 0 ? INF : maxScore;
                    paths[getIndex(i, j)] = maxPath;
                }
            }
            int[] tmp = new int[2];
            tmp[0] = scores[getIndex(0, 0)] == INF ? 0 : scores[getIndex(0, 0)];
            tmp[1] = scores[getIndex(0, 0)] == INF ? 0 : paths[getIndex(0, 0)];
            return tmp;
        }

        // 更新 maxPre 值，从以前三个方向中寻找最优解。
        int[] updateMaxPre(int cur, int cnt, int u, int t) {
            // 起始答案为 [u, t] : u 为「最大得分」，t 为最大得分的「方案数」
            int[] ans = new int[]{u, t};

            // 如果当前值大于 u，更新「最大得分」和「方案数」
            if (cur > u) {
                ans[0] = cur;
                ans[1] = cnt;

                // 如果当前值等于 u，增加「方案数」
            } else if (cur == u && cur != INF) {
                ans[1] += cnt;
            }

            ans[1] %= mod;
            return ans;
        }


        // 将 (x, y) 转换为 index
        int getIndex(int x, int y) {
            return x * n + y;//注意这里是列数！！！
        }
    }


    //用一个三维dp数组就能搞定。
    class Solution {
        int n;
        int mod = 1000000007;
        int INF = Integer.MIN_VALUE;
        // 双dp,sores表示最大值，scores[(x,y)] = Math.max(scores[x,y+1],scores[x+1,y],scores[x+1,y+1])
        // paths跟着scores最大值走。第一维和第二维都是xy坐标，第三维只有两个取值：0表示score，1表示path；
        int dp[][][];

        public int[] pathsWithMaxScore(List<String> board) {
            this.n = board.size();
            dp = new int[n][n][2];
            //将board转换成二维数组
            char[][] chars = new char[n][n];
            for (int i = 0; i < n; i++) {
                chars[i] = board.get(i).toCharArray();
            }


            //方向数组：技巧之一
            int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};//右，下，右下 三个方向。

            for (int i = n - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    //初始化，从起点位置得分为0，path却有一条
                    if (j == n - 1 && i == n - 1) {
                        dp[i][j][1] = 1;
                        continue;//必须要单的提出来，不然后面结果会影响。
                    }
                    //碰到障碍了
                    if (chars[i][j] == 'X') {
                        dp[i][j][0] = INF;
                        continue;
                    }
                    //如果走到第一个格子（终点是字母，所以必须单独拿出来）
                    int val = (i == 0 && j == 0) ? 0 : chars[i][j] - '0';

                    int maxScore = INF, maxPath = 0;
                    for (int[] dir : dirs) {//尝试从前面三个方向进行转移
                        int tmpX = i + dir[0], tmpY = j + dir[1];
                        if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n) {//pre合法
                            int score = dp[tmpX][tmpY][0] + val;
                            int path = dp[tmpX][tmpY][1];
                            int[] tmp = updateMaxPre(score, path, maxScore, maxPath);
                            maxScore = tmp[0];
                            maxPath = tmp[1];//已经取模
                        }
                    }
                    //更新dp
                    dp[i][j][0] = maxScore < 0 ? INF : maxScore;
                    dp[i][j][1] = maxPath;
                }
            }
            int[] tmp = new int[2];
            tmp[0] = dp[0][0][0] == INF ? 0 : dp[0][0][0];
            tmp[1] = dp[0][0][0] == INF ? 0 : dp[0][0][1];
            return tmp;
        }

        // 更新 maxPre 值，从以前三个方向中寻找最优解。
        int[] updateMaxPre(int cur, int cnt, int u, int t) {
            // 起始答案为 [u, t] : u 为「最大得分」，t 为最大得分的「方案数」
            int[] ans = new int[]{u, t};

            // 如果当前值大于 u，更新「最大得分」和「方案数」
            if (cur > u) {
                ans[0] = cur;
                ans[1] = cnt;

                // 如果当前值等于 u，增加「方案数」
            } else if (cur == u && cur != INF) {
                ans[1] += cnt;
            }

            ans[1] %= mod;
            return ans;
        }
    }


}
