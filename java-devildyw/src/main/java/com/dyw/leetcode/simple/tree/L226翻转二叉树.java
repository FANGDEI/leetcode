package com.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-07-22-11:10
 * <p>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220722111142014.png">
 */
@SuppressWarnings("all")
public class L226翻转二叉树 {
    public static void main(String[] args) {

    }

    /**
     * 递归 从叶子节点开始翻转节点
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        //如果节点为空 返回空
        if (root == null) {
            return null;
        }
        //翻转右子树后得到的新的右子树 该右子树下的所有节点都被反转了
        TreeNode right = invertTree(root.right);
        //翻转左子树后得到的新的左子树 该左子树下的所有节点都被反转了
        TreeNode left = invertTree(root.left);
        //再将反转后的节点 分别翻转赋值给该层节点的左右子树
        root.left = right;
        root.right = left;
        //这样一直从下网上翻转直到根节点的两个节点翻转 那么整个树都被翻转了
        return root;

    }

}
