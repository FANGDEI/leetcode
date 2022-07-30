package com.feng.newline.binarytree;

import java.util.ArrayDeque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L104二叉树的最大深度
 * @author: Ladidol
 * @description: 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3 。
 * @date: 2022/7/29 21:25
 * @version: 1.0
 */
public class L104二叉树的最大深度 {
    class Solution {
        public int maxDepth(TreeNode root) {
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            if (root == null) return 0;
            queue.offer(root);
            int maxDeep = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                maxDeep++;
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
            }
            return maxDeep;
        }
    }
}
