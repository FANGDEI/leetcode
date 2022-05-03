package com.feng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: PACKAGE_NAME
 * @className: com.feng.leetcode.L1两数之和
 * @author: Ladidol
 * @description:
 * @date: 2022/5/3 14:28
 * @version: 1.0
 */
public class L1两数之和 {
}
class 两数之和map {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //匹配加起来等于target的情况
            if (map.containsKey(target-nums[i])){
                //返回前面那个加数的数组下标
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
