package com.feng.newline.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L435无重叠区间
 * @author: Ladidol
 * @description: 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * 输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 * 示例 2:
 * <p>
 * 输入: intervals = [ [1,2], [1,2], [1,2] ]
 * 输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 * 示例 3:
 * <p>
 * 输入: intervals = [ [1,2], [2,3] ]
 * 输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 * @date: 2022/8/15 13:05
 * @version: 1.0
 */
public class L435无重叠区间 {
    //如果两个区间有重叠，应该保留结尾小的，结合图示很容易想到。
    //按左边排序，不管右边顺序。相交的时候取最小的右边。
    class Solution1 {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
            int res = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i - 1][1] > intervals[i][0]) {//如果当前和前面的有重合，就更新当前最小结尾（这时候较大的结尾就等同于删除了一样。
                    intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                    res++;
                }//如果没重合，就不管就是了，默认最小结尾就是intervals
            }
            return res;
        }
    }

    //更高效的贪心：
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (x, y) -> Integer.compare(x[1], y[1]));//结尾按升序。
            int res = 0;
            int edge = Integer.MIN_VALUE;
            for (int i = 0; i < intervals.length; i++) {
                if (edge <= intervals[i][0]) {//没重合就更新结尾边界。
                    edge = intervals[i][1];
                }else{//有重合，就默认结尾不变；
                    res++;
                }
            }
            return res;
        }
    }


}
