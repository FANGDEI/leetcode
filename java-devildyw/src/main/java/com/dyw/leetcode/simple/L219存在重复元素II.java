package com.dyw.leetcode.simple;

import java.util.HashMap;

/**
 * @author Devil
 * @date 2022-05-01-14:15
 *
 *
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个
 * 不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 */
@SuppressWarnings("all")
public class L219存在重复元素II {
    public static void main(String[] args) {
        boolean b = new L219存在重复元素II().containsNearbyDuplicate(new int[]{1,0,1,1
        }, 1);
        System.out.println(b);
    }

    /**
     * hashmap
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])&&(i-map.get(nums[i]))<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
