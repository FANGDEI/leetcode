package top.dyw.leetcode.algorithm.贪心;

import java.util.Arrays;

/**
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
 *
 * @author Devil
 * @since 2022-10-24-12:54
 */
@SuppressWarnings("all")
public class L435无重叠区间 {

    public static void main(String[] args) {
        new L435无重叠区间().eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    }

    /**
     * 局部最优：优先选右边界小的区间，所以从左向右遍历，留给下一个区间的空间大一些，从而尽量避免交叉。全局最优：选取最多的非交叉区间。
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //按照右边界升序排序
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int count = 0;
        int edge = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            //如果上一个区间的右边界小于当前区间的左边界，说明无交集
            if (edge<=intervals[i][0]) edge = intervals[i][1];
            else count++;
        }
        return count;
    }
}
