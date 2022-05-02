package com.dyw.leetcode.simple;

import java.util.HashSet;

/**
 * @author Devil
 * @date 2022-05-01-14:00
 *
 *
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
@SuppressWarnings("all")
public class L217存在重复元素 {
    /**
     * 使用hashset 通过hashset的add方法 判断是否一个元素出现两次
     *
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (!integers.add(num)) {
                return true;
            }
        }
        return false;
    }
}
