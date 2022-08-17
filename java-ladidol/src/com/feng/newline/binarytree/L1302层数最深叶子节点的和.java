package com.feng.newline.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L1302层数最深叶子节点的和
 * @author: Ladidol
 * @description: 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 * 示例 1：
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 * 示例 2：
 * <p>
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * 输出：19
 * @date: 2022/8/17 17:28
 * @version: 1.0 每日一题；
 */
public class L1302层数最深叶子节点的和 {
    //层序遍历
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if (root == null) return 0;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int theDeepestSum = 0;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int levelSum = 0;
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    levelSum += cur.val;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
                theDeepestSum = levelSum;
            }
            return theDeepestSum;
        }
    }
}
