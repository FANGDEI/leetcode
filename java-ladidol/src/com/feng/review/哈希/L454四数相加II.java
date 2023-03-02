package com.feng.review.哈希;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L454四数相加II
 * @author: Ladidol
 * @description: <p>
 * 升级:
 * 不可以包含重复的四元组，大家可以思考一下.
 * 通过两数之和的思路来做
 * @date: 2022/7/18 14:37 2023年2月28日23:56:39
 * @version: 1.0
 */
public class L454四数相加II {

    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            Map<Integer, Integer> hashTable = new HashMap<>();
            int count = 0;
            int sum = 0;
            //统计两个数组中的元素之和，同时统计出现的次数，放入map
            for (int i : nums1) {
                for (int j : nums2) {
                    sum = i + j;
                    hashTable.put(sum, hashTable.getOrDefault(sum, 0) + 1);
                }
            }
            System.out.println("hashTable = " + hashTable);

            //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
            for (int i : nums3) {
                for (int j : nums4) {
                    sum = i + j;
                    if (hashTable.containsKey(0 - sum)) {
                        count += hashTable.get(0 - sum);//分成了两个n*n的解决方式,可以直接加起来了.
                    }
                }
            }
            return count;
        }
    }
}
