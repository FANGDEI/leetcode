package com.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author Devil
 * @since 2022-10-12-13:18
 */
@SuppressWarnings("all")
public class L78子集 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> set = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums,0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex) {
        //在递归的过程中 遇到一个集合就添加（第一次进入的时候因为集合没有一个元素 所以会添加空集）
        result.add(new ArrayList<>(set));

        //终止条件 当startIndex >= nums.length 时就可以返回 因为后续再遍历也没有意义
        if (startIndex>=nums.length){
            return;
        }

        //如果不符合终止条件
        for (int i = startIndex; i<nums.length;i++){
            set.add(nums[i]);
            subsetsHelper(nums,i+1);
            set.removeLast();
        }
    }
}
