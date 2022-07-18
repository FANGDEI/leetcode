package com.feng.newline.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L349两个数组的交集
 * @author: Ladidol
 * @description: 取出两个数组中共有的元素，去重！
 * @date: 2022/7/18 13:23
 * @version: 1.0
 */
public class L349两个数组的交集 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            boolean[] hashTable1 = new boolean[1000];
//            ArrayList<Integer> resultList = new ArrayList<>();//为了不重复要用set
            Set<Integer> resultSet = new HashSet<>();
            for (int i : nums1) {
                hashTable1[i] = true;
            }
            for (int i : nums2) {
                if (hashTable1[i]){
                    resultSet.add(i);
                }
            }
            int index = 0;
            int[] result = new int[resultSet.size()];
            //将结果几何转为数组
            for (int i : resultSet) {
                result[index++] = i;
            }
            return result;
        }
    }
}
