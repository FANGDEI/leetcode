package com.feng.newline.binarytree;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L94二叉树的中序遍历
 * @author: Ladidol
 * @description:
 * @date: 2022/7/29 15:01
 * @version: 1.0
 */
public class L94二叉树的中序遍历 {
    //递归方式
    class Solution1 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
        }

        void inorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            inorder(root.left, res);//前
            res.add(root.val);//中
            inorder(root.right, res);//后
        }
    }

    //通过栈实现迭代中序遍历
    //因为中序遍历的特殊性, 不是前序遍历简单就能转化过来的,需要多加修改.
    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
    class Solution132 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {//判断条件多了一个当前节点不为空, 是因为可能左边最大子树遍历完后的情况
                if (cur != null) {
                    stack.push(cur);//压栈
                    cur = cur.left;//继续深入   //左
                } else {
                    //开始返回了
                    cur = stack.pop();// 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                    res.add(cur.val);//中
                    cur = cur.right;//右
                }
            }
            return res;
        }
    }

    //递归
    class Solution {//2022年10月19日16:47:09复习

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return res;
        }

        List<Integer> res = new ArrayList<>();

        void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            res.add(root.val);
            dfs(root.right);
        }
    }

    //栈模拟 迭代
    class Solution12 {//2023年4月27日15:48:22复习

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            Deque<TreeNode> stack =  new ArrayDeque<>();
            TreeNode cur = root;
            //注意遍历到null的节点，就表示到一条线的底部了
            while (cur != null || !stack.isEmpty()) {
                if (cur!=null){
                    //往左边深入
                    stack.push(cur);
                    cur = cur.left;//【左】
                }else{
                    //如果当前为空就证明dfs到底了
                    TreeNode pop = stack.pop();

                    res.add(pop.val);//【中】
                    cur = pop.right;//【右】
                }
            }
            return res;
        }
    }


}
