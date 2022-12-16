package com.dyw.leetcode.medium.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * @author Devil
 * @since 2022-09-09-10:27
 */
@SuppressWarnings("all")
public class L454四数相加II {

    public static void main(String[] args) {

    }

    /**
     * hash
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //初始一个map 用来记录nums1 和 nums2 元素之和的出现次数
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;

        //统计两个数组中的元素之和，同时统计出现的次数，放入map中
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        //统计剩余两个元素的和，在map中找是否存在相加为0的情况，同时统计次数
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(0 - temp)){
                    res+=map.get(0-temp);
                }
            }
        }

        return res;

    }
}
