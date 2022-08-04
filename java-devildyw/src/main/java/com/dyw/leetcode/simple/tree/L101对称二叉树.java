package com.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-07-21-12:25
 */
@SuppressWarnings("all")
public class L101对称二叉树 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return symmetric(root, root);
    }

    public boolean symmetric(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        return r1.val == r2.val && symmetric(r1.left, r2.right) && symmetric(r1.right, r2.left);
    }
}
