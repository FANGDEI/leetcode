package com.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-07-21-12:06
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 */
@SuppressWarnings("all")
public class L104二叉树的最大深度 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
        }
    }
}
