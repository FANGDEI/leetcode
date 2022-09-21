package com.dyw.leetcode.simple.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-07-21-12:06
 * <p>
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 */
@SuppressWarnings("all")
public class L104二叉树的最大深度 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //如果根节点为空 则返回0
        if (root == null) {
            return 0;
        }
        //如果该节点是叶子节点 则返回1
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            //如果不是叶子节点 则取左右子树最大值并+1
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public int maxDepth01(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            count++;
            int len = deque.size();
            while (len-- > 0) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return count;

    }
}
