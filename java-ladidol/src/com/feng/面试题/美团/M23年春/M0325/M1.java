package com.feng.面试题.美团.M23年春.M0325;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/3/25 19:03
 * @description: 第一行一个整数T表示数据组数。
 * 对每组测试而言：
 * 第一行一个整数n，表示观察到的火车数量。
 * 第二行n个整数x1,x2,...,xn，表示小美记录的火车驶入休息区s的顺序。
 * 第三行n个整数y1,y2,...,yn，表示小美记录的火车驶出休息区s的顺序。
 * 1≤T≤10,1≤n≤50000,1≤xi,yi≤n, 且{xn} 、{yn} 均为{1,2,3,...,n}的一个排列，即1~n这n个数在其中不重不漏恰好出现一次。
 * 3
 * 3
 * 1 2 3
 * 1 2 3
 * 3
 * 1 2 3
 * 3 2 1
 * 3
 * 1 2 3
 * 3 1 2
 *
 * []
 * 1 2 3 4
 * 3 2 4 1
 *
 *
 */
public class M1 {
    /**
     * 比较当前相等直接弹出，不相等就放进去
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt();
            int[] ins = new int[n];
            int[] out = new int[n];

            for (int i = 0; i < n; i++) {
                ins[i] = scan.nextInt();
            }
            for (int i = 0; i < n; i++) {
                out[i] = scan.nextInt();
            }
            String ans;
            ans = check(ins, out) ? "Yes" : "No";
            System.out.println(ans);
        }
    }

    public static boolean check(int[] ins, int[] out) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < ins.length; i++) {
            stack.push(ins[i]);
            while (!stack.isEmpty() && stack.peek() == out[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
