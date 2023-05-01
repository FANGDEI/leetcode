package com.feng.newline.binarytree;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/4/18 13:46
 * @description: {}
 */
public class L1026节点与其祖先之间的最大差值 {

    class Solution {
        int ans;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root, root.val, root.val);
            return ans;
        }

        /**
         * 题目意思等价遍历的时候维护最大值和最小值，然后用当前值去相减。
         * 疑惑来源：这里是值传递，不是地址传递，所以一条路走到底的路上，不会受到另一边最大值的影响。
         *
         * @param root
         * @param min
         * @param max
         */
        void dfs(TreeNode root, int min, int max) {
            if (root == null) return;
            min = Math.min(min, root.val);
            max = Math.max(max, root.val);
            //维护最大差值
            ans = Math.max(ans, Math.max(max - root.val, root.val - min));
            dfs(root.left, min, max);
            dfs(root.right, min, max);

        }
    }
}
