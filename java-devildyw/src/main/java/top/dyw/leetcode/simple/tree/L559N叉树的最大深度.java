package top.dyw.leetcode.simple.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 * @author Devil
 * @since 2022-09-23-10:58
 */
@SuppressWarnings("all")
public class L559N叉树的最大深度 {

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


    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        int count = 0;
        if (root==null){
            return count;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            count++;
            while (len-->0){
                Node node = deque.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    deque.offer(child);
                }
            }
        }
        return count;
    }
}
