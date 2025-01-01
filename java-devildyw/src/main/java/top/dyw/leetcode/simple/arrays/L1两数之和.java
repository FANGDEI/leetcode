package top.dyw.leetcode.simple.arrays;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-07-12-9:52
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */
@SuppressWarnings("all")
public class L1两数之和 {
    public static void main(String[] args) {
        int[] ints = new L1两数之和().twoSum(new int[]{3, 2, 4}, 6);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }



}
