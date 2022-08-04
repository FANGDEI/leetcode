package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {//判断条件多了一个当前节点不为空, 是因为可能左边最大子树遍历完后的情况
                if (cur != null){
                    stack.push(cur);//压栈
                    cur = cur.left;//继续深入   //左
                }else{
                    //开始返回了
                    cur = stack.pop();// 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                    res.add(cur.val);//中
                    cur = cur.right;//右
                }
            }
            return res;
        }
    }


}
