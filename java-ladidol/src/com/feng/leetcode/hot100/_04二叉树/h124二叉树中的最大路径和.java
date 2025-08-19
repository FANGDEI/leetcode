package com.feng.leetcode.hot100._04二叉树;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/19 11:36
 */
public class h124二叉树中的最大路径和 {

  class Solution {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
      dfs(root);
      return ans;
    }
    int dfs(TreeNode root){
      if (root == null) {
        return 0;
      }
      int leftSum = dfs(root.left);
      int rightSum = dfs(root.right);
      ans = Math.max(ans, leftSum + rightSum + root.val);
      // 和0比较，如果比零小，直接断开连接
      return Math.max(Math.max(leftSum, rightSum) + root.val, 0);
    }
  }

}
