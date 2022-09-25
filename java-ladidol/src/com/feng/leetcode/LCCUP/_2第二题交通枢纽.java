package com.feng.leetcode.LCCUP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @projectName: leetcode
 * @package: com.feng.leetcode.LCCUP
 * @className: 第二题交通枢纽
 * @author: Ladidol
 * @description:
 * @date: 2022/9/24 16:02
 * @version: 1.0
 */
public class _2第二题交通枢纽 {
    // 0号位不存在的数字，1号位出现了n-1次的
    class Solution {
        //
        public int transportationHub(int[][] path) {
            Map<Integer, Integer> start = new HashMap<>();
            Map<Integer, Integer> end = new HashMap<>();
            Set<Integer> set = new HashSet<>();//去重，计算个数n；
            for (int[] ints : path) {
                start.put(ints[0], start.getOrDefault(ints[0], 0) + 1);
                end.put(ints[1], end.getOrDefault(ints[1], 0) + 1);
                set.add(ints[0]);
                set.add(ints[1]);
            }
            int n = set.size();
            for (int i : end.keySet()) {
                if (!start.containsKey(i) && end.get(i) == n - 1){
                    return i;
                }
            }
            return -1;
        }
    }
}
