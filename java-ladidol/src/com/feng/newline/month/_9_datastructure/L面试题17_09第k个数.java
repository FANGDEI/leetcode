package com.feng.newline.month._9_datastructure;

import java.util.PriorityQueue;

/**
 * @author: ladidol
 * @date: 2022/9/28 18:52
 * @description: 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。
 * 例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * 示例 1:
 * 输入: k = 5
 * 输出: 9
 * 通过次数35,784提交次数63,836
 */
public class L面试题17_09第k个数 {


    // 优先级队列
    class Solution {
        /*
         * 参数：[k]
         * 返回值：int
         * 作者： ladidol
         * 描述：根据提示可知构造3x+5y+7z的数字，从小到大去第k小的数字。
         */
        public int getKthMagicNumber(int k) {
            PriorityQueue<Long> queue = new PriorityQueue<>();
            queue.offer(1L);
            long preMin = 0;
            long curMin;
            while (!queue.isEmpty()) {
                curMin = queue.poll();
                if (curMin==preMin) continue;//如果和上一次的相同，就不需要拿出来。
                if (--k == 0) return (int) curMin;
                queue.offer(3 * curMin);
                queue.offer(5 * curMin);
                queue.offer(7 * curMin);
                preMin = curMin;
            }
            return -1;
        }
    }
}