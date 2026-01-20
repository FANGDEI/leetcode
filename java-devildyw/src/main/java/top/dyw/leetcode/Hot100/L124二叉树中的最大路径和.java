package top.dyw.leetcode.Hot100;

public class L124二叉树中的最大路径和 {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return result;
    }

    public int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 子路径是负的 那么我宁愿不选
        int left = Math.max(0, maxPathSumHelper(root.left));
        int right = Math.max(0, maxPathSumHelper(root.right));

        result = Math.max(result, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
