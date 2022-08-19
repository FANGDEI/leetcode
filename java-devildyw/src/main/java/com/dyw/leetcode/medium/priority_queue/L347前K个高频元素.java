package com.dyw.leetcode.medium.priority_queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Devil
 * @since 2022-08-19-10:46
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
@SuppressWarnings("all")
public class L347前K个高频元素 {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        //使用map存储计数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        //stream流 对set进行排序 去前k个元素组成一个数组
        return set.stream()
                .sorted(Comparator.comparingInt(entry -> -entry.getValue()))
                .limit(k)
                .mapToInt(entry -> entry.getKey())
                .toArray();
    }
}
