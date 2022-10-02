package com.dyw.leetcode.simple.tree;

/**
 * @author Devil
 * @since 2022-07-23-10:37
 * <p>
 * 给定二叉搜索树（BST）的根节点root和一个整数值val。
 * <p>
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 */
@SuppressWarnings("all")
public class L700二叉搜索树中的搜索 {
    public static void main(String[] args) {

    }

    /**
     * 递归 根据二叉搜索树的特性解题
     * 小的节点总是在左子树上，大的节点总是在右子树上
     *
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220723111906522.png">
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }

    public TreeNode searchBST01(TreeNode root, int val) {
        if (root==null){
            return null;
        }
        if (root.val==val){
            return root;
        }
        return root.val<val?searchBST01(root.right,val):searchBST01(root.left,val);
    }
}
