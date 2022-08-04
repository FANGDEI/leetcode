package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L108将有序数组转换为二叉搜索树
 * @author: Ladidol
 * @description: 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @date: 2022/8/4 17:23
 * @version: 1.0
 */
public class L108将有序数组转换为二叉搜索树 {
    //因为二分取值不同，答案不唯一
    //就是转化成平衡二叉搜索树，这里不用强调平衡的，一般我们生成二叉平衡树都是默认取中间值为为根节点。
    //本质就是寻找分割点，分割点作为当前节点，然后递归左区间和右区间。注意避开已经用过的节点，还要对二分有所了解。
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            TreeNode root = getBST(nums, 0, nums.length - 1);
            return root;
        }

        TreeNode getBST(int[] nums, int start, int end) {//不需要传入一个节点参数，你只需要返回的时候是节点就行。
            if (start > end) return null;//到底了
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = getBST(nums, start, mid - 1);//左区间
            root.right = getBST(nums, mid + 1, end);//右区间
            return root;
        }
    }
}
