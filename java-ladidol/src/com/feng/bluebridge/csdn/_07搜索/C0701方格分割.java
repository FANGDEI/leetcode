package com.feng.bluebridge.csdn._07搜索;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/6 22:35
 * @description: https://edu.csdn.net/skill/practice/algorithm-5a03bc0d3e9b4370ade8fa0a5cab3334/2407?language=algorithm&materialId=18975
 */
public class C0701方格分割 {

    static int ans = 0;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] cache = new boolean[7][7];
    static int N = 6;

    static void dfs(int curI, int curJ) {
        //终止条件
        if (curI == 0 || curJ == 0 || curI == 6 || curJ == 6) {
            ans++;
            return;
        }
        for (int[] dir : dirs) {
            int x = curI + dir[0], y = curJ + dir[1];
            if (x >= 0 && x <= 6 && y >= 0 && y <= 6 && !cache[x][y]) {
                cache[x][y] = true;
                cache[N - x][N-y] = true;
                dfs(x, y);
                cache[x][y] = false;
                cache[N - x][N-y] = false;
            }

        }
    }


    public static void main(String[] args) {
        cache[3][3] = true;
        dfs(3, 3);
        System.out.println("ans = " + ans/4);
    }
}
