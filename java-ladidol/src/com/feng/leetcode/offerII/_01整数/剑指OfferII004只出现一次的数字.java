package com.feng.leetcode.offerII._01整数;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/1 20:54
 * @description: {}
 */
public class 剑指OfferII004只出现一次的数字 {

    //朴素做法
    class Solution {
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            for (int x : map.keySet()) {
                if (map.get(x) == 1) return x;
            }
            return -1;
        }
    }

}
