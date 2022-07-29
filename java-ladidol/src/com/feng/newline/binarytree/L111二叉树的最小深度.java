package com.feng.newline.binarytree;

import java.util.ArrayDeque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L111二叉树的最小深度
 * @author: Ladidol
 * @description: 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * @date: 2022/7/29 21:30
 * @version: 1.0
 */
public class L111二叉树的最小深度 {


    class Solution {
        public int minDepth(TreeNode root) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            if (root == null) return 0;
            queue.offer(root);
            int minDeep = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                minDeep++;//我超, 这里放错位置了.
                TreeNode cur;
                while (levelSize > 0) {
                    cur = queue.poll();
                    //当且仅当两个孩子都是空才是到头了, 怪不得刚刚一直想不通.一直以为是一个孩子为空就行.
                    if (cur.left == null && cur.right == null) {
                        return minDeep;
                    }
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
            }
            return minDeep;
        }
    }
}
