package com.feng.leetcode.offer._07搜索和回溯;

/**
 * @author: Xiaoqiang-Ladidol
 * @date: 2023/7/24 21:45
 * @description: {}
 */
public class 剑指Offer27二叉树的镜像 {


    //dfs
    class Solution {
        /**
         * 就是翻转左右子节点
         * <p>
         * 可以发现想要翻转它，其实就把每一个节点的左右孩子交换一下就可以了。
         * 关键在于遍历顺序，前中后序应该选哪一种遍历顺序？
         * 这边建议直接用前序遍历或者后序遍历
         *
         * @param root
         * @return
         */
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null) return null;
            swap(root);
            mirrorTree(root.left);
            mirrorTree(root.right);
            return root;
        }

        public void swap(TreeNode node) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

    }


}
