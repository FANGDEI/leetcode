package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L700二叉搜索树中的搜索
 * @author: Ladidol
 * @description: 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * @date: 2022/8/3 18:29
 * @version: 1.0
 */
public class L700二叉搜索树中的搜索 {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) return root;
            if (val > root.val) {//当前值大于节点值走右边。
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }
    }
}
