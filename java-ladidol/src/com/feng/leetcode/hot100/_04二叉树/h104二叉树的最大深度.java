package com.feng.leetcode.hot100._04二叉树;

import java.util.ArrayDeque;

public class h104二叉树的最大深度 {


    // 层序遍历
    class Solution111 {
        public int maxDepth(TreeNode root) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            if (root == null) return 0;
            queue.offer(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                int curSize = queue.size();
                for (int i = 0; i < curSize; i++) {
                    // 构造下一层
                    TreeNode poll = queue.poll();
                    if (poll.left != null) queue.offer(poll.left);
                    if (poll.right != null) queue.offer(poll.right);
                }
                depth++;
            }
            return depth;
        }
    }

    // dfs
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

}
