package com.feng.newline.binarytree;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L1161最大层内元素和
 * @author: Ladidol
 * @description: 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * @date: 2022/7/31 12:38 每日一题。
 * @version: 1.0
 */
public class L1161最大层内元素和 {
    //bfs 层序遍历。
    class Solution1 {
        public int maxLevelSum(TreeNode root) {
            if (root == null) return 0;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();//一般都用LinkedList来做题，如果能做成功就换成ArrayDeque看看效率能不能提高一些
            queue.offer(root);
            int maxIndex = 1;
            int max = Integer.MIN_VALUE;
            int index = 1;
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int sum = 0;
                while (levelSize > 0) {
                    TreeNode cur = queue.poll();
                    sum += cur.val;
                    if (cur.left != null) queue.offer(cur.left);
                    if (cur.right != null) queue.offer(cur.right);
                    levelSize--;
                }
                if (max < sum) {
                    maxIndex = index;
                    max = sum;
                }
                index++;
            }
            return maxIndex;
        }
    }

    //dfs
    class Solution {
        private List<Integer> sum = new ArrayList<Integer>();

        public int maxLevelSum(TreeNode root) {
            dfs(root, 0);
            int ans = 0;
            for (int i = 0; i < sum.size(); ++i) {//遍历出最大的index
                if (sum.get(i) > sum.get(ans)) {
                    ans = i;
                }
            }
            return ans + 1;
        }

        private void dfs(TreeNode node, int level) {
            if (level == sum.size()) {//list链表自动扩容
                sum.add(node.val);
            } else {
                sum.set(level, sum.get(level) + node.val);//再次走到这一层就继续加
            }
            if (node.left != null) dfs(node.left, level + 1);
            if (node.right != null) dfs(node.right, level + 1);
        }
    }
}
