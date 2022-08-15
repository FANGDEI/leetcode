package com.feng.newline.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.greedy
 * @className: L56合并区间
 * @author: Ladidol
 * @description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * @date: 2022/8/15 18:12
 * @version: 1.0
 */
public class L56合并区间 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));// 就按照首部升序来排序。后面的不管。这里还可以优化一下的。
            LinkedList<int[]> res = new LinkedList<>();
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i - 1][1] >= intervals[i][0]) {
                    intervals[i][0] = intervals[i - 1][0];
                    intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);
                } else {
                    res.add(intervals[i - 1]);
                }
            }
            res.add(intervals[intervals.length - 1]);
            return res.toArray(new int[res.size()][]);
        }
    }
}
