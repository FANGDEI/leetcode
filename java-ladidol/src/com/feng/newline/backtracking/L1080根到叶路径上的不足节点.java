package com.feng.newline.backtracking;

import com.feng.newline.binarytree.TreeNode;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/5/22 20:20
 * @description: {}
 */
public class L1080根到叶路径上的不足节点 {


    class Solution {
        /**
         * 根据灵神的解法：
         * 1、怎么判断当前节点是不是不足节点；
         * 2、怎么把最后才能判断的结果传递进去；
         * <p>
         * 值得注意的是，最开始的遍历到的叶子结点，可以判断是否满足，如果不是不足叶节点，直接返回当前root；
         *
         * @param root
         * @param limit
         */
        public TreeNode sufficientSubset(TreeNode root, int limit) {

            if (root.left == null && root.right == null) {
                return root.val < limit ? null : root;
            }
            if (root.left != null) root.left = sufficientSubset(root.left, limit - root.val);
            if (root.right != null) root.right = sufficientSubset(root.right, limit - root.val);
            return root.left == null && root.right == null ? null : root;
        }
    }
}
