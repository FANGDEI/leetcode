package com.feng.面试题.途虎;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/20 19:34
 * @description: {}
 */
public class Main {


    public int minPathSum(int[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];


    }

    public String carServiceRecommendation(int B, int T) {
        ArrayList<Integer> cur = new ArrayList<>();
        cur.add(0);
        cur.add(0);
        cur.add(0);
        cur.add(0);
        cur.add(0);
        // write code here
//        dfs(B, T, -1, 0, 0, cur);
        System.out.println(select);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                ans.append(select.get(i));
            } else {
                ans.append(" " + select.get(i));
            }
        }
        return ans.toString();

    }

    int maxPrice;

//    int[] select = new int[5];

    List<Integer> select = new ArrayList<>(5);

    int[] values = {20, 50, 30, 60, 40};
    int[] spend = {1, 2, 1, 3, 2};

//    void dfs(int B, int T, int curIndex, int prices, int times, List<Integer> current) {
//        if (prices > B || times > T) {
//            return;
//        }
//        if (prices > maxPrice) {
//            maxPrice = prices;
//            select = new ArrayList<>(current);
//        }
//        if (curIndex >= 5) {
//            return;
//        }
//        for (int i = curIndex + 1; i < 5; i++) {
//            current.set(i, 1);
//            dfs(B, T, i, prices + values[i], times + spend[i], current);
//            current.set(i, 0);
//        }
//
//
//    }

    public int minFactoryStores2(int[][] cities) {
        // write code here
        Set<Integer> visited = new HashSet<>();
        int minShops = 0;
        for (int i = 0; i < cities.length; i++) {
            if (!visited.contains(i)) {
                dfs(cities, visited, i);
                minShops++;
            }
        }
        return minShops;


    }

    private void dfs(int[][] cities, Set<Integer> visited, int i) {
        visited.add(i);
        for (int j = 0; j < cities.length; j++) {
            if (!visited.contains(j) && (cities[j][0] == cities[i][0] ||
                    cities[j][1] == cities[i][1])) {
                dfs(cities, visited, j);
            }
        }

    }


    public int minFactoryStores(int[][] cities) {
        Set<Integer> visited = new HashSet<>();
        int minShops = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            if (!visited.contains(i)) {
                queue.offer(i);
                visited.add(i);

                while (!queue.isEmpty()) {
                    int curr = queue.poll();

                    for (int j = 0; j < cities.length; j++) {
                        if (!visited.contains(j) && (cities[j][0] == cities[curr][0] ||
                                cities[j][1] == cities[curr][1])) {
                            queue.offer(j);
                            visited.add(j);
                        }
                    }
                }

                minShops++;
            }
        }

        return minShops;
    }

}
