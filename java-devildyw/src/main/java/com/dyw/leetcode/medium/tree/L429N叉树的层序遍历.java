package com.dyw.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * @author Devil
 * @since 2022-09-21-10:54
 */
@SuppressWarnings("all")
public class L429N叉树的层序遍历 {

    /**
     * 层序遍历
     * @param root
     * @return List<List<Integer>>
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root==null){
            return resList;
        }
        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            List<Integer> list = new ArrayList<>();
            while (len-->0){
                Node node = deque.poll();
                list.add(node.val);
                List<Node> children = node.children;
                for (Node child : children) {
                    deque.offer(child);
                }
            }
            resList.add(list);
        }

        return resList;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}