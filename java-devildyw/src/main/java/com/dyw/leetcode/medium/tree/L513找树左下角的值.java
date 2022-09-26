package com.dyw.leetcode.medium.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 *
 * @author Devil
 * @since 2022-09-24-13:20
 */
@SuppressWarnings("all")
public class L513找树左下角的值 {
    public static void main(String[] args) {

    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);


        while (!deque.isEmpty()){
            int size = deque.size();
            res = deque.peek().val;
            while (size-->0){
                TreeNode node = deque.poll();
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
        }
        return res;
    }
}
