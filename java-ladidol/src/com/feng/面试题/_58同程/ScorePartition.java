package com.feng.面试题._58同程;

import java.util.Arrays;

public class ScorePartition {
    public static int findMinPassLine(int[] scores, int m, int n) {
        return 0;
    }

    public static void main(String[] args) {
        int[] scores = {1,2,3,5,6,4}; // 有序数组
        Arrays.sort(scores);
        int m = 2; // 区间下限
        int n = 3; // 区间上限

        int minPassLine = findMinPassLine(scores, m, n);
        System.out.println("最小及格线为: " + minPassLine);
//        ReentrantLock
    }
}