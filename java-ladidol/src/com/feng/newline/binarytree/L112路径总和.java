package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L112路径总和
 * @author: Ladidol
 * @description: 给你二叉树的根节点root
 * 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * @date: 2022/7/31 21:51
 * @version: 1.0
 */
public class L112路径总和 {
    //dfs+递归+回溯
    //注意判断叶子结点
    class Solution {
        int target;//全局保存目标值
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            target = targetSum;
            return trySum(root,root.val);
        }
        boolean trySum(TreeNode node, int path){
            if (node.left==null&&node.right==null&&path==target) return true;//叶子节点且满足要求
            if (node.left==null&&node.right==null) return false;//叶子结点但没满足要求
            boolean leftOne = false,rightOne = false;
            if (node.left!=null){
                 leftOne = trySum(node.left,path + node.left.val);//有回溯操作！path + node.left.val并未改变path的值
            }
            if (node.right!=null){
                rightOne = trySum(node.right,path+node.right.val);
            }
            return leftOne || rightOne;
        }
    }
}
