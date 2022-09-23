package com.dyw.leetcode.simple.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 *
 * @author Devil
 * @since 2022-09-23-11:15
 */
@SuppressWarnings("all")
public class L222完全二叉树的节点个数 {

    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        int count = 0;
        if (root==null){
            return count;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            while (len-->0){
                TreeNode node = deque.poll();
                count++;
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
        }
        return count;
    }

}
