package com.feng.newline.binarytree.L429L589L590L559;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L429N叉树的层序遍历
 * @author: Ladidol
 * @description: 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * @date: 2022/7/29 20:29
 * @version: 1.0
 */
public class L429N叉树的层序遍历 {

    //看题看了半天, 发现输入不是数组, 是已经成样子的root树.
    class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> levelList = new ArrayList<>();
                int levelSize = queue.size();
                while (levelSize > 0) {
                    Node cur = queue.poll();
                    levelList.add(cur.val);//加入当前值
                    if (cur.children != null && cur.children.size() != 0) {
                        for (Node child : cur.children) {//遍历推入children
                            if (child == null) continue;
                            queue.offer(child);
                        }
                    }
                    levelSize--;
                }
                res.add(levelList);
            }
            return res;
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
