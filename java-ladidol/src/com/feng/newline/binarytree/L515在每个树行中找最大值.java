package com.feng.newline.binarytree;


import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L515在每个树行中找最大值
 * @author: Ladidol
 * @description:
 * @date: 2022/6/24 22:17
 * @version: 1.0
 */
public class L515在每个树行中找最大值 {
    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    class Solution {
        //层序遍历 2022年7月29日20:56:26再做到这个题.
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) return res;
            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int max = Integer.MIN_VALUE;//-2^32;
                int levelSize = queue.size();
                while (levelSize > 0) {
                    //对该层的每一个节点的子节点都进行遍历!
                    TreeNode cur = queue.poll();
                    max = Math.max(max, cur.val);
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                    levelSize--;
                }
                res.add(max);
            }
            return res;
        }
    }


    class L515 {
        //层序遍历
        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                //Collections.emptyList()是空链表
                return Collections.emptyList();
            }
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            //第一步先把根节点放进去!
            queue.offer(root);
            while (!queue.isEmpty()) {
                //只要不为空就继续向它子节点遍历!
                int max = Integer.MIN_VALUE;//-2^32;
                for (int i = queue.size(); i > 0; i--) {
                    //对该层的每一个节点的子节点都进行遍历!
                    TreeNode currentNode = queue.poll();
                    max = Math.max(max, currentNode.val);
                    if (currentNode.left != null) queue.add(currentNode.left);
                    if (currentNode.right != null) queue.add(currentNode.right);
                }
                result.add(max);
            }
            return result;
        }
    }


}
