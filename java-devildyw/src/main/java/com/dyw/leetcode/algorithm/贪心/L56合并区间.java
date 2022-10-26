package com.dyw.leetcode.algorithm.贪心;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * @author Devil
 * @since 2022-10-25-10:56
 */
@SuppressWarnings("all")
public class L56合并区间 {

    public static void main(String[] args) {
        int[][] merge = new L56合并区间().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.println(ints[0]+" "+ints[1]);
        }
    }

    /**
     * 按照左边界排序，排序之后局部最优：每次合并都取最大的右边界，这样就可以合并更多的区间了，整体最优：合并所有重叠的区间。
     *
     * 按照左边界排序就不用考虑当下一个区间的左边界小于当前区间左边界的情况了
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {

        //按照左边界排序
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[1],b[1]));
        ArrayList<int[]> res = new ArrayList<>();


        //initial start 是最小左边界
        int start = intervals[0][0];
        int rightmostRightBound = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            //如果左边界大于最右边界
            if (intervals[i][0]>rightmostRightBound){
                //加入区间，并且更新start
                res.add(new int[]{start,rightmostRightBound});
                start = intervals[i][0];
                rightmostRightBound = intervals[i][1];
            }else {
                //更新最大右边界
                rightmostRightBound = Math.max(rightmostRightBound,intervals[i][1]);
            }
        }
        //记录最后一个区间 因为上面的算法需要判断当前边界与下一个边界的关系所以无法讨论最后一个区间 所以这里最后加上
        res.add(new int[]{start,rightmostRightBound});
        return res.toArray(new int[res.size()][]);
    }
}
