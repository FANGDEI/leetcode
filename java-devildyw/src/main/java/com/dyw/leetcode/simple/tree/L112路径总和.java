package com.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-07-22-11:32
 * <p>
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
@SuppressWarnings("all")
public class L112路径总和 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int sum = 0;
        return pathSum(root, sum, targetSum);
    }

    private boolean pathSum(TreeNode root, int sum, int targetSum) {
        //如果该节点为空 那么直接返回是否sum等于targetSum 可以避免传入空节点的情况
        if (root == null) {
            return sum == targetSum;
        }
        //如果不为空 sum加上当前节点的值
        sum += root.val;
        //如果该节点左右子树都为空 那么该节点就是叶子节点 返回是否sum等于targetSum
        if (root.left == null&&root.right == null){
            return sum == targetSum;
        }
        //初始化结果
        boolean right =false;
        boolean left = false;
        //如果左子树不为空 在左子树中查找一条路径是否能使得sum == targetSum
        if (root.left != null) {
             right = pathSum(root.left, sum, targetSum);
        }
        //如果右子树不为空 在右子树中查找一条路径是否能使得sum == targetSum
        if (root.right != null) {
             left = pathSum(root.right, sum, targetSum);
        }
        //只要其中有一种情况满足即可满足题意
        return right||left;
    }
}
