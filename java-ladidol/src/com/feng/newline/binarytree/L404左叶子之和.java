package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L404左叶子之和
 * @author: Ladidol
 * @description: 给定二叉树的根节点 root ，返回所有左叶子之和。
 * @date: 2022/7/31 21:26
 * @version: 1.0
 */
public class L404左叶子之和 {


    class Solution {
        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) return sum;
            if (root.left != null && isLeaf(root.left)) sum += root.left.val;
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
            return sum;
        }

        boolean isLeaf(TreeNode node) {
            if (node.left == null && node.right == null) return true;
            return false;
        }
    }
}
