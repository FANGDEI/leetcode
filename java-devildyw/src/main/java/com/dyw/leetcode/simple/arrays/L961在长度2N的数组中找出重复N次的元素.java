package com.dyw.leetcode.simple.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-07-10-11:51
 * <p>
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 */
@SuppressWarnings("all")
public class L961在长度2N的数组中找出重复N次的元素 {
    public static void main(String[] args) {
        System.out.println(new L961在长度2N的数组中找出重复N次的元素().repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    public int repeatedNTimes(int[] nums) {
        int count = 1;
        int target = nums.length / 2;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count == target) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 记重复n次的元素为x。由于数组nums中有n+1个不同的元素，而其长度为2n，那么数组中剩余的元素均只出现了一次。
     * 也就是说，我们只需要找到重复出现的元素即为答案。
     *
     * @param nums
     * @return
     */
    public int repeatedNTimes01(int[] nums) {
        //使用hashset
        HashSet<Integer> found = new HashSet<>();
        //遍历一次数组 因为其他数字都只出现那一次 而那个特殊的要出现n次 所以一次遍历找到那个重复的即可
        for (int num : nums) {
            if (!found.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
