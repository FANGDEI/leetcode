package top.dyw.leetcode.simple.hash;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 * @author Devil
 * @since 2022-09-08-11:35
 */
@SuppressWarnings("all")
public class L1两数之和 {

    public static void main(String[] args) {

    }

    /**
     * 本题适合hash表的做法 比暴力两层for更快
     *
     * 本题的要求非常适合 使用一个集合来存放我们遍历过的元素，然后在遍历数组的时候去访问这个集合，某元素是否遍历过，是的话就返回这个元素的下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
