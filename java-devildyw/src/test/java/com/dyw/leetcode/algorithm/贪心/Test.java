package com.dyw.leetcode.algorithm.贪心;

import java.util.Arrays;

public class Test{

    public static void main(String[] args) {

        System.out.println(new Test().findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b)->(a[0]-b[0]));
        int cnt=1;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]>points[i-1][1])
                cnt++;
            else
                points[i][1]=Math.min(points[i][1],points[i-1][1]);
        }
        return cnt;
    }

}
