package com.feng.newline.greedy;

import java.util.Arrays;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/23 17:17
 * @description: {}
 */
public class L1090受标签影响的最大值 {


    //贪心
    class Solution {

        /**
         * 翻译一下题目：
         * 有一筐水果，里面有苹果、香蕉、鸭梨（labels），每一个水果的重量用values数组表示；
         * 允许那总结不超过numWanted个水果；
         * 且每一类水果不超过userLimit个水果；
         * 请问最重可以那多重的水果？
         * 排序后用字典维护类别计数，贪心即可
         * <p>
         * <p>
         * 从最大值里面拿，只拿符合useLimit要求的，到达numWanted长度或者到最后就更新ans，不是滑动窗口，你拿过的都是能用的
         *
         * @param values
         * @param labels
         * @param numWanted
         * @param useLimit
         * @return
         */
        public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
            int n = values.length;
            Integer[] idx = new Integer[n];
            for (int i = 0; i < n; i++) {
                idx[i] = i;
            }
            int[] count = new int[20001];//标签种类
            int ans = 0;
            Arrays.sort(idx, (a, b) -> values[b] - values[a]);
            for (int i = 0; i < n && numWanted > 0; i++, numWanted--) {
                while (i < n && count[labels[idx[i]]] >= useLimit) {//保证当前的不能超过限制，有去重的操作
                    i++;
                }
                if (i < n) {
                    ans += values[idx[i]];
                    count[labels[idx[i]]]++;
                }
            }
            return ans;
        }
    }
}
