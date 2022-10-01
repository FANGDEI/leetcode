package com.dyw.leetcode.medium.tree;

import java.util.Arrays;

/**
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 *
 * @author Devil
 * @since 2022-10-01-12:43
 */
@SuppressWarnings("all")
public class L654最大二叉树 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length==0){
            return null;
        }
        TreeNode root = findNode(nums,0,nums.length);
        return root;
    }

    private TreeNode findNode(int[] nums, int begin, int end) {
        if (end-begin==0){
            return null;
        }

        if (end-begin==1){
            return new TreeNode(nums[begin]);
        }

        int max = nums[begin];
        int index = begin;
        for (int i=begin+1;i<end;i++){
            if (max<nums[i]){
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = findNode(nums,begin,index);

        root.right = findNode(nums,index+1,end);
        return root;
    }


}
