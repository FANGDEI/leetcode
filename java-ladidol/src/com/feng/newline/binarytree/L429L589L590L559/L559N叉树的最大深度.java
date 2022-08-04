package com.feng.newline.binarytree.L429L589L590L559;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree.L429L589L590
 * @className: L559N叉树的最大深度
 * @author: Ladidol
 * @description: 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * @date: 2022/7/31 15:23
 * @version: 1.0
 */
public class L559N叉树的最大深度 {
    //类似二叉树最大深度一样。

    //dfs
    class Solution1 {
        public int maxDepth(Node root) {
            if (root == null) return 0;//返回深度；
            int maxDepth = 0;
            for (Node child : root.children) {
                int depth = maxDepth(child);
                maxDepth = Math.max(depth, maxDepth);
            }
            return maxDepth + 1;
        }
    }

    //bfs
    class Solution {
        public int maxDepth(Node root) {
            if (root == null) return 0;
            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);
            int maxDepth = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                maxDepth++;
                while (levelSize > 0) {
                    Node cur = queue.poll();
                    for (Node child : cur.children) {
                        if (child!=null) queue.offer(child);
                    }
                    levelSize--;
                }
            }
            return maxDepth;
        }
    }
}
