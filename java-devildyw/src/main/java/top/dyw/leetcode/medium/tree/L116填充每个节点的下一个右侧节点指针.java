package top.dyw.leetcode.medium.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 *
 * @author Devil
 * @since 2022-09-21-11:25
 */
@SuppressWarnings("all")
public class L116填充每个节点的下一个右侧节点指针 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    /**
     * 层序遍历
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        Deque<Node> deque = new LinkedList<>();
        if (root==null) {
            return root;
        }

        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            Node temp = null;
            while (len-->0){
                Node node = deque.poll();
                if (temp==null){
                    temp = node;
                }else{
                    temp.next = node;
                    temp = node;
                }

                if (node.left!=null){
                    deque.offer(node.left);
                }
                if (node.right!=null){
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }
}
