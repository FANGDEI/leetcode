package top.dyw.leetcode.simple.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-09-22-11:36
 */
@SuppressWarnings("all")
public class L590N叉树的后序遍历 {

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

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderRecursion(root,result);
        return result;
    }

    public void postorderRecursion(Node node, List<Integer> result) {
        if (node==null){
            return;
        }
        List<Node> children = node.children;
        for (Node child : children) {
            postorderRecursion(child,result);
        }
        result.add(node.val);
    }


    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> postorder01(Node root) {
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
                deque.push(node);
                deque.push(null);

                List<Node> children = node.children;
                for (int i = children.size()-1; i>=0; i--) {
                    deque.push(children.get(i));
                }
            }else{
                deque.pop();
                node = deque.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}
