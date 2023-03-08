package com.feng.review.二叉树.特殊二叉树;


import java.util.ArrayDeque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L116填充每个节点的下一个右侧节点指针
 * @author: Ladidol
 * @description:
 * @date: 2022/7/29 20:59 2023年3月5日11:40:44
 * @version: 1.0
 */
public class L116填充每个节点的下一个右侧节点指针 {


    class Solution {
        public Node connect(Node root) {
            if (root == null) return root;
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int size = levelSize;
                int index = 0;
                while (levelSize-- > 0) {
                    Node curNode = queue.poll();
                    if (curNode.left != null) queue.offer(curNode.left);
                    if (curNode.right != null) queue.offer(curNode.right);
                    //连接每一层
                    if (index == size - 1) {
                        curNode.next = null;
                        break;
                    }
                    curNode.next = queue.peek();
                    index++;
                }
            }
            return root;
        }
    }
}