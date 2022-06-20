package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-18-16:27
 *
 * nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
 *
 * 给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
@SuppressWarnings("all")
public class L496下一个更大元素I {
    public static void main(String[] args) {
        new L496下一个更大元素I().nextGreaterElement(new int[]{4,1,2},new int[]{1,3,4,2});
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length = nums2.length;
        int m = nums1.length;
        int[] ints = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i]==nums2[j]){
                    int k = 0;
                    for (k = j; k < nums2.length; k++) {
                        if (nums1[i]<nums2[k]){
                            ints[i] = nums2[k];
                            break;
                        }
                    }
                    if (k>=nums2.length){
                        ints[i] = -1;
                    }
                    break;
                }
            }
        }
        return ints;
    }

    public int[] nextGreaterElement01(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int j = 0;
            while (j < n && nums2[j] != nums1[i]) {
                ++j;
            }
            int k = j + 1;
            while (k < n && nums2[k] < nums2[j]) {
                ++k;
            }
            res[i] = k < n ? nums2[k] : -1;
        }
        return res;
    }
}
