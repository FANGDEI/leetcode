package com.dyw.leetcode.medium.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Devil
 * @since 2022-07-28-13:29
 * <p>
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
 * <p>
 */
@SuppressWarnings("all")
public class L435无重叠区间 {
    public static void main(String[] args) {
        System.out.println(new L435无重叠区间().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        //根据右边界排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //初始化区间不重叠的个数
        int ans = 1;
        //指定一个右区间最小的为首区间
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //如果左区间大于首区间 说明不重叠
            if (intervals[i][0] >= right) {
                //不重叠个数加一
                ++ans;
                //更新首区间
                right = intervals[i][1];
            }
        }
        //返回重叠个数 就是总数-不重叠个数
        return intervals.length-ans;
    }
}
