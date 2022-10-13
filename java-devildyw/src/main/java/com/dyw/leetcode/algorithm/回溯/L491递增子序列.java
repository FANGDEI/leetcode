package com.dyw.leetcode.algorithm.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
@SuppressWarnings("all")
public class L491递增子序列 {

    public static void main(String[] args){

    }



    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     *
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequencesHelper(nums,0);
        return result;
    }

    private void findSubsequencesHelper(int[] nums, int startIndex) {
        if (path.size()>=2){
            result.add(new ArrayList<>(path));
        }

        int[] used = new int[201];//用来记录那些数字在本层中使用了
        for (int i = startIndex; i<nums.length; i++){
            //前面部分判断是否是升序 后半部分判断是否是该层已经选用的
            if (!path.isEmpty()&&nums[i]<path.getLast()||(used[nums[i]+100]==1)){
                continue;
            }

            //标记为该层该数字已经被选用
            used[nums[i]+100] = 1;

            path.add(nums[i]);
            findSubsequencesHelper(nums,i+1);
            path.removeLast();
        }
    }
}