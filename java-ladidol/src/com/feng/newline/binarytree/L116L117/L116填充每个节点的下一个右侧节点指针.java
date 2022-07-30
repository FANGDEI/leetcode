package com.feng.newline.binarytree.L116L117;


import java.util.ArrayDeque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L116填充每个节点的下一个右侧节点指针
 * @author: Ladidol
 * @description: 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 * @date: 2022/7/29 20:59
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
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/