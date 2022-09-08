package com.dyw.leetcode.simple.map;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * @author Devil
 * @since 2022-09-08-10:43
 */
@SuppressWarnings("all")
public class L349两个数组的交集 {
    public static void main(String[] args) {

    }

    /**
     * Hashset
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)){
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(x ->x).toArray();
    }


    /**
     * 数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection01(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        int[] hash = new int[1000];

        for (int i : nums1) {
            hash[i] = 1;
        }

        for (int i : nums2) {
            if (hash[i]==1){
                set.add(i);
            }
        }

        return set.stream().mapToInt(x->x).toArray();
    }
}
