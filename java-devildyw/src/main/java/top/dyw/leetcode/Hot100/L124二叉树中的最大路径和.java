package top.dyw.leetcode.Hot100;

public class L124二叉树中的最大路径和 {
    class Solution {
        int maxSum = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            maxPathSumHelper(root);
            return maxSum;
        }

        public int maxPathSumHelper(TreeNode root) {
            if (root==null) {
                return 0;
            }



            int leftVal = Math.max(0, maxPathSumHelper(root.left));
            int rightVal = Math.max(0, maxPathSumHelper(root.right));

            maxSum = Math.max(root.val + leftVal + rightVal, maxSum);

            return Math.max(leftVal, rightVal) + root.val;
        }
    }
}
