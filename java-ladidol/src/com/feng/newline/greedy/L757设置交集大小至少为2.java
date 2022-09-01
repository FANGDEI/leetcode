package com.feng.newline.greedy;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.dp
 * @className: L757设置交集大小至少为2
 * @author: Ladidol
 * @description: 输入: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
 * 输出: 3
 * 解释:
 * 考虑集合 S = {2, 3, 4}. S与intervals中的四个区间都有至少2个相交的元素。
 * 且这是S最小的情况，故我们输出3。
 * <p>
 * 值得注意的是，没有说s需要连续
 * <p>
 * 初始化:取左边界和左边界+1
 * 若yi >= next ,则是一个大区间，一定满足交集为2的情况
 * 若yi < cur,那一定没有交集，我们还是贪心的取cur = xi,next = xi + 1 保证去右边是最到利益化.
 * 若cur <= yi < next,有一个交集，我们贪心的取next = cur，cur = xi，保证每次都是取左边界和左边界+1
 * @date: 2022/7/22 10:43
 * @version: 1.0
 */
public class L757设置交集大小至少为2 {


    class Solution {
        public int intersectionSizeTwo(int[][] intervals) {
            /*(o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]*///按第一位升序,第二位降序.
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);//排序法则。

            int n = intervals.length;
            int cur = intervals[n - 1][0];
            int next = intervals[n - 1][0] + 1;//取左边界和左边界+1
            int count = 2;//cur和next这两个数字.

            //从后向前遍历
            for (int i = n - 2; i >= 0; i--) {
                int x = intervals[i][0];
                int y = intervals[i][1];
                if (y >= next) {
                    //一定是大区间
                    continue;
                } else if (y < cur) {
                    //一定没有交集
                    cur = x;
                    next = x + 1;
                    count += 2;
                } else {
                    //有交集
                    next = cur;
                    cur = x;//cur之前的值就保留两用
                    count++;
                }
            }
            return count;
        }
    }
}
