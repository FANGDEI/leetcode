package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L701二叉搜索树中的插入操作
 * @author: Ladidol
 * @description: 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * @date: 2022/8/4 16:16
 * @version: 1.0
 */
public class L701二叉搜索树中的插入操作 {



    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);//找到了，返回子节点。
            if (root.val>val) root.left = insertIntoBST(root.left, val);//返回子节点
            if (root.val<val) root.right = insertIntoBST(root.right, val);
            return root;
        }
    }
}
