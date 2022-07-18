package com.feng.newline.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.hashtable
 * @className: L1两数之和
 * @author: Ladidol
 * @description:
 * @date: 2022/7/18 14:30
 * @version: 1.0
 */
public class L1两数之和 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                //匹配加起来等于target的情况
                if (map.containsKey(target-nums[i])){
                    //返回前面那个加数的数组下标
                    return new int[]{map.get(target-nums[i]),i};
                }
                map.put(nums[i],i);//将下标放到value中,值放到key里面.
            }
//            throw new IllegalArgumentException("No two sum solution");
            return new int[]{};
        }
    }
}
