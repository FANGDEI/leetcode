package com.jirafa.leetcode.algorithm.greedy;

import java.util.Arrays;


/**
 * https://leetcode.cn/problems/non-overlapping-intervals/
 */
public class L435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]>b[0])
                return 1;
            else if(a[0]<b[0])
                return -1;
            else
                return 0;
        });
        int cnt=0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<intervals[i-1][1]) {
                cnt++;
                intervals[i][1]=Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        L435 l435 = new L435();
        System.out.println(l435.eraseOverlapIntervals(new int[][]{{1, 2}, {2,3}}));
    }
}
