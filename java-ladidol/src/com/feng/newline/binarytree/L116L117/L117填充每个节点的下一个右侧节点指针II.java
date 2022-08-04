package com.feng.newline.binarytree.L116L117;

import java.util.ArrayDeque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree.L116L117
 * @className: L117填充每个节点的下一个右侧节点指针II
 * @author: Ladidol
 * @description: 给定一个二叉树
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 进阶：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 * @date: 2022/7/29 21:21
 * @version: 1.0
 */
public class L117填充每个节点的下一个右侧节点指针II {

    class Solution {
        public Node connect(Node root) {
            if (root == null) return root;
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                int size = levelSize;
                int levelIndex = 1;
                while (levelSize > 0) {
                    Node cur = queue.poll();
                    if (cur.left!=null) queue.offer(cur.left);
                    if (cur.right!=null) queue.offer(cur.right);
                    if (levelIndex == size) {//判断是否是这层最后一个
                        cur.next = null;
                        break;
                    }
                    cur.next = queue.peek();
                    levelIndex++;
                    levelSize--;
                }
            }
            return root;
        }
    }
}
