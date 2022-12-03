package com.jirafa.leetcode.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons
 */
public class L452 {
    public int findMinArrowShots(int[][] points) {
//        Arrays.sort(points,Comparator.comparingInt(a->a[0]));
        Arrays.sort(points,(a,b)-> a[0]>=b[0]?1:-1);
        int cnt=1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>points[i-1][1])
                cnt++;
            else
                points[i][1]=Math.min(points[i][1],points[i-1][1]);
        }
        return cnt;
    }

    public static void main(String[] args) {
        L452 l452 = new L452();
        int minArrowShots = l452.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}});
        System.out.println(minArrowShots);
    }
}
