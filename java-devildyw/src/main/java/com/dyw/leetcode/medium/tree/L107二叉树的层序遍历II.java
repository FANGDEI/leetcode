package com.dyw.leetcode.medium.tree;

import java.util.*;

/**
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @author Devil
 * @since 2022-09-20-13:08
 */
@SuppressWarnings("all")
public class L107二叉树的层序遍历II {

    /**
     * 从题意的 我们只需要返回的 List 是按从低层向上的即可
     * 那么我们直接按顺序遍历 最后将list翻转返回即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root==null){
            return resList;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        while (!deque.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int len = deque.size();
            while (len>0){
                TreeNode node = deque.poll();
                tempList.add(node.val);
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
                len--;
            }
            resList.add(tempList);
        }
        Collections.reverse(resList);
        return resList;
    }
}
