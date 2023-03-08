package com.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Devil
 * @since 2023-03-05-20:34
 */
@SuppressWarnings("all")
public class O32I从上到下打印二叉树 {
    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()){
            int len = deque.size();
            while (len-->0){
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;


        TreeNode(int x) {
            val = x;
        }

    }
}
