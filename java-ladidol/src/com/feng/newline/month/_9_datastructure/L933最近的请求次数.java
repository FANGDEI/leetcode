package com.feng.newline.month._9_datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L933最近的请求次数
 * @author: Ladidol
 * @description:
 * @date: 2022/9/20 0:02
 * @version: 1.0
 */
public class L933最近的请求次数 {


    //队列
    class RecentCounter {
        private Deque<Integer> deque;

        //有题意可知：保证 每次对 ping 的调用都使用比之前更大的 t 值。
        //可以直接删除查询过得
        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            int start = t - 3000;
            deque.offer(t);//在末尾加上新ping的时间。
            while (deque.getFirst() < start) {
                deque.poll();
            }
            return deque.size();
        }
    }
}
