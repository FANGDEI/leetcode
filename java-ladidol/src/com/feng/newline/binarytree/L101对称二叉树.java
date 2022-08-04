package com.feng.newline.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L101对称二叉树
 * @author: Ladidol
 * @description: 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * @date: 2022/7/30 13:05
 * @version: 1.0
 */
public class L101对称二叉树 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left= null;
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
//        System.out.println(new Solution().isSymmetric(root));
    }


    //dfs 递归，如果对左右子树进行比较。
    class Solution2 {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;//或者是false
            return compare(root.left,root.right);

        }
        boolean compare(TreeNode leftNode, TreeNode rightNode){
            if (leftNode == null && rightNode == null) return true;//null == null
            if (leftNode == null || rightNode == null) return false;//只有一个是null
            if (leftNode.val != rightNode.val) return false;
            boolean outSide = compare(leftNode.left, rightNode.right);
            boolean inSide = compare(leftNode.right, rightNode.left);
            return outSide && inSide;
        }
    }

    //bfs 双指针的样子，对称行动，从外面向内部移动。
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;//或者是false
//            ArrayDeque<TreeNode> queue = new ArrayDeque<>();//为啥会出现这种情况，ArrayDeque和Deque有啥子区别
            Deque<TreeNode> queue = new LinkedList<>();//我超有啥子区别啊。
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {

                TreeNode leftOne = queue.poll();
                TreeNode rightOne = queue.poll();
                if (leftOne == null && rightOne == null) continue;//都是没有不存在的节点，即为null的时候
                if (leftOne == null || rightOne == null || leftOne.val != rightOne.val) return false;

//            if (leftOne.left!=null)queue.offer(leftOne.left);//懂了这里用ArrayDeque要先判断加入进去的是不是null， 如果是空的话源码部分会报错。
//            if (rightOne.right!=null)queue.offer(rightOne.right);//但是null子节点不能计入进去的话对于[1,2,2,null,3,null,3]这样的root就会判断失误。
//            if (leftOne.right!=null)queue.offer(leftOne.right);
//            if (rightOne.left!=null)queue.offer(rightOne.left);
                queue.offer(leftOne.left);//懂了这里用ArrayDeque要先判断加入进去的是不是null， 如果是空的话源码部分会报错。
                queue.offer(rightOne.right);//list可以不用判断que是不是负数，所以要常用尽量用LinkedList实现类吧
                queue.offer(leftOne.right);
                queue.offer(rightOne.left);
            }
            return true;
        }
    }


}


