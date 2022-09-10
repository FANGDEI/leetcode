package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L669修剪二叉搜索树
 * @author: Ladidol
 * @description: 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。
 * 可以证明，存在唯一的答案。
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * @date: 2022/8/4 16:58 再做每日一题2022年9月10日11:53:11
 * @version: 1.0
 */
public class L669修剪二叉搜索树 {

    class Solution1 {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return root;
            if (root.val < low) return trimBST(root.right, low, high);//核心所在，小于区间，返回右孩子（修建后的）
            if (root.val > high) return trimBST(root.left, low, high);//大于区间，返回左孩子(修建后的)
            root.left = trimBST(root.left, low, high);//在区间中间处理自己的左右孩子。
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }


    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            // 对于当前节点进行判断，
            // 如果当前节点小于这个范围 就考虑其右子树（二叉搜索树的规律）
            // 如果当前节点大于这个范围 就考虑其左子树
            if (root == null) return null;
            if (root.val < low) return trimBST(root.right, low, high);
            if (root.val > high) return trimBST(root.left, low, high);

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }


}
