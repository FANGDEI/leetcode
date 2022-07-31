package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L572另一棵树的子树
 * @author: Ladidol
 * @description: 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * @date: 2022/7/31 13:31
 * @version: 1.0
 */
public class L572另一棵树的子树 {


    //通过100题解，暴力遍历破解。
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {


            ArrayDeque<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (isSameTree(cur, subRoot)) return true;
                if (cur.left!=null)queue.offer(cur.left);
                if (cur.right!=null)queue.offer(cur.right);
            }
            return false;
        }
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null || p.val != q.val) return false;
            boolean leftOne = isSameTree(p.left, q.left);
            boolean rightOne = isSameTree(p.right, q.right);
            return leftOne && rightOne;
        }
//        boolean isSameTree(TreeNode p, TreeNode q) {
//            Deque<TreeNode> queue = new LinkedList<>();
//            queue.offer(p);
//            queue.offer(q);
//            while (!queue.isEmpty()) {
//
//                TreeNode leftOne = queue.poll();
//                TreeNode rightOne = queue.poll();
//                if (leftOne == null && rightOne == null) continue;//都是没有不存在的节点，即为null的时候
//                if (leftOne == null || rightOne == null || leftOne.val != rightOne.val) return false;
//
//                queue.offer(leftOne.left);//注意这里的逻辑
//                queue.offer(rightOne.left);
//                queue.offer(leftOne.right);
//                queue.offer(rightOne.right);
//            }
//            return true;
//        }
    }

//    通过(树哈希) O(n)
        /*
    class Solution {
        public:
        // P、Q 取两个质数用于哈希左右子树，MOD 取模
        int P = 131, Q = 159, MOD = 1e7 + 7;
        // 初始化树的哈希值，取节点中不存在的一个值即可
        int T = 1e5;
        bool ans = false;

        int dfs(TreeNode* root) {
            // 为空子树设置一个哈希值，取节点中不存在的一个值即可
            if (!root) return 1e5 + 1;
            int left = dfs(root->left), right = dfs(root->right);
            // 计算当前节点的哈希值，将其转换成正数，规定哈希值是正的
            int x = (root->val % MOD + MOD) % MOD;
            // 计算左子树的哈希值和右子树的哈希值
            if (left == T || right == T) ans = true;
            // 计算当前树的哈希值
            return (x + left * P % MOD + right * Q) % MOD;
        }

        bool isSubtree(TreeNode* s, TreeNode* t) {
            T = dfs(t);
            // 只要两个树的哈希值一样就证明这两棵树一样
            if (T == dfs(s)) ans = true;
            return ans;
        }
    };
    */
}
