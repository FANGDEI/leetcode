package com.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 *
 * @author Devil
 * @since 2022-09-21-10:41
 */
@SuppressWarnings("all")
public class L637二叉树的层平均值 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root==null){
            return result;
        }
        deque.offer(root);

        while (!deque.isEmpty()){
            int len = deque.size();
            int n = len;
            double sum = 0.0;
            while (len-->0){
                TreeNode node = deque.poll();
                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
                sum += node.val;
            }
            result.add(sum/n);
        }
        return result;
    }
}
