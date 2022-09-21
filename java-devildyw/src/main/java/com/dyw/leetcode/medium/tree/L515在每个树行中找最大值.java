package com.dyw.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 每日一题
 *
 * @author Devil
 * @since 2022-06-24-14:12
 * <p>
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220624141328627.png" alt="题目">
 */

@SuppressWarnings("all")
public class L515在每个树行中找最大值 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(5);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(9);
        treeNode.right.left = null;

        List<Integer> list = new L515在每个树行中找最大值().largestValues(treeNode);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offer(root);
        }

        while (!deque.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = deque.size();
            while (size-- > 0) {
                TreeNode node = deque.pop();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public List<Integer> largestValues01(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root==null){
            return result;
        }

        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            int max = Integer.MIN_VALUE;
            while (len-->0){
                TreeNode node = deque.poll();
                max = Math.max(node.val,max);
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }
}

