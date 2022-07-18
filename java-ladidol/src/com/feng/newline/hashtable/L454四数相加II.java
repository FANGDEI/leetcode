package com.feng.newline.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L454四数相加II
 * @author: Ladidol
 * @description: 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 例如:
 * 输入: A = [ 1, 2] B = [-2,-1] C = [-1, 2] D = [ 0, 2] 输出: 2 解释: 两个元组如下:
 * (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 升级:
 * 不可以包含重复的四元组，大家可以思考一下.
 * @date: 2022/7/18 14:37
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
                    if (hashTable.containsKey(sum)) {
                        hashTable.put(sum, hashTable.get(sum) + 1);
                    }else{//对立关系.
                        hashTable.put(sum, 1);
                    }
                }
            }
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
