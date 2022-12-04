package com.jirafa.leetcode.algorithm.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 */
public class L56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if (a[0]>b[0])
                return 1;
            else if(a[0]<b[0])
                return -1;
            else
                return 0;
        });

        List<int[]> list = new LinkedList<>();
        int start=intervals[0][0],maxRight=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>maxRight){
                list.add(new int[]{start,maxRight});
                start = intervals[i][0];
                maxRight=intervals[i][1];
            }else {
                maxRight=Math.max(maxRight,intervals[i][1]);
            }
        }

        list.add(new int[]{start,maxRight});
        return list.toArray(new int[list.size()][2]);
    }

    @Test
    public void test(){
        int[][] merge = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge);
    }
}
