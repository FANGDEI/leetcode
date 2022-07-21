package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L814二叉树剪枝
 * @author: Ladidol
 * @description:
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]
 * @date: 2022/7/21 9:34
 * @version: 1.0
 */
public class L814二叉树剪枝 {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = null;
//        root.right = new TreeNode(0);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(1);
//
//        new Solution().pruneTree(root);
//        System.out.println("root.right.left = " + root.right.left);
    }
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            if (root==null){
                return null;
            }
            //先遍历到最底部, 再向上剪枝.顺序不能倒了.
            if (root.left != null) root.left = pruneTree(root.left);
            if (root.right != null) root.right = pruneTree(root.right);

            if (root.val == 0 && root.right == null && root.left == null) {
                return null;
            }
            return root;
        }
    }



}

