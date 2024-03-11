package com.feng.面试题.神策数据;

import java.util.Scanner;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/9/11 10:36
 * @description: {}
 *
 * 示例：
 * 3 5 ：有三天时间，总过用5条任务
 * 10 3 5 2 3：这5条任务分别是多少
 * 结果：
 * 15 解释 =10+2+3，10里面包含了3和5这两个任务
 *
 *
 *
 * 任务调度问题，一天能做多个任务，每天至少有一个任务，求执行完这些任务所需要的最小资源
 *
 *
 *
 *
 */
public class Main {


    static int n = 0;
    static int m = 0;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();

        int[] nums = new int[m];

        for (int i = 0; i < m; i++) {
            nums[i] = scan.nextInt();
        }

        int cur = 0;
        for (int i = 0; i < m; i++) {
            //从不同地方分割，看一下那个地方能到达
            cur = Math.max(cur, nums[i]);//取得第一天之内的最大资源消耗
            dfs(nums, 1, cur, i);
        }
        System.out.println(ans);
    }

    static int ans = Integer.MAX_VALUE;

    static void dfs(int[] nums, int day, int cur, int index) {
        if (day > n) {//如果天数超出了，这条路径失败
            return;
        }
        if (index == m - 1) {//如果到达最后
            if (day == n) {
                ans = Math.min(ans, cur);
            }
            return;
        }
        int t = 0;
        for (int i = index + 1; i < m; i++) {
            t = Math.max(t, nums[i]);
            dfs(nums, day + 1, cur + t, i);
        }

    }


}
