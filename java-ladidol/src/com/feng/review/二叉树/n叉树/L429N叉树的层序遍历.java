package com.feng.review.二叉树.n叉树;



import java.util.*;

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
 * @date: 2022/7/29 20:29 2023年3月5日11:32:20
 * @version: 1.0
 */
public class L429N叉树的层序遍历 {

    class Solution {//2023年3月5日11:35:16复习
        public List<List<Integer>> levelOrder(Node root) {
            Deque<Node> queue = new ArrayDeque<>();
            List<List<Integer>> res = new LinkedList<>();
            if (root != null) queue.offer(root);

            while (!queue.isEmpty()) {
                List<Integer> tmp = new LinkedList<>();
                int curSize = queue.size();
                while (curSize > 0) {
                    Node cur = queue.poll();
                    tmp.add(cur.val);
                    for (Node child : cur.children) {
                        queue.offer(child);
                    }
                    curSize--;
                }
                res.add(tmp);
            }
            return res;
        }
    }


}