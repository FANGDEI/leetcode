package com.feng.面试题.美团.M23年春.M0311;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/12 21:21
 * @description: {}
 */
public class M2最优规划 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();
        //下一行记得先跳到下一行去
        scan.nextLine();
        //先初始化地图
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = scan.nextLine().toCharArray();
        }
        //再初始化可得价钱

        int[][] get = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                get[i][j] = scan.nextInt();
            }
            scan.nextLine();
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(get[i]));
//        }
        int ans = 动态规划(grid, get, n, m, k);
        System.out.println("ans = " + ans);

    }

    //dfs
//    static int dfs(char[][] gird, int n, int m, int k) {
//
//    }


    //先用dp来做吧
    static int 动态规划(char[][] grid, int[][] get, int n, int m, int k) {
        int ans = 0;
        int[][] dp = new int[n][m];
        //初始化边界
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j <= m; j++) {
//            dp[0][j] = 0;
//        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                if (dp[i - 1][j] < 0 && dp[i][j - 1] < 0) {
//                    dp[i][j] = -1;
//                    continue;
//                }
                if (i == 1 || j == 1) dp[i][j] = -1;
                else continue;
                //left和top来的
                //2023/3/15 这里可能还需要变一下：shabei
//                int x = i - 1, y = j - 1;//grid和get的横纵坐标
                int left = -1;
                int top = -1;
                if (j > 0) {
                    System.out.println("对");
                    if (dp[i][j - 1] >= 0) {
                        left = grid[i][i - 1]
                                == grid[i][j] ? dp[i][j - 1] + get[i][j] : dp[i][j - 1] + get[i][j] - k;
                        System.out.println("left = " + left);
                    }
                }
                if (i > 0) {
                    System.out.println("错");
                    if (dp[i - 1][j] >= 0) {
                        top = grid[i - 1][j]
                                == grid[j][j] ? dp[i - 1][j] + get[i][j] : dp[i - 1][j] + get[i][j] - k;
                        System.out.println("top = " + top);
                    }
                }

                dp[i][j] = Math.max(left, top);
                ans = Math.max(dp[i][j], ans);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println("dp[i] = " + Arrays.toString(dp[i]));
        }

        return ans;

    }
}
