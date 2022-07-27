package com.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-07-20-14:56
 * <p>
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
@SuppressWarnings("all")
public class L145二叉树的后序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        List<Integer> integers = new L145二叉树的后序遍历().postorderTraversal(treeNode);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postorder(list, root);
        return list;
    }

    private void postorder(List list, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postorder(list, root.left);
        }
        if (root.right != null) {
            postorder(list, root.right);
        }
        list.add(root.val);
    }
}
