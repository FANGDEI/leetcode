package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L513找树左下角的值
 * @author: Ladidol
 * @description: 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * @date: 2022/7/31 21:40
 * @version: 1.0
 */
public class L513找树左下角的值 {

    //bfs 层序遍历
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int theBottomLeft = root.val;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int guDingSize = levelSize;
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    if (guDingSize == levelSize) {
                        theBottomLeft = cur.val;
                    }
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
            }
            return theBottomLeft;
        }
    }
}
