package com.feng.review.双指针;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/8/7 18:33
 * @description: {}
 */
public class L11盛最多水的容器 {

    //一边动，不如两边都动
    class Solution {
        /**
         * 可以从两边开始夹击，虽然宽变小了，但是高变大了（应该是可以证明的）
         *
         * @param h
         * @return
         */
        public int maxArea(int[] h) {
            int l = 0, r = h.length - 1;
            int ans = 0;

            ReentrantReadWriteLock reentrantReadWriteLock;
            ReentrantLock reentrantLock;




            while (l < r) {
                int minHeight = Math.min(h[l], h[r]);
                ans = Math.max(minHeight * (r - l), ans);
                while (l < r && h[l] <= minHeight) {
                    l++;
                }
                while (l < r && h[r] <= minHeight) {
                    r--;
                }
            }
            return ans;
        }
    }


}
