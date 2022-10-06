package com.dyw.leetcode.medium.tree;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

/**
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 * @author Devil
 * @since 2022-10-06-11:21
 */
@SuppressWarnings("all")
public class L669修剪二叉搜索树 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root==null){
            return null;
        }
        //如果当前节点的值小于下界 则该节点下（包括该节点）下的某些部分将被修剪 不会被修剪的节点只有可能存在于 该节点的右子树中（二叉搜索树性质）
        if (root.val<low){
            //因此这里将该节点的右子树继续遍历 最好的情况是直接返回右子树 而原节点包括其左子树都被修剪
            return trimBST(root.right,low,high);
        }

        if (root.val> high){
            return trimBST(root.left,low,high);
        }

        //如果在[low，high]范围内 则继续向下查找是否有子树中有需要修剪的节点。
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }
}
