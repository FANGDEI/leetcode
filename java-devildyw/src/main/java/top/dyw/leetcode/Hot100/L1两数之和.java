package top.dyw.leetcode.Hot100;

import java.util.*;
public class L1两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1,-1};
    }
}
