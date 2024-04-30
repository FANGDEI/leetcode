package com.feng.leetcode.hot100._01哈希;

import java.util.HashMap;
import java.util.Map;

public class H001两数之和 {


    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target-nums[i])){
                    return new int[]{ map.get(target-nums[i]),i};
                }
                map.put(nums[i],i);
            }
            return new int[]{};
        }
    }
}


