package com.dyw.leetcode.DataStructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的递归遍历
 *
 * @author Devil
 * @since 2022-09-19-10:49
 */
@SuppressWarnings("all")
public class TreeRecursionTraverse {


    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }

    /**
     * 前序递归函数
     * @param root
     * @param ans
     */
    private void preorder(TreeNode root, ArrayList<Integer> ans) {
        if (root==null){
            return;
        }
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }


    /**
     * 中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }


    /**
     * 中序递归函数
     * @param root
     * @param ans
     */
    private void inorder(TreeNode root, ArrayList<Integer> ans) {
        if (root==null){
            return;
        }

        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }

    /**
     * 后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    }

    /**
     * 后序递归函数
     * @param root
     * @param ans
     */
    private void postorder(TreeNode root, ArrayList<Integer> ans) {
        if (root==null){
            return;
        }

        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);
    }


}
