package com.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @author Devil
 * @since 2022-09-22-11:20
 */
@SuppressWarnings("all")
public class L589N叉树的前序遍历 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {

    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursion(root, result);
        return result;
    }

    /**
     * 递归法 中 左 右
     */
    public void preorderRecursion(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            preorderRecursion(child, result);
        }
    }


    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder01(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root==null){
            return result;
        }
        deque.push(root);
        while (!deque.isEmpty()){
            Node node = deque.peek();
            if (node!=null){
                deque.pop();
                List<Node> children = node.children;
                for (int i = children.size()-1; i>=0; i--) {
                    deque.push(children.get(i));
                }
                deque.push(node);
                deque.push(null);
            }else{
                deque.pop();
                node = deque.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}