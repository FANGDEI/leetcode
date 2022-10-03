package com.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author Devil
 * @since 2022-10-03-12:15
 */
@SuppressWarnings("all")
public class L530二叉搜索树的最小绝对差 {

    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list.size()-1; i++) {
            min = Math.min(min,Math.abs(list.get(i)-list.get(i+1)));
        }
        return min;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root==null){
            return;
        }
        traversal(root.left,list);
        list.add(root.val);
        traversal(root.right,list);
    }
}
