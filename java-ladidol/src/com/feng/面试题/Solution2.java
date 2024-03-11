package com.feng.面试题;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static int countPairs(int[] arr) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                count += map.get(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countPairs(new int[]{2,2,2,2});
        System.out.println("count = " + count);
    }
}