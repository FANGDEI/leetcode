package top.dyw.leetcode.Hot100;

public class L543二叉树的直径 {
    // 这个题太经典了 再做一次都不为过
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        // 与全局最大值做比较
        maxDiameter = Math.max(maxDiameter, maxLeftDepth+maxRightDepth);

        return Math.max(maxLeftDepth, maxRightDepth) + 1;
    }
}
