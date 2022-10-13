package com.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
@SuppressWarnings("all")
public class L90子集II {

    public static void main(String[] args) {
        System.out.println(new L90子集II().subsetsWithDup(new int[]{1,2,3}));
    }


    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    /**
     * 回溯
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //为了去重先对数组排序
        Arrays.sort(nums);
        subsetsWithDupHelper(nums,0);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex>=nums.length){
            return;
        }

        for (int i = startIndex; i<nums.length;i++){
            if (i>startIndex&&nums[i]==nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            subsetsWithDupHelper(nums,i+1);
            path.removeLast();
        }
    }

}