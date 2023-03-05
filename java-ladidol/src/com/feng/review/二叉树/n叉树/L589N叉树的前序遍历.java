package com.feng.review.二叉树.n叉树;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L589N叉树的前序遍历
 * @author: Ladidol
 * @description: 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 * @date: 2022/7/30 0:07
 * @version: 1.0
 */
public class L589N叉树的前序遍历 {


    class Solution12342 {
        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            ArrayDeque<Node> stack = new ArrayDeque<>();//一个节点群为单位下压.
            stack.push(root);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                res.add(cur.val);
                List<Node> children = cur.children;
                for (int i = children.size() - 1; i >= 0; i--) {
                    if (children.get(i) != null) {
                        stack.push(children.get(i));
                    }
                }
            }
            return res;
        }
    }


    //递归遍历
    class Solution {//2022年10月19日17:13:49复习
        public List<Integer> preorder(Node root) {
            dfs(root);
            return res;
        }

        List<Integer> res = new ArrayList<>();

        void dfs(Node root) {
            if (root == null) return;

            res.add(root.val);
            for (Node child : root.children) {
                dfs(child);
            }
        }
    }


}
    /*
// Definition for a Node.
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
};
*/