package com.dyw.leetcode.simple.arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Devil
 * @date 2022-05-02-14:55
 *
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
@SuppressWarnings("all")
public class L268丢失的数字 {
    /**
     * 排序法
     */
    public int missingNumber(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int length = nums.length;
        //遍历数组
        for (int i = 0; i < length; i++) {
            //如果nums[i] != i 直接返回i即可
            //0 1 2 3 5 6  length = 6
            //0 1 2 3 4 5 没有 4
            if (nums[i]!=i){
                return i;
            }
        }
        // 如果遍历了整个数组都没有发现那个数字 那个就是length本身
        return length;
    }

    /**
     * hashset
     */
    public int missingNumber01(int[] nums) {
        int length = nums.length;
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 0; i < length; i++) {
            integers.add(nums[i]);
        }
        for (int i = 0; i < length; i++) {
            if (!integers.contains(i)){
                return i;
            }
        }
        return length;
    }
}
