package com.feng.bluebridge.省赛.第十三届;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: ladidol
 * @date: 2022/11/19 13:47
 * @description: 【问题描述】
 * 小蓝老师教的编程课有 N 名学生，编号依次是 1 . . . N。第 i 号学生这学期
 * 刷题的数量是 Ai。
 * 对于每一名学生，请你计算他至少还要再刷多少道题，才能使得全班刷题
 * 比他多的学生数不超过刷题比他少的学生数。
 * 【输入格式】
 * 第一行包含一个正整数 N。
 * 第二行包含 N 个整数：A1, A2, A3, . . . , AN.
 * 【输出格式】
 * 输出 N 个整数，依次表示第 1 . . . N 号学生分别至少还要再刷多少道题。
 * 【样例输入】
 * 5
 * 12 10 15 20 6
 * 【样例输出】
 * 0 3 0 0 7
 */
public class L4最少刷题数 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] find = new int[n];
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scan.nextInt();
            nums[i] = num;
            find[i] = num;
        }
        Arrays.sort(find);
//        System.out.println("find = " + Arrays.toString(find));//[6, 10, 12, 15, 20]


        for (int i = 0; i < n; i++) {
            //得到num当前的大小排名位
            int pos = Arrays.binarySearch(find, nums[i]);//能找到的话是直接返回的从0开始的下标。

            int leftCount = pos;
            int rightCount = n - pos - 1;
            if (leftCount < rightCount) {
                //不符合题意了
                System.out.print(find[n / 2] - nums[i] + 1 + " ");
            } else {
                System.out.print(0 + " ");
            }

        }

    }


}