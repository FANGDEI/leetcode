package com.feng.leetcode.offerII._02数组;

import java.util.*;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/3 16:04
 * @description: {}
 */
public class 剑指OfferII006排序数组中两个数字之和 {

    //不就是两数之和吗
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                int pre = target - numbers[i];
                if (map.get(pre) != null) return new int[]{map.get(pre), i};
                map.put(numbers[i], i);
            }
            return new int[0];
        }
    }
}
