package top.dyw.leetcode.Hot100;

public class L104二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }

        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
