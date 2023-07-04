package com.feng.面试题.美团.M23年春.M0325;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/25 19:03
 * @description: 春游
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美明天要去春游了。她非常喜欢吃巧克力，希望能够带尽可能多的巧克力在春游的路上吃。
 * 她现在有n个巧克力，很巧的是她所有的巧克力都是厚度一样的正方形的巧克力板，这n个巧克力板的边长分别为a1,a2,...,an。因为都是厚度一致的正方形巧克力板，我们认为第 i 个巧克力的重量为。小美现在准备挑选一个合适大小的包来装尽可能多的巧克力板，她十分需要你的帮助来在明天之前准备完成，请你帮帮她。
 * <p>
 * 输入描述
 * 第一行两个整数n和m，表示小美的巧克力数量和小美的询问数量。
 * 第二行n个整数a1,a2,...,an，表示n块正方形巧克力板的边长。注意你不能将巧克力板进行拆分。
 * 第三行m个整数q1,q2,...,qm，第 i 个整数qi表示询问：如果小美选择一个能装qi重量的包，最多能装多少块巧克力板？（不考虑体积影响，我们认为只要质量满足要求，巧克力板总能塞进包里）
 * 1≤n,m≤50000,1≤ai≤104,1≤qi≤10^18
 * 输出描述
 * 输出一行m个整数，分别表示每次询问的答案。
 * <p>
 * 样例输入
 * 5 5
 * 1 2 2 4 5
 * 1 3 7 9 15
 * 样例输出
 * 1 1 2 3 3
 */
public class M3 {
    /**
     * 背包，
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        int[] weights = new int[n];
        long[] bags = new long[m];
        for (int i = 0; i < n; i++) {
            weights[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            bags[i] = scan.nextLong();
        }
//        System.out.println("bags = " + Arrays.toString(bags));
        long bagBig = 0;
        for (int i = 0; i < bags.length; i++) {
            bagBig = Math.max(bags[i],bagBig);
        }
        System.out.println("bagBig = " + bagBig);
//        System.out.println("bagBig = " + bagBig);
//        int[][] dp = new int[weights.length + 1][(int) (bagBig + 1)];
//        List<List<Integer>> dp = new ArrayList<>();

        List<Map<Long, Integer>> dp = new ArrayList<>();
        for (int i = 0; i < weights.length + 1; i++) {
//            ArrayList<Integer> cur = new ArrayList<>();
            HashMap<Long, Integer> cur = new HashMap<>();
            for (long j = 0; j < bagBig + 1; j++) {
                cur.put(j, 0);
            }
            dp.add(cur);
        }

        for (int i = 1; i < weights.length + 1; i++) {
            for (long j = 1; j < bagBig + 1; j++) {
                int weight = weights[i - 1] * weights[i - 1];
                if (j < weight) {
                    dp.get(i).put(j, dp.get(i - 1).get(j));
//                    dp.get(i).set(j, dp.get(i - 1).get(j));
//                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp.get(i).put(j, Math.max(dp.get(i - 1).get(j), dp.get(i - 1).get(j - weight) + 1));
//                    dp.get(i).set(j, Math.max(dp.get(i - 1).get(j), dp.get(i - 1).get(j - weight) + 1));
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + 1);
                }
            }
        }
        //打印dp数组
//        for (int i = 0; i <= weights.length; i++) {
//            for (int j = 0; j <= bagBig; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
//        for (long bag : bags) {
////            if (bag > Integer.MAX_VALUE) System.out.print(n + " ");
////            else System.out.print(dp.get(weights.length).get(Math.toIntExact(bag)) + " ");
//            System.out.print(dp.get(weights.length).get(bag) + " ");
////            System.out.print(dp[weights.length][(int) bag] + " ");
//        }

        for (int i = 0; i < bags.length - 1; i++) {
            System.out.print(dp.get(weights.length).get(bags[i]) + " ");
        }
        System.out.print(dp.get(weights.length).get(bags[bags.length - 1]));


    }


}
