package com.feng.leetcode.hot100._04二叉树;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class h94二叉树的中序遍历 {

    //递归遍历
    class Solution11 {
        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return res;
        }

        List<Integer> res = new ArrayList<>();

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            res.add(root.val);
            dfs(root.right);
        }
    }

    //迭代（栈，从左往右）
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            //从左往右保存路过的node，这些node都是没有遍历右子树的
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;//先往左边遍历
                }else {
                    TreeNode mid = stack.pop();
                    res.add(mid.val);
                    cur = mid.right;//然后往右子树遍历
                }

            }
            return res;
        }
    }


}
