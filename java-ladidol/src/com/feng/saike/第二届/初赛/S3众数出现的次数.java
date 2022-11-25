package com.feng.saike.第二届.初赛;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author: ladidol
 * @date: 2022/11/24 11:54
 * @description:
 */
public class S3众数出现的次数 {
    /**
     * 作者：Ladidol
     * 描述：值得注意的就是这里的ai == ai^bi的话会将重复计算，所以就只加一个
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] student = new int[n][2];//0是红卡，1是黑卡^红卡
        Map<Integer, Integer> map = new HashMap<>();//记录每一个分数出现的次数。


        for (int i = 0; i < n; i++) {
            student[i][0] = scan.nextInt();
            student[i][1] = scan.nextInt() ^ student[i][0];
            map.put(student[i][0], map.getOrDefault(student[i][0], 0) + 1);
            if (student[i][0] != student[i][1])
                map.put(student[i][1], map.getOrDefault(student[i][1], 0) + 1);
        }
        TreeSet<Integer> set = new TreeSet<>();
        int max = 0;
        for (int integer : map.keySet()) {
            if (max < map.get(integer)) {
                set.clear();
                set.add(integer);
                max = map.get(integer);
            } else if (max == map.get(integer)) {
                set.add(integer);
            }
        }
        System.out.println(set.first());
    }
}