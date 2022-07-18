package com.feng.newline.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L350两个数组的交集II
 * @author: Ladidol
 * @description: 取出两个数组中共有的元素，不去重！
 * @date: 2022/7/18 13:43
 * @version: 1.0
 */
public class L350两个数组的交集II {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            int[] hashTable1 = new int[1001];
            List<Integer> resultList = new ArrayList<>();
            for (int i : nums1) {
                hashTable1[i] ++;
            }
            for (int i : nums2) {
                //因为求交集和349的交集有点不一样的要求了，这就用int[]数组来计数，
                if (hashTable1[i]>0){
                    resultList.add(i);
                    hashTable1[i]--;//同时为了保证取交集，最小的重复，要对nums1中的移除。
                }
            }
            int index = 0;
            int[] result = new int[resultList.size()];
            //将结果几何转为数组
            for (int i : resultList) {
                result[index++] = i;
            }
            return result;
        }
    }
}
