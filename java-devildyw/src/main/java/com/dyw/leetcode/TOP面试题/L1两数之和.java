package com.dyw.leetcode.TOP面试题;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-11-30-10:23
 */
@SuppressWarnings("all")
public class L1两数之和 {
    /**
     * hashmap 存储下标的方式（将遍历过程中的值存在map中 当后序遍历到的时候就可以直接在map中获取 而不是遍历） 将时间复杂度缩小
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
